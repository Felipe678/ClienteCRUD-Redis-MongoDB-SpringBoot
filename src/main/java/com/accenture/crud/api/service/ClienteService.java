package com.accenture.crud.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.crud.api.cache.ClienteCache;
import com.accenture.crud.api.document.Cliente;
import com.accenture.crud.api.ropository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteCache clienteCache;
	
	public Cliente create(String nome, String cpf, String telefone, String endereco, String cep) {
		return clienteRepository.save(new Cliente(nome, cpf, telefone, endereco, cep));
	}
	
	
	public List<Cliente> getAll(){
		return clienteRepository.findAll();
	}
	
	public Cliente getByCpf(String CPF) {
		Cliente cliente = clienteCache.cacheGetByCpf(CPF);
		if(cliente == null) {
			cliente = clienteRepository.findByCpf(CPF);
			if(cliente != null) {
				clienteCache.cacheSave(cliente);
			}
		}
		
//		Cliente cliente = clienteRepository.findByCpf(CPF);
//		if(cliente == null) {
//			cliente = clienteRepository.findByCpf(CPF);
//			if(cliente != null) {
//				clienteCache.cacheSave(cliente);
//			}
//			
//		}
		return cliente;
		
		
	}
	
	public Cliente update(String nome, String CPF, String telefone, String endereco, String cep) {
		Cliente c = clienteRepository.findByCpf(CPF);
		c.setCpf(CPF);
		c.setTelefone(telefone);
		c.setEndereco(endereco);
		c.setCep(cep);
		return clienteRepository.save(c);
	}
	
	public void deleteAll() {
		clienteRepository.deleteAll();
	}
	
	public void delete(String CPF) {
		Cliente cliente = clienteCache.cacheGetByCpf(CPF);
		if(cliente == null) {
			cliente = clienteRepository.findByCpf(CPF);
			if(cliente != null) {
				clienteCache.deleteCache(cliente.getCpf());
			}
		}
	}
}
