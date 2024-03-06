package tn.esprit.devdream.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devdream.entities.Post;
import tn.esprit.devdream.service.interfaces.IPostServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/post")
@CrossOrigin(origins ="http://localhost:4200")
public class PostContoller {

    IPostServiceImpl postService;

    @PostMapping("/addPost")
    Post addPost (@RequestBody Post post)
    {
        return postService.addPost(post);
    }
    @GetMapping("/post/{id_Post}")
    Post getPost(@PathVariable Long id_Post)
    {
        return postService.retrievePost(id_Post);
    }
    @GetMapping("/allPosts")
    List<Post> getPosts()
    {
        return postService.retrievePosts();
    }

    @DeleteMapping("/post/{id_Post}")
    void deletePost(@PathVariable Long id_Post)
    {
        postService.removePost(id_Post);
    }

    @PutMapping("/updatePost")
    Post updatePost(@RequestBody Post post) {
        return postService.updatePost(post);
    }





}
