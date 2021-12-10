package org.c3.mn.issue.introspected_jackson;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ContactDto
{
    String name;
    @JsonIgnore
    String phone;
    @JsonIgnore
    int extension;

    public ContactDto() {}

    public ContactDto(ContactEntity entity) {
        this.name = entity.getName();
        this.phone = entity.getPhone();
        this.extension = entity.getExtension();
    }

    @JsonGetter("phone")
    public String formattedNumber() {
        return Formatter.formatPhone(phone);
    }

    @JsonSetter("phone")
    public void unformatNumber(String number) {
        phone = Formatter.unformatPhone(number);
    }

    @JsonGetter("extension")
    public String formattedExtension() {
        return Formatter.formatExtension(extension);
    }

    @JsonSetter("extension")
    public void unformatExtension(String ext) {
        extension = Formatter.unformatExtension(ext);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public int getExtension()
    {
        return extension;
    }

    public void setExtension(int extension)
    {
        this.extension = extension;
    }
}
