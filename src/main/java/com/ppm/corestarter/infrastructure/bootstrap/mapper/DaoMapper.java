package com.ppm.corestarter.infrastructure.bootstrap.mapper;

import java.util.List;

public interface DaoMapper<Dao, Domain> {
    Domain toDomain(Dao dao);
    List<Domain> toDomain(List<Dao> dao);
}
