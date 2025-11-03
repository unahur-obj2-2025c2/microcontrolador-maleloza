package ar.unahur.edu.obj2.patroncommand.Operables;

import ar.unahur.edu.obj2.patroncommand.Programa;
import ar.unahur.edu.obj2.patroncommand.Programable;

public class IFNZ implements Operable{
    private Programa instrucciones;

    public IFNZ(Programa instrucciones){
        this.instrucciones = instrucciones;
    }

    @Override 
    public void execute(Programable micro){
        if (micro.getAcumuladorA() != 0) {
            instrucciones.ejecutar(micro);
        }
    }
}
