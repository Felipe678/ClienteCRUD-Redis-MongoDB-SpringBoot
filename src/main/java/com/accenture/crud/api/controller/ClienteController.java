package com.accenture.crud.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.crud.api.document.Cliente;
import com.accenture.crud.api.service.ClienteService;

@RestController
public class ClienteController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping("/create")
	public String create(@RequestParam String nome,@RequestParam String cpf,@RequestParam String telefone,@RequestParam String endereco,@RequestParam String cep) {			
		Cliente c = clienteService.create(nome, cpf, telefone, endereco, cep);
		
		return c.toString();
	}
	
	
	@RequestMapping("/{cpf}")
	public ResponseEntity<Cliente> getCliente(@PathVariable String cpf) {
		try {
			Cliente cliente = clienteService.getByCpf(cpf);
			if (cliente != null) {
				
				return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
			} else {
				return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@RequestMapping("/getAll")
	public List<Cliente> getAll() {
		return clienteService.getAll();
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam String nome,@RequestParam String cpf,@RequestParam String telefone,@RequestParam String endereco,@RequestParam String cep) {
		Cliente c = clienteService.update(nome, cpf, telefone, endereco, cep);
		return c.toStringAlter();
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String cpf) {
		clienteService.delete(cpf);
		return "Deleted"+cpf;
	}
	
	@RequestMapping("/deleteAll")
	public String deleteAll() {
		clienteService.deleteAll();
		return "Deleted All Clientes";
	}
}
