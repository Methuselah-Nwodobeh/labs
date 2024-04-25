package com.amalitech.upskilling.week_two.lab_one.creational.builder.search_query;

import java.util.ArrayList;
import java.util.List;

// ComplexSearchQuery class representing the search query object
public class ComplexSearchQuery {
    private final List<String> keywords;
    private final List<String> categories;
    private final List<String> authors;
    private final String fromDate;
    private final String toDate;

    // Private constructor to prevent direct instantiation
    private ComplexSearchQuery(Builder builder) {
        this.keywords = builder.keywords;
        this.categories = builder.categories;
        this.authors = builder.authors;
        this.fromDate = builder.fromDate;
        this.toDate = builder.toDate;
    }

    @Override
    public String toString() {
        return "ComplexSearchQuery{" +
                "keywords=" + keywords +
                ", categories=" + categories +
                ", authors=" + authors +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                '}';
    }

    public String getQuery() {
        StringBuilder query = new StringBuilder();
        query.append("GET * with criteria(");
        if (!keywords.isEmpty()) {
            query.append("keyword: ").append(String.join(", ", keywords)).append(" ");
        }
        if (!categories.isEmpty()) {
            query.append("category: ").append(String.join(", ", categories)).append(" ");
        }
        if (!authors.isEmpty()) {
            query.append("author: ").append(String.join(", ", authors)).append(" ");
        }
        if (fromDate != null) {
            query.append("from date: ").append(fromDate).append(" ");
        }
        if (toDate != null) {
            query.append("to date: ").append(toDate);
        }
        query.append(")");
        return query.toString();
    }

    // Getters for the query criteria
    public List<String> getKeywords() {
        return keywords;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public static class Builder {
        private final List<String> keywords = new ArrayList<>();
        private final List<String> categories = new ArrayList<>();
        private final List<String> authors = new ArrayList<>();
        private String fromDate;
        private String toDate;

        // Setter methods for setting query criteria
        public Builder addKeyword(String keyword) {
            this.keywords.add(keyword);
            return this;
        }

        public Builder addCategory(String category) {
            this.categories.add(category);
            return this;
        }

        public Builder addAuthor(String author) {
            this.authors.add(author);
            return this;
        }

        public Builder fromDate(String fromDate) {
            this.fromDate = fromDate;
            return this;
        }

        public Builder toDate(String toDate) {
            this.toDate = toDate;
            return this;
        }

        // Build method to create ComplexSearchQuery object
        public ComplexSearchQuery build() {
            return new ComplexSearchQuery(this);
        }
    }

}