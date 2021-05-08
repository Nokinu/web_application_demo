package com.czhang.web_application_demo.repository;

import com.czhang.web_application_demo.bom.Comments;
import com.czhang.web_application_demo.bom.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ThirdPartyAPIRepository {

    List<Post> getAllPosts();

    boolean postComment(Comments comment);

}
