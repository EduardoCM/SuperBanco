package com.hsbc.clientes.diegoperez;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsbc.clientes.diegoperez.model.Cliente;

@RestController
@RequestMapping("/api/vi/diegoperez/cliente")
public class DiegoPerez {

	static List<Cliente> clientes = new ArrayList<Cliente>();
	static {
		Cliente diego = new Cliente();
		diego.setId(8L);
		diego.setNombre("Diego");
		diego.setApellidos("perez");
		diego.setDireccion("Tlalpujahua");
		diego.setEdad(19);
		diego.setGenero("masculino");
	}

	@PostMapping
	public Cliente add(@RequestBody Cliente cliente) {
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
