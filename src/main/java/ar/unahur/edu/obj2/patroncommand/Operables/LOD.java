package ar.unahur.edu.obj2.patroncommand.Operables;

import ar.unahur.edu.obj2.patroncommand.Programable;

public class LOD implements Operable{
    private Integer direccion;

    public LOD(Integer direccion) {
        this.direccion = direccion;
    }

    @Override 
    public void execute(Programable micro){
        micro.setAcumuladorA(micro.getAddr(direccion));
    }
}
