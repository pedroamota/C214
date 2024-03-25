package br.inatel.cdg;

import java.util.ArrayList;

public class Professor {
    private String nomeProfessor;
    private String horarioAtendimento;
    private String periodo;
    private int sala;
    private ArrayList<Integer> predio;

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public String getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public String getPeriodo() {
        return periodo;
    }

    public int getSala() {
        return sala;
    }

    public ArrayList<Integer> getPredio() {
        return predio;
    }

    public Professor(String nomeProfessor, String horarioAtendimento, String periodo, int sala,
            ArrayList<Integer> predio) {
        this.nomeProfessor = nomeProfessor;
        this.horarioAtendimento = horarioAtendimento;
        this.periodo = periodo;
        this.sala = sala;
        this.predio = predio;
    }   
}
