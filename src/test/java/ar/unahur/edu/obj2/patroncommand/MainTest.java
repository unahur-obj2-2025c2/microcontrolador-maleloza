package ar.unahur.edu.obj2.patroncommand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unahur.edu.obj2.patroncommand.Operables.*;

public class MainTest {
    Microcontrolador microcontrolador = new Microcontrolador();

    @BeforeEach
    void setUp(){
        microcontrolador.reset();
    }

    @Test
    void hacerAvanzar3PosicionesElProgramCounter() {
        List<Operable> programa = List.of(new NOP(), new NOP(), new NOP());
        microcontrolador.run(programa);
        assertEquals(3, microcontrolador.getProgramCounter());
    }

    @Test 
    void sumar10Mas17EnAcumuladorA() {
        List<Operable> programa = List.of(new LODV(20), new SWAP(), new LODV(17), new ADD());
        microcontrolador.run(programa);

        assertEquals(37, microcontrolador.getAcumuladorA());
        assertEquals(0, microcontrolador.getAcumuladorB());
        assertEquals(4, microcontrolador.getProgramCounter());
    }

    @Test
    void sumar1Mas8Mas5UsandoMemoria(){
        List<Operable> programa = List.of(new LODV(2), new STR(0), new LODV(8), new SWAP(), new LODV(5), new ADD(), new SWAP(), new LOD(0), new ADD());
        microcontrolador.run(programa);

        assertEquals(15, microcontrolador.getAcumuladorA());
        assertEquals(0, microcontrolador.getAcumuladorB());
    }
}
