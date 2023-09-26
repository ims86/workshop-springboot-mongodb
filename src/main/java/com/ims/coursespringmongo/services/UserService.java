package com.ims.coursespringmongo.services;

import com.ims.coursespringmongo.domain.User;
import com.ims.coursespringmongo.domain.dto.UserDTO;
import com.ims.coursespringmongo.repositories.UserRepository;
import com.ims.coursespringmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
    }
    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(String id){
        //Realiza uma busca pelo id, caso não encontre dispara exceção
        findById(id);
        repository.deleteById(id);
    }

    public void update(User obj){
        Optional<User> newObj = repository.findById(obj.getId());
        User user = newObj.get();
        updateData(user, obj);
        repository.save(user);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

    private void updateData(User user, User obj) {
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
    }
}
