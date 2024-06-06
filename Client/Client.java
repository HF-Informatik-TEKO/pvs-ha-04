import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (
            var clientSocket = new Socket(
                InetAddress.getByName("127.0.0.1"), 1200
            );
            var writer = new BufferedWriter(
                new OutputStreamWriter(
                    clientSocket.getOutputStream()
                )
            );
            ) 
        {
            writer.write("hello world 123world helloasdfwewf");
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
