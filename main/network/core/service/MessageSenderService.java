package com.fredericboisguerin.insa.network.core.service;

public interface MessageSenderService {

    void sendMessageOn(String ipAddress, int port, String message) throws Exception;
}
