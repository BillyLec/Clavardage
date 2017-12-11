package com.fredericboisguerin.insa.network.core.service.factory;

import com.fredericboisguerin.insa.network.core.service.MessageSenderService;
import com.fredericboisguerin.insa.network.core.service.TCPMessageSenderService;
import com.fredericboisguerin.insa.network.core.service.UDPMessageSenderService;

public class MessageSenderServiceFactory implements MessageServiceFactory<MessageSenderService> {

    @Override
    public MessageSenderService onTCP() {
        return new TCPMessageSenderService();
    }

    @Override
    public MessageSenderService onUDP() {
        return new UDPMessageSenderService();
    }
}
