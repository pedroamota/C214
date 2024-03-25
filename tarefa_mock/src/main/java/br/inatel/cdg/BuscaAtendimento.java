package br.inatel.cdg;

import com.google.gson.Gson;

public class BuscaAtendimento{
    AtendimentoService atendimentoService;

    public BuscaAtendimento(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
    }



    public int verificaAtendimento(int sala) {

        int predio = atendimentoService.predioAtendimento(sala);

        return predio;
    }


    public Professor buscaProfessores(String nomeProfessor) {

        String professorJson = atendimentoService.busca(nomeProfessor);
        
        Gson gson = new Gson();

        Professor professor = gson.fromJson(professorJson, Professor.class);

        return professor;
    }
}
