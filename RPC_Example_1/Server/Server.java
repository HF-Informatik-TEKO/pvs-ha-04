import java.rmi.registry.LocateRegistry;

public class Server {

    private static final int PORT = 1200;

    public static void main(String[] args) {
        try {
            var registry = LocateRegistry.createRegistry(PORT);
            registry.bind("Count", new Count());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}