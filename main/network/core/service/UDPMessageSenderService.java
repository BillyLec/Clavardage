package com.fredericboisguerin.insa.network.core.service;

import java.net.*;

public class UDPMessageSenderService implements MessageSenderService {
    @Override
    public void sendMessageOn(String ipAddress, int port, String message) throws Exception {
        DatagramSocket senderSocket = new DatagramSocket();
        byte[] data = message.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
        datagramPacket.setAddress(InetAddress.getByName(ipAddress));
        datagramPacket.setPort(port);

        senderSocket.send(datagramPacket);

        senderSocket.close();
    }
}
