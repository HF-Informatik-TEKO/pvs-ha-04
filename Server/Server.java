import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 1200;

    public static void main(String[] args) {
        System.out.println("startup server");
        try (var serverSocket = new ServerSocket(PORT);
        ) {
            System.out.println("Server listening on port " + PORT);
            while (true) {
                var socket = serverSocket.accept();

                System.out.println("Client connected: " 
                    + socket.getInetAddress().getHostAddress());

                Thread thread = new Thread(() -> processClientRequest(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.err.println("Error in server: " + e.getMessage());
        }
    }

    private static void processClientRequest(Socket socket) {
        try (
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            )
        ) {
            var line = reader.readLine();
            while (line != null) {
                System.out.println("Received data: " + line);
                line = reader.readLine();
            }

            System.out.println("Client disconnected: " 
                + socket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            System.err.println("Error processing client request: " + e.getMessage());
        }
    }
}