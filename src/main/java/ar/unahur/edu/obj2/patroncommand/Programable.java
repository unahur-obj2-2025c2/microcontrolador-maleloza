package ar.unahur.edu.obj2.patroncommand;

import java.util.List;

import ar.unahur.edu.obj2.patroncommand.Operables.Operable;

public interface Programable {
    void run(List<Operable> operaciones);

    void incProgramCounter();

    Integer getProgramCounter();

    void setAcumuladorA(Integer value);

    Integer getAcumuladorA();

    void setAcumuladorB(Integer value);

    Integer getAcumuladorB();

    void setAddr(Integer addr);

    Integer getAddr(Integer addr);

    void reset();
}
