package org.example.task1_2;

import javax.swing.*;
import java.awt.*;

public class ServerWindow extends JFrame implements Listener {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();
    private final JPanel pane = new JPanel();
    private final GridLayout grid = new GridLayout(1,2);

    Server server = new Server(this);
    private ServerWindow() {
        btnStop.addActionListener(e -> {
            server.listenServer(true);
        });

        btnStart.addActionListener(e -> {
            server.listenServer(false);
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);
        setLayout(new GridLayout(2, 1));
        pane.setLayout(grid);
        pane.add(btnStart);
        pane.add(btnStop);

        add(pane);
        add(log);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ServerWindow();
    }

    @Override
    public void messageReceived(String message) {
        log.append(message + "\n");
    }
}
