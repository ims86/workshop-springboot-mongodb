package com.ims.coursespringmongo.services;

import com.ims.coursespringmongo.domain.Post;
import com.ims.coursespringmongo.repositories.PostRepository;
import com.ims.coursespringmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll(){
        return repository.findAll();
    }

    public Post findById(String id){
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
    }
    public Post insert(Post obj){
        return repository.save(obj);
    }

    public void delete(String id){
        //Realiza uma busca pelo id, caso não encontre dispara exceção
        findById(id);
        repository.deleteById(id);
    }

//    public void update(Post obj){
//        Optional<Post> newObj = repository.findById(obj.getId());
//        Post user = newObj.get();
//        updateData(user, obj);
//        repository.save(user);
//    }

//    public Post fromDTO(PostDTO objDto){
//        return new Post(objDto.getId(), objDto.getName(), objDto.getEmail());
//    }
//
//    private void updateData(Post user, Post obj) {
//        user.setName(obj.getName());
//        user.setEmail(obj.getEmail());
//    }
}
