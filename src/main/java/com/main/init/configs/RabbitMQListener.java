package com.main.init.configs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.init.utilities.Constants;
import com.main.persistence.commands.CreateImageToCategoryCommand;
import com.main.persistence.commands.createImageToProductCommand;
import com.main.persistence.dtos.CreateImagenToCategoryRequestDto;
import com.main.persistence.dtos.CreateImagenToProductRequestDto;
import com.main.persistence.models.RabbitMQMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Message;

@Component
public class RabbitMQListener {
    private final CreateImageToCategoryCommand _createImageToCategoryCommand;
    private final createImageToProductCommand _createImageToProductCommand;

    @Autowired
    public RabbitMQListener(CreateImageToCategoryCommand createImageToCategoryCommand,
            createImageToProductCommand createImageToProductCommand) {
        this._createImageToCategoryCommand = createImageToCategoryCommand;
        this._createImageToProductCommand = createImageToProductCommand;
    }

    @RabbitListener(queues = Constants.QUEUE_NAME)
    private void receiveMessage(Message message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String messageBody = new String(message.getBody());
        String[] arrayMessage = messageBody.split(Constants.VALUE_COMA);
        String typeObject =  arrayMessage[arrayMessage.length - Constants.NUMBER_1];

        if (typeObject.contains(Constants.VALUE_CATEGORY)) {
            RabbitMQMessage<CreateImagenToCategoryRequestDto> rabbitMessage =
                objectMapper.readValue(messageBody, new TypeReference<RabbitMQMessage<CreateImagenToCategoryRequestDto>>() {});
            manageCreateImageCategory(rabbitMessage);
        } else if (typeObject.contains(Constants.VALUE_PRODUCT)) {
            RabbitMQMessage<CreateImagenToProductRequestDto> rabbitMessage =
                objectMapper.readValue(messageBody, new TypeReference<RabbitMQMessage<CreateImagenToProductRequestDto>>() {});
            manageCreateImageProduct(rabbitMessage);
        }
    }

    private void manageCreateImageCategory(
            RabbitMQMessage<CreateImagenToCategoryRequestDto> rabbitMessage) {
        CreateImagenToCategoryRequestDto request = rabbitMessage.getRequest();
        this._createImageToCategoryCommand.handle(request);
    }

    private void manageCreateImageProduct(
            RabbitMQMessage<CreateImagenToProductRequestDto> rabbitMessage) {
        CreateImagenToProductRequestDto request = rabbitMessage.getRequest();
        this._createImageToProductCommand.handle(request);
    }
}