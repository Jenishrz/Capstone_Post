package com.post.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.post.entity.Post;
import com.post.entity.PostDTO;
import com.post.service.PostService;

@RestController
@CrossOrigin("http://localhost:4200/") 
public class PostController {
	
	@Autowired(required=true)
	PostService posts;
	
	@PostMapping("/postInsert")
	public String performInsert(@RequestBody PostDTO postDto) {
		posts.addPost(postDto);
		return "post Inserted";
	}
	
	
	@PutMapping("/post")
	public String performUpdate(@RequestBody Post post) {
		posts.updatepost(post);
		return "post updated";
	}
	

	@GetMapping("/viewAllPost")
	public List<Post> getAllpost(){
           return posts.getAllPost();
		
	}
}
//	@GetMapping("/viewAllPost")
//    public ResponseEntity<List<Map<String, Object>>> getAllPosts() {
//        List<Map<String, Object>> postOutput = posts.getAllPostOutput();
//        return ResponseEntity.ok(postOutput);
//    }
	
	
	
//	@GetMapping("/viewAll")
//	  public List<PostDTO> getPostsWithSpecificColumns() {
//	    return posts.getPostsWithSpecificColumns();
//	  }
//	}
	
//	public String getAllpost() {
//		return posts.getAllPost();
//	}
	
	

