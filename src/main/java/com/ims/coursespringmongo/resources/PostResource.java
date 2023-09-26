package com.ims.coursespringmongo.resources;

import com.ims.coursespringmongo.domain.Post;
import com.ims.coursespringmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/posts")
public class PostResource {

    @Autowired
    private PostService service;

//    @GetMapping
//    public ResponseEntity<List<PostDTO>> findAll(){
//        List<Post> list = service.findAll();
//        List<PostDTO> listDto = list.stream().map(PostDTO::new).collect(Collectors.toList());
//        return ResponseEntity.ok().body(listDto);
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

//    @GetMapping(value = "/{id}/posts")
//    public ResponseEntity<List<Post>> findPostsByPost(@PathVariable String id){
//        Post obj = service.findById(id);
//        return ResponseEntity.ok().body(obj.getPosts());
//    }
//
//    @PostMapping()
//    public ResponseEntity<Void> insert(@RequestBody PostDTO objDto){
//        Post obj = service.fromDTO(objDto);
//        obj = service.insert(obj);
//        //Pega o endereço do novo objeto inserido na base
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }
//
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<Post> update(@PathVariable String id, @RequestBody PostDTO objDto){
//        Post obj = service.fromDTO(objDto);
//        obj.setId(id);
//        service.update(obj);
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Void> delete(@PathVariable String id){
//        service.delete(id);
//        return ResponseEntity.noContent().build();
//    }
}
