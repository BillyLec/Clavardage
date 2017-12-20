package com.fredericboisguerin.insa.network.core.ui;

import com.fredericboisguerin.insa.network.infrastructure.terminal.Terminal;

public class ProtocolChooser {

    private static final int UDP = 1;
    private static final int TCP = 2;
    private final Terminal terminal;

    public ProtocolChooser(Terminal terminal) {
        this.terminal = terminal;
    }

    public void askProtocolOn(CommunicationUI communicationUI) {
        System.out.print("Choose your protocol (UDP:1 - TCP:2) : ");
        int choice = terminal.readInt();
        switch (choice) {
        case UDP:
            communicationUI.onUDP();
            break;
        case TCP:
            communicationUI.onTCP();
            break;
        }
    }
}
