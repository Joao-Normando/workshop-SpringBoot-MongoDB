package com.myportfolio.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myportfolio.workshopmongo.domain.User;
import com.myportfolio.workshopmongo.dto.UserDTO;
import com.myportfolio.workshopmongo.repository.UserRepository;
import com.myportfolio.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	// Quando declara objeto dentro de uma classe usando autowired ele vai instanciar o objeto, injecao de independencia automatica do SpringBoot
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		User user = repo.findOne(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado !");
		}
		return user;
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
