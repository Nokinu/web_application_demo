package com.czhang.web_application_demo.service;

import com.czhang.web_application_demo.aop.SystemLog;
import com.czhang.web_application_demo.bom.Comments;
import com.czhang.web_application_demo.repository.CommentsRespository;
import com.czhang.web_application_demo.repository.ThirdPartyAPIRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentsService {

    private final CommentsRespository commentsRespository;
    private final ThirdPartyAPIRepository thirdPartyAPIRepository;


    public CommentsService(CommentsRespository commentsRespository, ThirdPartyAPIRepository thirdPartyAPIRepository) {
        this.commentsRespository = commentsRespository;
        this.thirdPartyAPIRepository = thirdPartyAPIRepository;
    }

    @SystemLog
    @Transactional
    public boolean addComments(Comments comments) {
        try {
            Comments result = commentsRespository.save(comments);
            boolean apiUpdated = thirdPartyAPIRepository.postComment(comments);
            return apiUpdated && result != null;
        } catch (Exception exception) {
            throw exception;
        }
    }
}
