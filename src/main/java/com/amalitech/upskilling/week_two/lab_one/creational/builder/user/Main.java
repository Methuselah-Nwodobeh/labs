package com.amalitech.upskilling.week_two.lab_one.creational.builder.user;

import com.amalitech.upskilling.OutPut;

public class Main {

    public static void main(String[] args) {
        User user = new User.Builder("John")
                .email("johndoe@me.com")
                .password("1234567890")
                .build();

        OutPut.printColoredTextBlock(user.toString(), OutPut.Colors.CYAN);
    }
}
