package assignment_261118.task1.clientserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {

    private int port;

    private final Set<IOConnection> connections = new CopyOnWriteArraySet<>();
    private final BlockingDeque<ExtMessage> messageInQueue = new LinkedBlockingDeque<ExtMessage>();
    private final BlockingDeque<ExtMessage> messageOutQueue = new LinkedBlockingDeque<ExtMessage>();
    private Set<String> commands;
    private Set<String> users;

    public Server(int port) {
        this.port = port;
        this.users = new HashSet<>();
        commands = getCommands();
    }

    public Set<String> getCommands() {
        Set<String> comms = new HashSet<>();
        comms.add("/list_users");
        comms.add("/server_time");
        comms.add("/ping");
        return comms;
    }
    private void start() throws IOException {

        new Thread(new Writer()).start();
        new Thread(new Processor()).start();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on " + serverSocket);
            IOConnection ioConnection;

            while (true) {
                Socket sock = serverSocket.accept();

                ioConnection = new IOConnection(sock);

                connections.add(ioConnection);

                new Thread(new Reader(ioConnection)).start();
            }
        }
    }

    private class Reader implements Runnable {

        private IOConnection connection;

        public Reader (IOConnection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        ExtMessage msg = connection.receiveExtMessage();
                        messageInQueue.add(msg);
//                        System.out.println(msg);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class Processor implements Runnable {

//        private ExtMessage messageToProcess;

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        ExtMessage msg = messageInQueue.take();
//                        msg.setMessText(msg.getMessText() + " processed");

                        users.add(msg.getSender());

                        Pattern comPattern = Pattern.compile("^/.*");
                        Matcher comMatcher = comPattern.matcher(msg.getMessText());

                        if (!(comMatcher.matches())) {

                            messageOutQueue.add(
                                    new ExtMessage(msg.getSender(),
                                            "\nСервер получил следующее сообщение: '" + msg.getMessText() + "'",
                                            msg.getMsgId()));
                        }
                        else
                            if (commands.contains(msg.getMessText())) {
                                processCommand(msg);
                            } else
                                messageOutQueue.add(
                                        new ExtMessage( msg.getSender(),
                                                "\nНеизвестная команда '" + msg.getMessText() + "'",
                                                msg.getMsgId()));

                        System.out.println(msg);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void processCommand(ExtMessage msg) {

                switch(msg.getMessText()){
                    case "/list_users":
                        StringBuilder ans = new StringBuilder();
                        ans.append("\nСписок пользователей, заходивших на сервер:\n");
                        for (String user : users) {
                            ans.append(user).append('\n');
                        }
                        messageOutQueue.add(
                                new ExtMessage(msg.getSender(),
                                        ans.toString(),
                                        msg.getMsgId()));
                        break;
                    case "/server_time":
                        Date currentDate = new Date();

                        messageOutQueue.add(
                                new ExtMessage(msg.getSender(),
                                        currentDate.toString(),
                                        msg.getMsgId()));
                        break;
                    case "/ping":
                        messageOutQueue.add(
                                new ExtMessage(msg.getSender(),
                                        "I am alive and responding... ",
                                        msg.getMsgId()));
                        break;
                }
            }
        }

    private class Writer implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    ExtMessage msg = messageOutQueue.take();

                    for (IOConnection connection : connections) {
                        try {
                            connection.sendExtMessage(msg);
                        } catch (IOException e) {
                            connections.remove(connection);
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(8080);
        server.start();
    }
}