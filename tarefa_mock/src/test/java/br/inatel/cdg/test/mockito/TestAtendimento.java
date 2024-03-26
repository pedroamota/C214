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
import static org.junit.Assert.assertTrue;

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
     public void testBuscaProfessoresError() {
     Mockito.when(atendimentoService.busca("Soned")).thenReturn(ProfessorConst.SONED);

     Professor professor = buscaAtendimento.buscaProfessores("Rafael");
     
     assertEquals(null , professor);
     }
     

    @Test
    public void testPredioAtendimento1() {
        Mockito.when(atendimentoService.busca("Soned")).thenReturn(ProfessorConst.SONED);
        Professor professor = buscaAtendimento.buscaProfessores("Soned");

        int predio = buscaAtendimento.verificaAtendimento(professor.getSala());

        assertEquals(0, predio);
    }

    @Test
    public void testPredioAtendimento2() {
        Mockito.when(atendimentoService.busca("Soned")).thenReturn(ProfessorConst.SONED);
        Professor professor = buscaAtendimento.buscaProfessores("Soned");

        int predio = buscaAtendimento.verificaAtendimento(professor.getSala());

        assertEquals(0, predio);
    }

    @Test
    public void testPredioAtendimento3() {
        Mockito.when(atendimentoService.busca("Soned")).thenReturn(ProfessorConst.SONED);
        Professor professor = buscaAtendimento.buscaProfessores("Soned");

        int predio = buscaAtendimento.verificaAtendimento(professor.getSala());

        assertEquals(0, predio);
    }

    @Test
    public void testPredioAtendimento4() {
        Mockito.when(atendimentoService.busca("Soned")).thenReturn(ProfessorConst.SONED);
        Professor professor = buscaAtendimento.buscaProfessores("Soned");

        int predio = buscaAtendimento.verificaAtendimento(professor.getSala());

        assertEquals(0, predio);
    }

    @Test
    public void testPredioAtendimento5() {
        Mockito.when(atendimentoService.busca("Soned")).thenReturn(ProfessorConst.SONED);
        Professor professor = buscaAtendimento.buscaProfessores("Soned");

        int predio = buscaAtendimento.verificaAtendimento(professor.getSala());

        assertEquals(0, predio);
    }

    @Test
    public void testPredioAtendimento6() {
        Mockito.when(atendimentoService.busca("Soned")).thenReturn(ProfessorConst.SONED);
        Professor professor = buscaAtendimento.buscaProfessores("Soned");

        int predio = buscaAtendimento.verificaAtendimento(professor.getSala());

        assertEquals(0, predio);
    }

    @Test
    public void testPredioAtendimentoError() {
        Mockito.when(atendimentoService.busca("Soned")).thenReturn(ProfessorConst.SONED);
        Professor professor = buscaAtendimento.buscaProfessores("Soned");

        int predio = buscaAtendimento.verificaAtendimento(professor.getSala());

        assertEquals(0, predio);
    }
}
