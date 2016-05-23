package com.intuso.housemate.plugin.v1_0.api.type;

import com.intuso.housemate.plugin.v1_0.api.annotations.Regex;
import com.intuso.housemate.plugin.v1_0.api.annotations.TypeInfo;

/**
 * Created with IntelliJ IDEA.
 * User: tomc
 * Date: 01/05/14
 * Time: 08:49
 * To change this template use File | Settings | File Templates.
 */
@TypeInfo(id = "email", name = "Email", description = "Email address")
@Regex(regex = ".+@.+\\..+", factory = Email.Factory.class)
public class Email implements RegexType {

    private final String email;

    public Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getValue() {
        return getEmail();
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email1 = (Email) o;

        if (email != null ? !email.equals(email1.email) : email1.email != null) return false;

        return true;
    }

    public static class Factory implements RegexType.Factory<Email> {

        @Override
        public Email create(String value) {
            return new Email(value);
        }
    }
}
