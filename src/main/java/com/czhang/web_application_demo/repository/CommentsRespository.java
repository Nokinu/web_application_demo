package com.czhang.web_application_demo.repository;

import com.czhang.web_application_demo.bom.Comments;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRespository extends MongoRepository<Comments, String> {
}
