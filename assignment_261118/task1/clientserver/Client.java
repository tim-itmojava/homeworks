package assignment_261118.task1.clientserver;

import java.io.IOException;
import java.net.Socket;
import java.util.*;

public class Client {

    private IOConnection ioConnection;
    private ExtMessage reply = null;
    private Set<String> commands;
    private Map<UUID,Long> pingMsgs;

    private static UUID generateMsgId() {
        return UUID.randomUUID();
    }

    private Client(IOConnection ioConnection){
        this.ioConnection = ioConnection;
        commands = new HashSet<>();
        pingMsgs = new HashMap<>();
        commands.add("/list_users");
        commands.add("/server_time");
        commands.add("/ping");
    }

    public void setReply(ExtMessage reply) {
        this.reply = reply;
    }

    public ExtMessage getReply() {
        return reply;
    }

    public void start() throws IOException, CommSessionException {

        ConsoleHelper.writeString("Enter your name");
        String name = ConsoleHelper.readString();

        Thread reader = new Thread(new Reader(ioConnection));
        reader.start();

        ConsoleHelper.writeString("Enter your message");

        while (true) {

            String msg = ConsoleHelper.readString();

            if (msg != null && !msg.isEmpty()) {

                ExtMessage msgToBeSent = new ExtMessage(name, msg, generateMsgId());

                if (!(commands.contains(msgToBeSent.getMessText())))
                {
                    ioConnection.sendExtMessage(msgToBeSent);
                }
                else {
                    commandProcessor(msgToBeSent);
                }
            }
        }
    }

    public void commandProcessor(ExtMessage msg) throws IOException, CommSessionException {

        switch (msg.getMessText()) {
            case "/list_users":
                ioConnection.sendExtMessage(msg);
                break;
            case "/server_time":
                ioConnection.sendExtMessage(msg);
                break;
            case "/ping":
                safelyStorePing(msg);
                ioConnection.sendExtMessage(msg);
                break;
            default:
                throw new CommSessionException("Команда не найдена");
        }
    }

    private synchronized void safelyStorePing(ExtMessage msg) {
        this.pingMsgs.put(msg.getMsgId(),new Date().getTime());
    }

    private synchronized void safelyRemovePing(UUID msgId) {
        this.pingMsgs.remove(msgId);
    }

    private synchronized Long safelyCheckPing(ExtMessage msg) {
        if (pingMsgs.containsKey(msg.getMsgId())) {
            return pingMsgs.get(msg.getMsgId());
        }
        else return 0L;
    }

    private class Reader implements Runnable{

        private final IOConnection connection;

        private Reader(IOConnection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {

            try {
                while (!Thread.currentThread().isInterrupted()) {
                    ExtMessage message = connection.receiveExtMessage();

                    if (!(safelyCheckPing(message)==0)) {
                        message.setMessText(message.getMessText() +
                                ((new Date().getTime()) - safelyCheckPing(message)) + " ms");
                    }

                    safelyRemovePing(message.getMsgId());
                    System.out.println(message);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, CommSessionException {

        Client client = new Client(new IOConnection(new Socket("127.0.0.1", 8080)));
        client.start();
    }
}