import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICount extends Remote {
    public String count(String number) throws RemoteException;
} 