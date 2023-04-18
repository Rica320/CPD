package game.client;

import game.protocols.CommunicationProtocol;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;


public class SocketUtils {
    public static String processData(ByteBuffer buffer) {
        buffer.flip();
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        return new String(bytes);
    }

    public static ByteBuffer prepareData(String data) {
        return ByteBuffer.wrap(data.getBytes());
    }

    public static String readData(SocketChannel socket) {
        return readData(socket.socket());
    }

    public static void writeData(SocketChannel socket, String data) {
        writeData(socket.socket(), data);
    }

    public static String readData(Socket socket) {
        InputStream input = null;
        String result = null;
        try {
            input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            result = reader.readLine();
        } catch (IOException e) {
            System.out.println("Error reading from socket!");
        }
        return result;
    }

    public static void writeData(Socket socket, String data) {
        OutputStream output = null;
        try {
            output = socket.getOutputStream();
            output.write((data + "\n").getBytes(StandardCharsets.UTF_8));
            output.flush();
        } catch (IOException e) {
            System.out.println("Error writing to socket!");
        }
    }

    public static void sendToClient(Socket connection, CommunicationProtocol message) {
        SocketUtils.writeData(connection, message.toString());
    }

    public static void closeSocket(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Error closing socket!");
        }
    }

}
