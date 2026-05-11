package com.ppm.corestarter.infrastructure.bootstrap.mapper;

import org.mapstruct.MappingTarget;

import java.util.List;

public interface EntityMapper<Entity, Domain> {
    Entity toEntity(Domain domain);
    List<Entity> toEntity(List<Domain> domain);
    Domain toDomain(Entity entity);
    List<Domain> toDomain(List<Entity> entity);
    void update(@MappingTarget Entity entity, Domain domain);
}
