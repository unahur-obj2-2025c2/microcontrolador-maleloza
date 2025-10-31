package ar.unahur.edu.obj2.patroncommand.Operables;

import ar.unahur.edu.obj2.patroncommand.Programable;

public class STR implements Operable{
    private final Integer direccion;

    public STR(Integer direccion) {
        this.direccion = direccion;
    }

    @Override 
    public void execute(Programable micro){
        micro.setAddr(direccion);
    }
}
