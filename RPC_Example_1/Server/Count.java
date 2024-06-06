import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Count 
    extends UnicastRemoteObject 
    implements ICount
{
    protected Count() throws RemoteException {
        super();
    }

    @Override
    public String count(String number) throws RemoteException {
        var message = "The number is: " + number;
        System.out.println(message);
        
        return message;
    }
}
