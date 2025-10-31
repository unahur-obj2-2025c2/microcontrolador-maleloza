package ar.unahur.edu.obj2.patroncommand.Operables;

import ar.unahur.edu.obj2.patroncommand.Programable;

public class LODV implements Operable{
    private final Integer valor;

    public LODV(Integer valor) {
        this.valor = valor;
    }

    @Override 
    public void execute(Programable micro){
        micro.setAcumuladorA(valor);
    }
}
