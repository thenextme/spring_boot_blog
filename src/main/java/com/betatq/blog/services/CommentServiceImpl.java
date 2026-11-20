package com.betatq.blog.services;

import com.betatq.blog.data.dto.CommentDto;
import com.betatq.blog.data.mapper.CommentMapper;
import com.betatq.blog.data.request.CommentRequest;
import com.betatq.blog.entities.CommentEntity;
import com.betatq.blog.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;
    private final CommentMapper mapper;

    @Autowired
    public CommentServiceImpl(CommentRepository repository, CommentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<CommentDto> findAllByArticleId(Integer articleId) {
        return mapper.toDtoList(repository.findAllByArticleId(articleId));
    }

    @Override
    public CommentDto create(CommentRequest request) {
        CommentEntity comment = mapper.toEntity(request);
        return mapper.toDto(repository.save(comment));
    }
}
