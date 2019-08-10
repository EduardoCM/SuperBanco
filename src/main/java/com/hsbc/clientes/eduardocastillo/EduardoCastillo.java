package com.hsbc.clientes.eduardocastillo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsbc.clientes.eduardocastillo.model.Cliente;

@RestController
@RequestMapping("/api/v1/eduardocastillo/cliente")
public class EduardoCastillo {

	static List<Cliente> clientes = new ArrayList<Cliente>();

	static {
		Cliente eduardo = new Cliente();
		eduardo.setId(1L);
		eduardo.setNombre("Eduardo");
		eduardo.setApellidos("Castillo Mendoza");
		eduardo.setDireccion("Jilotepec");
		eduardo.setEdad(28);
		eduardo.setGenero("M");
		clientes.add(eduardo);
	}

	@PostMapping
	public Cliente add(Cliente cliente) {
		cliente.setId(clientes.size() + 1L);
		clientes.add(cliente);
		return cliente;
	}

	@GetMapping
	public List<Cliente> findAll() {
		return clientes;
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		clientes.remove(clientes.stream().filter(it -> it.getId().equals(id)).findFirst().get());
	}

}
