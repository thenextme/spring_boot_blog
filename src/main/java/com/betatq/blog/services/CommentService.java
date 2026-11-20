package com.betatq.blog.services;

import com.betatq.blog.data.dto.CommentDto;
import com.betatq.blog.data.request.CommentRequest;

import java.util.List;

public interface CommentService {

    List<CommentDto> findAllByArticleId(Integer articleId);

    CommentDto create(CommentRequest request);
}
