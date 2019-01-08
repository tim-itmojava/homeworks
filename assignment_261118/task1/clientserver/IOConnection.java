package assignment_261118.task1.clientserver;

import assignment_261118.task1.Message;
import assignment_261118.task1.clientserver.ExtMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

public class IOConnection implements AutoCloseable {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public IOConnection(Socket socket) throws IOException {
        this.socket = socket;

        this.out = new ObjectOutputStream(socket.getOutputStream());    // as far as I remember it's the Output stream that needs to be created first
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    public void sendMessage(Message message) throws IOException {
        out.writeObject(message);
        out.flush();
    }

    public Message receiveMessage() throws IOException, ClassNotFoundException {
        return (Message) in.readObject();
    }

    public void sendExtMessage(ExtMessage msg) throws IOException {
        out.writeObject(msg);
        out.flush();
    }

    public ExtMessage receiveExtMessage() throws IOException, ClassNotFoundException {
        return (ExtMessage) in.readObject();
    }

    public void close() throws IOException {
        this.in.close();
        this.out.close();
        this.socket.close();
    }

    public SocketAddress getRemoteSocketAddress(){
        return socket.getRemoteSocketAddress();
    }

}
