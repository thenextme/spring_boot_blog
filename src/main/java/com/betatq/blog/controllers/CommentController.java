package com.betatq.blog.controllers;

import com.betatq.blog.data.dto.CommentDto;
import com.betatq.blog.data.request.CommentRequest;
import com.betatq.blog.services.CommentService;
import com.betatq.blog.services.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles/{articleId}/comments")
public class CommentController {

    private final CommentService service;

    @Autowired
    public CommentController(CommentServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CommentDto>> findAllByArticleId(@PathVariable("articleId") Integer articleId) {
        return ResponseEntity.ok(service.findAllByArticleId(articleId));
    }

    @PostMapping
    public ResponseEntity<CommentDto> create(@RequestBody CommentRequest request) {
        return ResponseEntity.created(null).body(service.create(request));
    }
}
