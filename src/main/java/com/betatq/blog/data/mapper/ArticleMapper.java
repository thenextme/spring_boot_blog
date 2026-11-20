package com.betatq.blog.data.mapper;

import com.betatq.blog.data.dto.ArticleDto;
import com.betatq.blog.data.request.ArticleRequest;
import com.betatq.blog.entities.ArticleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class ArticleMapper {

    public abstract ArticleDto toDto(ArticleEntity entity);

    public abstract List<ArticleDto> toDtoList(List<ArticleEntity> entities);

    public abstract ArticleEntity toEntity(ArticleRequest request);
}
