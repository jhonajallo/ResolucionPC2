package com.cibertec.cibertec.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.cibertec.Entity.Salario;
import com.cibertec.cibertec.Repository.SalarioRepository;

@Service
public class ServiceSalarioImpl implements ServiceSalario {

    @Autowired
    private SalarioRepository salRepo;
    @Override
    public List<Salario> listaTodos() {
        return salRepo.findAll();
    }

    @Override
    public Optional<Salario> obtenerPorId(int id) {
       return salRepo.findById(id);
    }

    @Override
    public Salario agregarActualizSalario(Salario salario) {
        return salRepo.save(salario);
    }

    @Override
    public void eliminarSalario(int id) {
        salRepo.deleteById(id);
    }

    
}
