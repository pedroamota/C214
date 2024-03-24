package test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HorarioAtendimentoServiceTest {
    private HorarioAtendimentoService service;

    @BeforeEach
    public void setUp() {
        service = new HorarioAtendimentoService();
    }

    @Nested
    @DisplayName("Testes de sucesso")
    class TestesDeSucesso {
        @RepeatedTest(10)
        public void testeDeSucesso() throws ExecutionException, InterruptedException {
            CompletableFuture<String> jsonFuture = service.getHorarioAtendimento();
            String json = jsonFuture.get();
            assertNotNull(json);
            assertTrue(service.popularPagina(json));
        }
    }

    @Nested
    @DisplayName("Testes de falha")
    class TestesDeFalha {
        @RepeatedTest(10)
        public void testeDeFalha() {
            assertThrows(ExecutionException.class, () -> service.getHorarioAtendimento().get());
            assertFalse(service.popularPagina(null));
        }
    }
}
