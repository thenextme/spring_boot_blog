package com.betatq.blog.repositories;

import com.betatq.blog.entities.ArticleEntity;
import com.betatq.blog.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

    List<CommentEntity> findAllByArticleId(Integer id);

    Integer article(ArticleEntity article);
}
