package tn.esprit.devdream.service.interfaces;

import tn.esprit.devdream.entities.Post;

import java.util.List;

public interface IPostServiceImpl {

    Post addPost(Post post);

    List<Post> retrievePosts();
    Post retrievePost(Long id_Post);

    Post updatePost(Post post);

    void removePost(Long id_Post);
}
