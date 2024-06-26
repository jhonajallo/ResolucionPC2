package com.cibertec.cibertec.Service;

import java.util.List;
import java.util.Optional;

import com.cibertec.cibertec.Entity.Salario;

public interface ServiceSalario {

    public abstract List<Salario> listaTodos();
    public abstract Optional<Salario> obtenerPorId(int id);
    public abstract Salario agregarActualizSalario (Salario salario);
    public abstract void eliminarSalario(int id);

    
}
