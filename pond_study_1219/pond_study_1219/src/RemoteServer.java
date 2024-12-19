
import java.rmi.Naming;

public class RemoteServer {
    public static void main(String[] args) throws Exception {
        RemoteServerImpl remoteObj = new RemoteServerImpl();
        Naming.rebind("RemoteObj", remoteObj);
    }
}
