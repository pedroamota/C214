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
//import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class TestAtendimento {

    @Mock
    private AtendimentoService atendimentoService;
    private BuscaAtendimento buscaAtendimento;

    @Before
    public void setup() {
        buscaAtendimento = new BuscaAtendimento(atendimentoService);

    }

    @Test
    public void testBuscaProfessores() {
        Mockito.when(atendimentoService.busca("Soned")).thenReturn(ProfessorConst.SONED);

        Professor professor = buscaAtendimento.buscaProfessores("Soned");

        assertEquals("Soned", professor.getNomeProfessor());
        assertEquals("10:00-11:40", professor.getHorarioAtendimento());
        assertEquals("integral", professor.getPeriodo());
        assertEquals(1, professor.getSala());
    }

    @Test
    public void testBuscaProfessores() {
        Mockito.when(servico.buscar("Vitoria")).thenReturn(ProfessorConst.VITORIA);

        Professor professor = servico.buscarProfessores("Vitoria");

        // Verificações
        assertEquals("Vitoria", professor.getNomeProfessor());
        assertEquals("19:30-21:10", professor.getHorarioAtendimento());
        assertEquals("noturno", professor.getPeriodo());
        assertEquals(2, professor.getSala());
    }

    @Test
    public void testBuscaProfessores() {
        Mockito.when(servico.buscar("Kiko")).thenReturn(ProfessorConst.KIKO);

        Professor professor = servico.buscarProfessores("Kiko");

        // Verificações
        assertEquals("Kiko", professor.getNomeProfessor());
        assertEquals("13:30-15:10", professor.getHorarioAtendimento());
        assertEquals("integral", professor.getPeriodo());
        assertEquals(3, professor.getSala());
    }

    @Test
    public void testBuscaProfessores() {
        Mockito.when(servico.buscar("Renzo")).thenReturn(ProfessorConst.RENZO);

        Professor professor = servico.buscarProfessores("Renzo");

        // Verificações
        assertEquals("Renzo", professor.getNomeProfessor());
        assertEquals("21:30-23:10", professor.getHorarioAtendimento());
        assertEquals("noturno", professor.getPeriodo());
        assertEquals(4, professor.getSala());
    }


     @Test
     public void testBuscaProfessoresError() {
     Mockito.when(atendimentoService.busca("Soned")).thenReturn(ProfessorConst.SONED);

     Professor professor = buscaAtendimento.buscaProfessores("Rafael");
     
     assertEquals(null , professor);
     }
     

    @Test
    public void testPredioAtendimento1() {
        Mockito.when(atendimentoService.predioAtendimento(2)).thenReturn(1);

        int predio = buscaAtendimento.verificaAtendimento(2);

        assertEquals(1, predio);
    }

    @Test
    public void testPredioAtendimento2() {
        Mockito.when(atendimentoService.predioAtendimento(7)).thenReturn(2);

        int predio = buscaAtendimento.verificaAtendimento(7);

        assertEquals(2, predio);
    }

    @Test
    public void testPredioAtendimento3() {
        Mockito.when(atendimentoService.predioAtendimento(12)).thenReturn(3);

        int predio = buscaAtendimento.verificaAtendimento(12);

        assertEquals(3, predio);
    }

    @Test
    public void testPredioAtendimento4() {
        Mockito.when(atendimentoService.predioAtendimento(17)).thenReturn(4);

        int predio = buscaAtendimento.verificaAtendimento(17);

        assertEquals(4, predio);
    }

    @Test
    public void testPredioAtendimento5() {
        Mockito.when(atendimentoService.predioAtendimento(22)).thenReturn(5);

        int predio = buscaAtendimento.verificaAtendimento(22);

        assertEquals(5, predio);
    }

    @Test
    public void testPredioAtendimento6() {
        Mockito.when(atendimentoService.predioAtendimento(27)).thenReturn(6);

        int predio = buscaAtendimento.verificaAtendimento(27);

        assertEquals(6, predio);
    }

    @Test
    public void testPredioAtendimentoError() {
        Mockito.when(atendimentoService.predioAtendimento(45)).thenReturn(-1);

        int predio = buscaAtendimento.verificaAtendimento(45);

        assertEquals(-1, predio);
    }
}
