package org.c3.mn.issue.introspected_jackson;

public class Formatter
{
    public static String formatPhone(String number) {
        return number.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
    }

    public static String unformatPhone(String number) {
        return number.replaceAll("\\D", "");
    }

    public static String formatExtension(int extension) {
        return String.format("x%d", extension);
    }

    public static int unformatExtension(String extension) {
        return Integer.parseInt(extension.substring(1));
    }
}
