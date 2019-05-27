package com.accenture.crud.api.ropository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.accenture.crud.api.document.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String>{
	public Cliente findByCpf(String cpf);
	public List<Cliente> findByCep(String cep);
}
