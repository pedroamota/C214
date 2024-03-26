package br.inatel.cdg.test;

import br.inatel.cdg.AtendimentoService;

public class MockAtendimentoService implements AtendimentoService{

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
        }else{
            predio = -1;
        }

        return predio;
    }

    @Override
    public String busca(String nomeProfessor) {
        String professor;

         if(nomeProfessor == "Soned"){
            professor = ProfessorConst.SONED;
         }else if(nomeProfessor == "Chris"){
            professor = ProfessorConst.CHRIS;
         }else if(nomeProfessor == "Chris"){
            professor = ProfessorConst.RENZO;
         }else if(nomeProfessor == "Chris"){
            professor = ProfessorConst.KIKO;
         }else if(nomeProfessor == "Chris"){
            professor = ProfessorConst.VITORIA;
         }else{
            throw new UnsupportedOperationException("Não existe esse professor no INATEL");
         }

        return professor;
    }

    
}