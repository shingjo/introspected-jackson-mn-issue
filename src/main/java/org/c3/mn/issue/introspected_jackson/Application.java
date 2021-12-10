package org.c3.mn.issue.introspected_jackson;

import io.micronaut.runtime.Micronaut;

import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException
    {
        Micronaut.run(Application.class, args);
    }
}
