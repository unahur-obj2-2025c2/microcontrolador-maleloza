package ar.unahur.edu.obj2.patroncommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.Operables.MicroMemento;
import ar.unahur.edu.obj2.patroncommand.Operables.Operable;


public class Microcontrolador implements Programable{
    private List<Integer> memoria = Arrays.asList(new Integer[1024]);
    private Integer acumuladorA;
    private Integer acumuladorB;
    private Integer programCounter;
    private List<MicroMemento> historial = new ArrayList<>();

    public Microcontrolador(){
        reset();
    }

    @Override
    public void run(List<Operable> operaciones){
        programCounter = 0;
        while (programCounter < operaciones.size()) {
            Operable operacion = operaciones.get(programCounter);
            try {
                guardarEstado();
                operacion.execute(this);
                incProgramCounter();
            } catch (Exception e) {
                throw new RuntimeException("Error en instrucción #" + programCounter + ": " + e.getMessage(), e);
            }
        }
    }

    @Override
    public void incProgramCounter() { programCounter++; }

    @Override
    public Integer getProgramCounter() { return programCounter; }

    @Override
    public void setAcumuladorA(Integer value) { acumuladorA = value; }

    @Override
    public Integer getAcumuladorA() { return acumuladorA; }

    @Override
    public void setAcumuladorB(Integer value) { acumuladorB = value; }

    @Override
    public Integer getAcumuladorB() { return acumuladorB; }

    @Override
    public void setAddr(Integer addr) { 
        validarDireccion(addr);
        memoria.set(addr, acumuladorA);
    }

    @Override
    public Integer getAddr(Integer addr) { 
        validarDireccion(addr);
        return memoria.get(addr);
    }

    @Override 
    public void reset(){
        memoria = Arrays.asList(new Integer[1024]);
        acumuladorA = 0;
        acumuladorB = 0;
        programCounter = 0;
    }

    private void validarDireccion(Integer addr) {
        if (addr < 0 || addr >= memoria.size()) {
            throw new IllegalArgumentException("Dirección fuera de rango: " + addr);
        }
    }

    public void guardarEstado() {
        historial.add(new MicroMemento(memoria, acumuladorA, acumuladorB, programCounter));
    }

    public void undo(){
        if (!historial.isEmpty()){
            MicroMemento previo = historial.remove(historial.size() - 1);
            restaurarEstado(previo);
        }
    }

    public void restaurarEstado(MicroMemento memento) {
        acumuladorB = memento.getAcumuladorB();
        acumuladorA = memento.getAcumuladorA();
        programCounter = memento.getProgramCounter();
        List<Integer> snapshot = memento.getMemoria();
        for (int i = 0; i < memoria.size(); i++){
            memoria.set(i, snapshot.get(i));
        }

    }
}
