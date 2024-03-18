package com.post.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.entity.Comments;
import com.post.entity.Department;
import com.post.entity.Post;
import com.post.entity.PostDTO;
import com.post.entity.Project;
import com.post.entity.Reactions;
import com.post.entity.Region;
import com.post.entity.Share;
import com.post.entity.Tags;
import com.post.repository.DepartmentRepo;
import com.post.repository.PostRepo;
import com.post.repository.ProjectRepo;
import com.post.repository.RegionRepo;

@Service
public class PostService {

	@Autowired
	PostRepo postrepo;

	@Autowired
	RegionRepo rgRepo;

	@Autowired
	Post post;

	@Autowired
	Region region;
	
	@Autowired
	Department department;

	@Autowired
	Project project;
	
	@Autowired
	DepartmentRepo dtRepo;

	@Autowired
	ProjectRepo ptRepo;

	public boolean addPost(PostDTO postdto) {

		post.setPostId(postrepo.count() + 1);
		post.setPostContent(postdto.getPostContent());
		post.setDateTime(postdto.getDateTime());

		region = rgRepo.findById(postdto.getRegion()).get();
		post.setRegion(region);

		department = dtRepo.findById(postdto.getDepartment()).get();
		post.setDepartment(department);

		project = ptRepo.findById(postdto.getProject()).get();
		post.setProject(project);

		post.setStatus(true);
		postrepo.save(post);
		return true;
	}

	public boolean updatepost(Post post) {
		postrepo.save(post);
		return true;
	}

	public List<Post> getAllPost(){
		Iterator<Post> it = postrepo.findAll().iterator();
		ArrayList<Post> list = new ArrayList<Post>();
		
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
}

//	public String getAllPost(){
//		 var test = "test";
//	     return test;
//	}
//	

//	public List<Map<String, Object>> getAllPostOutput() {
//        List<Post> posts = postrepo.findAll();
//        List<Map<String, Object>> postOutput = new ArrayList<>();
//        for (Post post : posts) {
//            Map<String, Object> postMap = new HashMap<>();
//            postMap.put("postId", post.getPostId());
//            postMap.put("userName", post.getUser().getUserId()); 
//            postMap.put("postContent", post.getPostContent());
//            postMap.put("dateTime", post.getDateTime());
//
//            
//            List<Map<String, Object>> commentsList = new ArrayList<>();
//            for (Comments comment : post.getComments()) {
//                Map<String, Object> commentMap = new HashMap<>();
//                commentMap.put("commentId", comment.getCommentId());
//                
//                commentsList.add(commentMap);
//            }
//            postMap.put("comments", commentsList);
//            
//            List<Map<String, Object>> reactionsList = new ArrayList<>();
//            for (Reactions reaction : post.getReactions()) {
//                Map<String, Object> reactionMap = new HashMap<>();
//                reactionMap.put("reactionId", reaction.getReactionId());
//                reactionMap.put("reactionType", reaction.getReactionId()); 
//                reactionsList.add(reactionMap);
//            }
//            postMap.put("reactions", reactionsList);
//            
//            
//            List<Map<String, Object>> sharesList = new ArrayList<>();
//            if (post.getShare() != null && !post.getShare().isEmpty()) { 
//                for (Share share : post.getShare()) {
//                    Map<String, Object> shareMap = new HashMap<>();
//                    shareMap.put("sharedById", share.getUser().getUserId()); 
//                    shareMap.put("sharedPostId", share.getShareId()); 
//                    shareMap.put("sharedDateTime", share.getDateTime()); 
//                    sharesList.add(shareMap);
//                }
//            }
//            postMap.put("shares", sharesList);
//
//            
//            List<Map<String, Object>> tagsList = new ArrayList<>();
//            for (Tags tag : post.getTags()) {
//                Map<String, Object> tagMap = new HashMap<>();
//                tagMap.put("tagId", tag.getTagId());
//                tagMap.put("tagName", tag.getTagId()); // Assuming you want these fields
//                tagsList.add(tagMap);
//            }
//            postMap.put("tags", tagsList);
//
//            postOutput.add(postMap);
//        }
//        return postOutput;
//    }

//	public List<PostProjectionNative> getPostsWithSpecificColumns() {
//	    // You can perform any additional processing here before returning the data
//	    List<PostProjectionNative> posts = postrepo.findPostsWithSpecificColumnsUsingNativeQuery();
//	    // ... processing
//	    return posts;
//	  }

//	public List<PostDTO> getPostsWithSpecificColumns() {
//		List<Post> posts = postrepo.findAll(); // Assuming you use findAll()
//		List<PostDTO> projections = new ArrayList<>();
//		for (Post post : posts) {
//			projections.add(new PostDTO() {
//				public long getPostId() {
//					return post.getPostId();
//				}
//
//				public String getPostContent() {
//					return post.getPostContent();
//				}
//
//				public Date getDateTime() {
//					return post.getDateTime();
//				}
//
//				public boolean isStatus() {
//					return post.isStatus();
//				}
//
//			});
//		}
//		return projections;
//
//	}
//}
