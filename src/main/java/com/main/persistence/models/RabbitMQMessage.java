package com.main.persistence.models;

import lombok.Data;

@Data
public class RabbitMQMessage<T> {
    private T request;
    private String typeObject;
}