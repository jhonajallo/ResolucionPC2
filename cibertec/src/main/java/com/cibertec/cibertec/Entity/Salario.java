package com.cibertec.cibertec.Entity;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="salarios")
public class Salario {
    @Id
    @Column(name = "salario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salario_id;
    @Column(name="empleado_id")
    private int empleado_id;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Lima")
    private Date fecha_pago;
    @Column(name ="monto")
    private double monto;

}
