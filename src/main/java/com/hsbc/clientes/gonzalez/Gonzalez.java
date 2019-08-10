package com.hsbc.clientes.gonzalez;



import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsbc.clientes.eduardocastillo.model.Cliente;



@RestController
@RequestMapping("/api/v1/Gonzalez/cliente")
public class Gonzalez {
static List<Cliente> clientes= new ArrayList<>();
static {
	Cliente juan = new Cliente();
	juan.setId((long) 7l);
	juan.setNombre("Juan");
	juan.setApellidos("Gonzalez");
	juan.setDireccion("Atlacomulco");
	juan.setEdad(27);
	juan.setGenero("Masculino");
	clientes.add(juan);
	
}
@PostMapping
public Cliente add(@RequestBody Cliente cliente) {
	cliente.setId(clientes.size() + 7L);
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
