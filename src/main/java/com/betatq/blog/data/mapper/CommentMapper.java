package com.betatq.blog.data.mapper;

import com.betatq.blog.data.dto.CommentDto;
import com.betatq.blog.data.request.CommentRequest;
import com.betatq.blog.entities.ArticleEntity;
import com.betatq.blog.entities.CommentEntity;
import com.betatq.blog.repositories.ArticleRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class CommentMapper {

    @Autowired
    ArticleRepository articleRepository;

    public abstract CommentDto toDto(CommentEntity entity);

    public abstract List<CommentDto> toDtoList(List<CommentEntity> entities);

    @Mapping(source = "articleId", target = "article", qualifiedByName = "idToArticle")
    public abstract CommentEntity toEntity(CommentRequest request);

    @Named("idToArticle")
    protected ArticleEntity idToArticle(Integer articleId) {
        return articleRepository.getReferenceById(articleId);
    }
}
