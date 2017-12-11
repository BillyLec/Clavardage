package com.fredericboisguerin.insa.network.core.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPMessageReceiverService implements MessageReceiverService {
    @Override
    public void listenOnPort(int port, IncomingMessageListener incomingMessageListener) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket chatSocket = serverSocket.accept();
        InputStreamReader stream = new InputStreamReader(chatSocket.getInputStream());
        BufferedReader reader = new BufferedReader(stream);

        String message = reader.readLine();

        reader.close();
        serverSocket.close();

        incomingMessageListener.onNewIncomingMessage(message);
    }
}
