package ar.unahur.edu.obj2.patroncommand;

import java.util.List;

import ar.unahur.edu.obj2.patroncommand.Operables.Operable;

public class Programa {
    private List<Operable> instrucciones;

    public Programa(List<Operable> isntrucciones) {
        this.instrucciones = instrucciones;
    }

    public void ejecutar(Programable microcontrolador) {
        for (Operable op : instrucciones){
            op.execute(microcontrolador);
        }
    }
}
