package com.cibertec.cibertec.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.cibertec.Entity.Salario;
import com.cibertec.cibertec.Service.ServiceSalario;

@RestController
@RequestMapping("/url/salario")
public class SalarioController {
    @Autowired
    private ServiceSalario servSal;
    
    @GetMapping("/listarSalarios")
    public List<Salario> listarSalarios(){
        return servSal.listaTodos();
    }
    @PostMapping("/registrarSalario")
    @ResponseBody
    public ResponseEntity<?> inserta (@RequestBody Salario obj){
        Map<String, Object> salida = new HashMap<>();
		try {
			Salario objSalida = servSal.agregarActualizSalario(obj);
			if (objSalida == null) {
				salida.put("mensaje", "Error al registrar el salario");
			} else {
				salida.put("mensaje", "Salario registrado exitosamente");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error al registrar");
		}
		return ResponseEntity.ok(salida);
    }
    @PutMapping("/actualizarSalario")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaEjemplo(@RequestBody Salario obj) {
		Map<String, Object> salida = new HashMap<>();
        try {
            Salario objSalida = servSal.agregarActualizSalario(obj);
            if (objSalida == null) {
                salida.put("mensaje", "Error al registrar el salario");
			} else {
				salida.put("mensaje", "Salario registrado exitosamente");
			}
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", "Error al registrar");
        }
        return ResponseEntity.ok(salida);
	}
    @DeleteMapping("/eliminarSalario/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaEjemplo(@PathVariable("id") int idEjemplo) {
		Map<String, Object> salida = new HashMap<>();
		try {
			servSal.eliminarSalario(idEjemplo);
			salida.put("mensaje", "Salario registrado exitosamente");
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error al eliminar");
		}
		return ResponseEntity.ok(salida);
	}
}
