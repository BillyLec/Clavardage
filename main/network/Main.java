package com.fredericboisguerin.insa.network;

import java.io.IOException;

import com.fredericboisguerin.insa.network.core.service.factory.MessageReceiverServiceFactory;
import com.fredericboisguerin.insa.network.core.service.factory.MessageSenderServiceFactory;
import com.fredericboisguerin.insa.network.core.ui.ProtocolChooser;
import com.fredericboisguerin.insa.network.core.ui.ReceiveUI;
import com.fredericboisguerin.insa.network.core.ui.SendUI;
import com.fredericboisguerin.insa.network.core.ui.StartingUI;
import com.fredericboisguerin.insa.network.infrastructure.terminal.Terminal;

public class Main {

    public static void main(String[] args) throws IOException {
        Terminal terminal = new Terminal();
        ReceiveUI receiveUI = new ReceiveUI(terminal, new MessageReceiverServiceFactory());
        SendUI sendUI = new SendUI(new MessageSenderServiceFactory(), terminal);
        StartingUI startingUI = new StartingUI(terminal, new ProtocolChooser(terminal), receiveUI, sendUI);
        startingUI.askForAction();
    }
}
