package org.c3.mn.issue.introspected_jackson;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, Long>
{
    List<ContactEntity> findAll();

    List<ContactIntrospected> list();
}
