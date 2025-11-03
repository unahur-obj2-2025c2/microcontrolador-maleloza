package ar.unahur.edu.obj2.patroncommand.Operables;

import java.util.ArrayList;
import java.util.List;

public class MicroMemento {
    private List<Integer> memoria;
    private Integer acumuladorA;
    private Integer acumuladorB;
    private Integer programCounter;

    public MicroMemento(List<Integer> memoria, Integer acumuladorA, Integer acumuladorB, Integer programCounter) {
        this.memoria = new ArrayList<>(memoria);
        this.acumuladorA = acumuladorA;
        this.acumuladorB = acumuladorB;
        this.programCounter = programCounter;
    }

    public List<Integer> getMemoria() { return memoria; }

    public Integer getAcumuladorA() { return acumuladorA; }

    public Integer getAcumuladorB() { return acumuladorB; }

    public Integer getProgramCounter() { return programCounter; }
}
