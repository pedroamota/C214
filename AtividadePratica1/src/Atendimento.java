import java.util.ArrayList;

public class Atendimento {
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
/*
1: 1 - 5
2: 6 - 10
3: 11 - 15
4: 16 - 20
5: 21 - 25
6: 26 - 30
 */

    public Atendimento(String nomeProfessor, String horarioAtendimento, String periodo, int sala,
            ArrayList<Integer> predio) {
        this.nomeProfessor = nomeProfessor;
        this.horarioAtendimento = horarioAtendimento;
        this.periodo = periodo;
        this.sala = sala;
        this.predio = predio;
    }

    int predioAtendimento(int sala){
        int predio = 0;

        if(sala >= 26 && sala <= 30){
            predio = 6;
        }else if(sala >= 21){
            predio = 5;
        }else if(sala >= 16){
            predio = 4;
        }else if(sala >= 11){
            predio = 3;
        }else if(sala >= 6){
            predio = 2;
        }else if(sala >= 1){
            predio = 1;
        }
        
        return predio;
    }

   
}
