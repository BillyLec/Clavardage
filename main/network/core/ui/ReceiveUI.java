package com.fredericboisguerin.insa.network.core.ui;

import com.fredericboisguerin.insa.network.core.service.IncomingMessageListener;
import com.fredericboisguerin.insa.network.core.service.MessageReceiverService;
import com.fredericboisguerin.insa.network.core.service.factory.MessageReceiverServiceFactory;
import com.fredericboisguerin.insa.network.infrastructure.terminal.Terminal;

public class ReceiveUI implements CommunicationUI, IncomingMessageListener {
    private static final String ERROR_MESSAGE = "[ERROR] An error occured while trying to listen on port";

    private final Terminal terminal;
    private final MessageReceiverServiceFactory messageReceiverServiceFactory;

    public ReceiveUI(Terminal terminal, MessageReceiverServiceFactory messageReceiverServiceFactory) {
        this.terminal = terminal;
        this.messageReceiverServiceFactory = messageReceiverServiceFactory;
    }

    @Override
    public void onUDP() {
        askForPort(messageReceiverServiceFactory.onUDP());
    }

    @Override
    public void onTCP() {
        askForPort(messageReceiverServiceFactory.onTCP());
    }

    private void askForPort(MessageReceiverService messageReceiverService) {
        System.out.print("Enter the port to listen on: ");
        int port = terminal.readInt();
        try {
            messageReceiverService.listenOnPort(port, this);
        } catch (Exception exception) {
            terminal.printError(ERROR_MESSAGE);
            terminal.printError(exception);
        }
    }

    @Override
    public void onNewIncomingMessage(String message) {
        terminal.print("New incoming message: " + message);
    }
}
