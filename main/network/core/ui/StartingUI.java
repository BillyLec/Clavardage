package com.fredericboisguerin.insa.network.core.ui;

import java.util.StringJoiner;

import com.fredericboisguerin.insa.network.infrastructure.terminal.Terminal;

public class StartingUI {

    private static final int RECEIVE = 1;
    private static final int SEND = 2;
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String PROMPT = "Enter your choice: ";
    private static final String POSSIBLE_ACTIONS = new StringJoiner(LINE_SEPARATOR).add("What do you wanna do?")
            .add(RECEIVE + "> Listen to incoming messages")
            .add(SEND + "> Send messages")
            .toString();

    private final Terminal terminal;
    private final ProtocolChooser protocolChooser;
    private final CommunicationUI receiveUI;
    private final CommunicationUI sendUI;

    public StartingUI(Terminal terminal, ProtocolChooser protocolChooser, ReceiveUI receiveUI, SendUI sendUI) {
        this.terminal = terminal;
        this.protocolChooser = protocolChooser;
        this.receiveUI = receiveUI;
        this.sendUI = sendUI;
    }

    public void askForAction() {
        terminal.print(POSSIBLE_ACTIONS);
        terminal.print(PROMPT);
        int choice = terminal.readInt();
        switch (choice) {
        case RECEIVE:
            protocolChooser.askProtocolOn(receiveUI);
            break;
        case SEND:
            protocolChooser.askProtocolOn(sendUI);
            break;
        }
    }
}
