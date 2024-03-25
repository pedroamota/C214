package main;

import test.Atendimento;

public class BuscaAtendimento implements AtendimentoService {

    @Override
    public int predioAtendimento(int sala) {
        int predio = 0;

        if (sala >= 26 && sala <= 30) {
            predio = 6;
        } else if (sala >= 21) {
            predio = 5;
        } else if (sala >= 16) {
            predio = 4;
        } else if (sala >= 11) {
            predio = 3;
        } else if (sala >= 6) {
            predio = 2;
        } else if (sala >= 1) {
            predio = 1;
        }

        return predio;
    }

    @Override
    public Professor buscaProfessores(String professor) {
        Response data = api.get(professor);
    
        Professor prof = new Professor(
            data.getNome(),  
            data.getHorario(),  
            data.getPeriodo(),  
            data.getSala(), 
            data.getPredio()  
        );
    
        return prof;
    }
    

}