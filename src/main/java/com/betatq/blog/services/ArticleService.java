package com.betatq.blog.services;

import com.betatq.blog.data.dto.ArticleDto;
import com.betatq.blog.data.request.ArticleRequest;
import com.betatq.blog.entities.ArticleEntity;

import java.util.List;

public interface ArticleService {

    List<ArticleDto> findAll();

    ArticleDto create(ArticleRequest request);

}
