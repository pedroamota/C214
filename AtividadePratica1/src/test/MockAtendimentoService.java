package test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import main.AtendimentoService;
import main.BuscaAtendimento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AtendimentoServiceTest {

    @Mock
    private AtendimentoService atendimentoService;
    private BuscaAtendimento buscaAtendimento;

    @Before
    public void setup(){
        buscaAtendimento = new BuscaAtendimento(atendimentoService);
    }

    @Test
    public void testBuscaProfessores() {
        Mockito.when(atendimentoService.buscaProfessores("Soned")).thenReturn(ProfessorConst.SONED);

        Professor professor = buscaAtendimento.buscaProfessores("Soned");

        // Verificações
        assertEquals("Soned", professor.getNomeProfessor());
        assertEquals("10:00", professor.getHorarioAtendimento());
        assertEquals("integral", professor.getPeriodo());
        assertEquals(1, professor.getSala());
    }
}
