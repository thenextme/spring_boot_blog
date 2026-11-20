package com.betatq.blog.controllers;


import com.betatq.blog.data.dto.ArticleDto;
import com.betatq.blog.data.request.ArticleRequest;
import com.betatq.blog.entities.ArticleEntity;
import com.betatq.blog.services.ArticleService;
import com.betatq.blog.services.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {

    private final ArticleService service;

    @Autowired
    public ArticleController(ArticleServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ArticleDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<ArticleDto> create(@RequestBody ArticleRequest request) {
        ArticleDto article = service.create(request);
        return ResponseEntity.created(null).body(article);
    }
}
