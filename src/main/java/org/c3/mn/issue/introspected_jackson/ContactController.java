package org.c3.mn.issue.introspected_jackson;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;
import java.util.stream.Collectors;

@Controller("/issue")
public class ContactController
{
    private final ContactRepository repo;

    public ContactController(ContactRepository repository) {
        this.repo = repository;
        loadData();
    }

    @Get("/dto")
    public List<ContactDto> getDTOs() {
        return this.repo.findAll().stream().map(ContactDto::new).collect(Collectors.toList());
    }

    @Get("/entity")
    public List<ContactEntity> getEntities() {
        return this.repo.findAll();
    }

    @Get("/introspected")
    public List<ContactIntrospected> getIntrospected() {
        return this.repo.list();
    }

    private void loadData()
    {
        this.repo.save(new ContactEntity("Cummerata", "9550332616", 2514));
        this.repo.save(new ContactEntity("Barrows", "5964326636", 1853));
        this.repo.save(new ContactEntity("Davis", "1636868842",6878));
    }
}
