package ar.unahur.edu.obj2.patroncommand.Operables;

import ar.unahur.edu.obj2.patroncommand.Programable;

public class ADD implements Operable{
    @Override 
    public void execute(Programable micro){
        Integer resultado = micro.getAcumuladorA() + micro.getAcumuladorB();
        micro.setAcumuladorA(resultado);
        micro.setAcumuladorB(0);
    }
}
