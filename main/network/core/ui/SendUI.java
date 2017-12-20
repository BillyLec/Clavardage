package com.fredericboisguerin.insa.network.core.ui;

import com.fredericboisguerin.insa.network.core.service.MessageSenderService;
import com.fredericboisguerin.insa.network.core.service.factory.MessageSenderServiceFactory;
import com.fredericboisguerin.insa.network.infrastructure.terminal.Terminal;

public class SendUI implements CommunicationUI {

    private static final String ERROR_MESSAGE = "[ERROR] An error occured while trying to send message";
    private static final String NOTIFICATION_FORMAT = "[INFO] Your message has been sent to %s on port %d";

    private final MessageSenderServiceFactory messageSenderServiceFactory;
    private final Terminal terminal;

    public SendUI(MessageSenderServiceFactory messageSenderServiceFactory, Terminal terminal) {
        this.messageSenderServiceFactory = messageSenderServiceFactory;
        this.terminal = terminal;
    }

    @Override
    public void onTCP() {
        sendMessageWith(messageSenderServiceFactory.onTCP());
    }

    @Override
    public void onUDP() {
        sendMessageWith(messageSenderServiceFactory.onUDP());
    }

    private void sendMessageWith(MessageSenderService messageSenderService) {
        System.out.print("Destination IP address : ");
        String ipAddress = terminal.readLine();
        System.out.print("Destination port : ");
        int port = terminal.readInt();
        System.out.print("Message : ");
        String message = terminal.readLine();
        try {
            messageSenderService.sendMessageOn(ipAddress, port, message);
            terminal.print(String.format(NOTIFICATION_FORMAT, ipAddress, port));
        } catch (Exception exception) {
            terminal.printError(ERROR_MESSAGE);
            terminal.printError(exception);
        }
    }
}
