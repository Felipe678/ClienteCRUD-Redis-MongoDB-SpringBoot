package com.accenture.crud.api.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.accenture.crud.api.document.Cliente;

@Component
public class ClienteCache {

	private ValueOperations<String, Object> operations;
	private RedisTemplate<String, Object> template;
	
	@Autowired
	public ClienteCache(ValueOperations<String, Object> operations, RedisTemplate<String, Object> template) {
		super();
		this.operations = operations;
		this.template = template;
	}
	
	public void cacheSave(Cliente cliente) {
		operations.set(cliente.getCpf().toString(), cliente);
	}
	
	public Cliente cacheGetByCpf(String CPF) {
	    String cpfCliente = String.valueOf(CPF);
		return (Cliente) operations.get(CPF);
	    
	}
	
	public void deleteCache(String cpf) {
		template.delete(cpf);
	}
}
