import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteServerImpl extends UnicastRemoteObject implements RemoteInterface {
    public RemoteServerImpl() throws RemoteException{
        super();
    }
    public String remoteMethod() throws RemoteException{
        return "Hello from the Remote Server!";
    }
}
