package com.ims.coursespringmongo.services;

import com.ims.coursespringmongo.domain.Post;
import com.ims.coursespringmongo.repositories.PostRepository;
import com.ims.coursespringmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle (String text) {
        //retorna dados com query methodos
//        return repository.findByTitleContainingIgnoreCase(text);

        //Retorna dados com query simples
        return repository.findByTitle(text);
    }

    public List<Post> fullSearch (String text, Date minDate, Date maxDate) {
        //Add 24hs no maxDate para realizar a busca até meia-noite
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}
