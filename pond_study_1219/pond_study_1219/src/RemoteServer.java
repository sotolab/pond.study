
import java.rmi.Naming;

public class RemoteServer {
    public static void main(String[] args) throws Exception {
        RemoteServerImpl remoteObj = new RemoteServerImpl();
        Naming.rebind("rmi://192.168.0.79:1099/RemoteObj", remoteObj);
    }
}
