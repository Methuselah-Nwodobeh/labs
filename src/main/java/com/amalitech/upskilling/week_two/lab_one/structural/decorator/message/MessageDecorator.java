package com.amalitech.upskilling.week_two.lab_one.structural.decorator.message;

public abstract class MessageDecorator implements Message {
    protected Message decoratedMessage;

    protected MessageDecorator(Message decoratedMessage) {
        this.decoratedMessage = decoratedMessage;
    }

    @Override
    public void send(String message, String color) {
        decoratedMessage.send(message, color);
    }
}