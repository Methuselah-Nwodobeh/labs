package com.amalitech.upskilling.week_two.lab_one.creational.builder.search_query;

import com.amalitech.upskilling.OutPut;

public class Main {

    public static void main(String[] args) {
        ComplexSearchQuery complexSearchQuery = new ComplexSearchQuery.Builder()
                .addKeyword("Java")
                .addCategory("Programming")
                .addAuthor("David Agbanyo")
                .fromDate("2022-01-01")
                .toDate("2022-12-31")
                .build();

        OutPut.printColoredTextBlock(complexSearchQuery.toString(), OutPut.Colors.BLUE);
        OutPut.printColoredTextBlock(complexSearchQuery.getQuery(), OutPut.Colors.CYAN);
    }
}
