package com.betatq.blog.services;

import com.betatq.blog.data.dto.ArticleDto;
import com.betatq.blog.data.mapper.ArticleMapper;
import com.betatq.blog.data.request.ArticleRequest;
import com.betatq.blog.entities.ArticleEntity;
import com.betatq.blog.repositories.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository repository;
    private final ArticleMapper mapper;

    @Override
    public List<ArticleDto> findAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public ArticleDto create(ArticleRequest request) {
        ArticleEntity article = repository.save(mapper.toEntity(request));
        return mapper.toDto(article);
    }
}
