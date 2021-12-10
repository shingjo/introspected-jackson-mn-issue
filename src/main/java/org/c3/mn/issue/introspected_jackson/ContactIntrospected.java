package org.c3.mn.issue.introspected_jackson;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import io.micronaut.core.annotation.Introspected;

@Introspected
public class ContactIntrospected
{
    private String name;
    @JsonIgnore
    private String phone;
    @JsonIgnore
    private int extension;

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

    @JsonIgnore
    public String getPhone()
    {
        return phone;
    }

    @JsonIgnore
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    @JsonIgnore
    public int getExtension()
    {
        return extension;
    }

    @JsonIgnore
    public void setExtension(int extension)
    {
        this.extension = extension;
    }
}
