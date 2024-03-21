package test.mockito;

public class TesteAtendimentos{

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class TesteAtendimentos {

    @Mock
    private AtendimentoService service;
    private BuscaAtendimento buscaAtendimento;

    @Before
    public void setup(){
        buscaAtendimento = new BuscaAtendimento(service);
    }

    @Test
    public void testeBuscaAtendimentoSoned(){
        Mockito.when(service.buscaAtendimento(55)).thenReturn(AtendimentoConst.Soned);

        Atendimento soned = buscaAtendimento.buscaAtendimento(55);
        //Faz assertion
        assertEquals("Soned", soned.getNomeProfessor());
        assertEquals("18:00", soned.getHorarioAtendimento(), 0.1);
        assertEquals("Noturno", skeleton.getPeriodo);
        assertEquals(5, soned.getSala);
        assertEquals(1, soned.getPredio);
        
    }

    @Test
    public void testeBuscaAtendimentoInvalido(){
        Mockito.when(service.buscaAtendimento(56)).thenReturn(AtendimentoConst.AUSENTE);

        Atendimento soned = buscaAtendimento.buscaAtendimento(56);
        //Faz assertion
        assertEquals("Inexistente", soned.getNomeProfessor());
        assertEquals("19:00", soned.getHorarioAtendimento, 0.1);
        assertEquals("Ausente", soned.getPeriodo);

    }

    @Test
    public void testeBuscaAtendimentoValido(){

        Mockito.when(service.atendimentoExistente(10)).thenReturn(true);
        //Faz a busca de um inimigo válido (id = 10 ou id = 20 ou ID positivo)
        boolean atendimentoValido = service.atendimentoExistente(10);

        assertTrue(atendimentoValido);
    }
}
}
