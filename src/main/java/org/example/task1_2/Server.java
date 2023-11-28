package org.example.task1_2;

public class Server implements ServerListener {
    private boolean isServerWorking;
    private final Listener listener;

    public Server(Listener listener) {
        this.listener = listener;
        isServerWorking = false;
    }

    public void stop() {
        if(isServerWorking) {
            isServerWorking = false;
            listener.messageReceived("Server stopped ");
        }
        else {
            listener.messageReceived("Server is already stopped");
        }
    }

    public void start() {
        if(!isServerWorking) {
            isServerWorking = true;
            listener.messageReceived("Server started");
        }
        else {
            listener.messageReceived("Server is already running");
        }
    }

    @Override
    public void listenServer(boolean state) {
        if (state)
            stop();
        else
            start();
    }
}