import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyServer {
    public static void main(String[] args) throws Exception {
        MyRemoteObject obj = new MyRemoteObject();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("RemoteObject", obj);
        System.out.println("RemoteObject bound on registry");
    }
}
