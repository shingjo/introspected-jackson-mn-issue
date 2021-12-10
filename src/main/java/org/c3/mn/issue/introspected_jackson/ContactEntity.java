package org.c3.mn.issue.introspected_jackson;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ContactEntity
{

    @Id
    @GeneratedValue
    private long id;

    private String name;
    @JsonIgnore
    private String phone;
    @JsonIgnore
    private int    extension;

    public ContactEntity() {}

    public ContactEntity(String name, String phone, int extension) {
        this.name = name;
        this.phone = phone;
        this.extension = extension;
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

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof ContactEntity)) return false;
        ContactEntity that = (ContactEntity) o;
        return id == that.id && extension == that.extension && Objects.equals(name, that.name) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, phone, extension);
    }

    @Override
    public String toString()
    {
        return "ContactEntity{" + "name='" + name + '\'' + ", phone='" + phone + '\'' + ", extension=" + extension + '}';
    }
}
