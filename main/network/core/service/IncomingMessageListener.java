package com.fredericboisguerin.insa.network.core.service;

public interface IncomingMessageListener {
    void onNewIncomingMessage(String message);
}
