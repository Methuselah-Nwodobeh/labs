package com.amalitech.upskilling.week_two.lab_one.creational.builder.user;

public class User {

    private final String name;
    private final String email;
    private final String password;

    private User(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
    }

    public String getUsername() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // Builder class for User
    public static class Builder {
        private final String name;
        private String email;
        private String password;

        public Builder(String name) {
            this.name = name;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
