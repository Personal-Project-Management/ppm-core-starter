package com.ppm.corestarter.infrastructure.bootstrap.mapper;

import org.mapstruct.MappingTarget;

import java.util.List;

public interface DtoMapper<Dto, Domain> {
    Dto toDto(Domain domain);
    List<Dto> toDto(List<Domain> domain);
    Domain toDomain(Dto dto);
    List<Domain> toDomain(List<Dto> dto);
}
