package br.inatel.cdg.test.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.inatel.cdg.AtendimentoService;
import br.inatel.cdg.BuscaAtendimento;
import br.inatel.cdg.Professor;
import br.inatel.cdg.test.ProfessorConst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class TestAtendimento {

    @Mock
    private AtendimentoService atendimentoService;
    private BuscaAtendimento buscaAtendimento;

    @Before
    public void setup() {
        buscaAtendimento = new BuscaAtendimento(atendimentoService);
    }

    // Testes de acerto
    // 1
    @Test
    public void testBuscaProfessorSoned() {
        Mockito.when(atendimentoService.busca("Soned")).thenReturn(ProfessorConst.SONED);

        Professor professor = buscaAtendimento.buscaProfessores("Soned");

        assertEquals("Soned", professor.getNomeProfessor());
        assertEquals("10:00-11:40", professor.getHorarioAtendimento());
        assertEquals("integral", professor.getPeriodo());
        assertEquals(1, professor.getSala());
    }

    // 2
    @Test
    public void testBuscaProfessorVitoria() {
        Mockito.when(atendimentoService.busca("Vitoria")).thenReturn(ProfessorConst.VITORIA);

        Professor professor = buscaAtendimento.buscaProfessores("Vitoria");

        // Verificações
        assertEquals("Vitoria Dala", professor.getNomeProfessor());
        assertEquals("19:30-21:10", professor.getHorarioAtendimento());
        assertEquals("noturno", professor.getPeriodo());
        assertEquals(3, professor.getSala());
    }

    // 3
    @Test
    public void testBuscaProfessorKiko() {
        Mockito.when(atendimentoService.busca("Kiko")).thenReturn(ProfessorConst.KIKO);

        Professor professor = buscaAtendimento.buscaProfessores("Kiko");

        // Verificações
        assertEquals("Kiko Augusto", professor.getNomeProfessor());
        assertEquals("13:30-15:10", professor.getHorarioAtendimento());
        assertEquals("integral", professor.getPeriodo());
        assertEquals(4, professor.getSala());
    }

    // 4
    @Test
    public void testBuscaProfessorRenzo() {
        Mockito.when(atendimentoService.busca("Renzo")).thenReturn(ProfessorConst.RENZO);

        Professor professor = buscaAtendimento.buscaProfessores("Renzo");

        // Verificações
        assertEquals("Renzo Mesquita", professor.getNomeProfessor());
        assertEquals("21:30-23:10", professor.getHorarioAtendimento());
        assertEquals("noturno", professor.getPeriodo());
        assertEquals(5, professor.getSala());
    }

    // 5
    @Test
    public void testPredioAtendimento1() {
        Mockito.when(atendimentoService.predioAtendimento(2)).thenReturn(1);

        int predio = buscaAtendimento.verificaAtendimento(2);

        assertEquals(1, predio);
    }

    // 6
    @Test
    public void testPredioAtendimento2() {
        Mockito.when(atendimentoService.predioAtendimento(7)).thenReturn(2);

        int predio = buscaAtendimento.verificaAtendimento(7);

        assertEquals(2, predio);
    }

    // 7
    @Test
    public void testPredioAtendimento3() {
        Mockito.when(atendimentoService.predioAtendimento(12)).thenReturn(3);

        int predio = buscaAtendimento.verificaAtendimento(12);

        assertEquals(3, predio);
    }

    // 8
    @Test
    public void testPredioAtendimento4() {
        Mockito.when(atendimentoService.predioAtendimento(17)).thenReturn(4);

        int predio = buscaAtendimento.verificaAtendimento(17);

        assertEquals(4, predio);
    }

    // 9
    @Test
    public void testPredioAtendimento5() {
        Mockito.when(atendimentoService.predioAtendimento(22)).thenReturn(5);

        int predio = buscaAtendimento.verificaAtendimento(22);

        assertEquals(5, predio);
    }

    // 10
    @Test
    public void testPredioAtendimento6() {
        Mockito.when(atendimentoService.predioAtendimento(27)).thenReturn(6);

        int predio = buscaAtendimento.verificaAtendimento(27);

        assertEquals(6, predio);
    }

    // Teste de erro

    // 1
    @Test
    public void testBuscaProfessoresError() {
        Mockito.when(atendimentoService.busca("Soned")).thenReturn(ProfessorConst.SONED);

        Professor professor = buscaAtendimento.buscaProfessores("Rafael");

        assertNull(professor);
    }

    // 2
    @Test
    public void testBuscaProfessorErrorRenzo() {
        Mockito.when(atendimentoService.busca("Renzo")).thenReturn(ProfessorConst.RENZO);

        Professor professor = buscaAtendimento.buscaProfessores("Soned");

        assertNull(professor);
    }

    // 3
    @Test
    public void testBuscaProfessorErrorVitoria() {
        Mockito.when(atendimentoService.busca("Vitoria")).thenReturn(ProfessorConst.RENZO);

        Professor professor = buscaAtendimento.buscaProfessores("Victoria");

        assertNull(professor);
    }

    // 4
    @Test
    public void testBuscaProfessorErrorNum() {
        Mockito.when(atendimentoService.busca("Vitoria")).thenReturn(ProfessorConst.RENZO);

        Professor professor = buscaAtendimento.buscaProfessores("980908098098");

        assertNull(professor);
    }

    // 5
    @Test
    public void testBuscaProfessorErrorCaracters() {
        Mockito.when(atendimentoService.busca("Vitoria")).thenReturn(ProfessorConst.RENZO);

        Professor professor = buscaAtendimento.buscaProfessores("*****");

        assertNull(professor);
    }

    // 6
    @Test
    public void testPredioAtendimentoError() {
        Mockito.when(atendimentoService.predioAtendimento(45)).thenReturn(-1);

        int predio = buscaAtendimento.verificaAtendimento(45);

        assertEquals(-1, predio);
    }

    // 7
    @Test
    public void testPredioAtendimentoErrorNegative() {
        Mockito.when(atendimentoService.predioAtendimento(-42)).thenReturn(-1);

        int predio = buscaAtendimento.verificaAtendimento(-42);

        assertEquals(-1, predio);
    }

    // 8
    @Test
    public void testPredioAtendimentoErrorZero() {
        Mockito.when(atendimentoService.predioAtendimento(0)).thenReturn(-1);

        int predio = buscaAtendimento.verificaAtendimento(0);

        assertEquals(-1, predio);
    }

    // 9
    @Test
    public void testPredioAtendimentoErrorMax() {
        Mockito.when(atendimentoService.predioAtendimento(Integer.MAX_VALUE)).thenReturn(-1);

        int predio = buscaAtendimento.verificaAtendimento(Integer.MAX_VALUE);

        assertEquals(-1, predio);
    }

    // 10
    @Test
    public void testPredioAtendimentoErrorMin() {
        Mockito.when(atendimentoService.predioAtendimento(Integer.MIN_VALUE)).thenReturn(-1);

        int predio = buscaAtendimento.verificaAtendimento(Integer.MIN_VALUE);

        assertEquals(-1, predio);
    }

}
