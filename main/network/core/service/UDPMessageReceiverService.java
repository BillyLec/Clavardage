package com.fredericboisguerin.insa.network.core.service;


import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPMessageReceiverService implements MessageReceiverService {
    @Override
    public void listenOnPort(int port, IncomingMessageListener incomingMessageListener) throws Exception {
        DatagramSocket receiverSocket = new DatagramSocket(port);
        DatagramPacket receivedPacket = new DatagramPacket(new byte[500], 500);
        receiverSocket.receive(receivedPacket);
        byte[] data = receivedPacket.getData();

        receiverSocket.close();

        incomingMessageListener.onNewIncomingMessage(new String(data));
    }
}
