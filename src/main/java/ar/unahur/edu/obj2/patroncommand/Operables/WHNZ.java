package ar.unahur.edu.obj2.patroncommand.Operables;

import ar.unahur.edu.obj2.patroncommand.Programa;
import ar.unahur.edu.obj2.patroncommand.Programable;

public class WHNZ implements Operable{
    private Programa instrucciones;

    public WHNZ(Programa instrucciones){
        this.instrucciones = instrucciones;
    }

    @Override 
    public void execute(Programable micro){
        while (micro.getAcumuladorA() != 0) {
            instrucciones.ejecutar(micro);
        }
    }
}
