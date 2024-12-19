import java.rmi.Naming;

public class RemoteClient {
    public static void main(String[] args) throws Exception {
        RemoteInterface remoteObj=(RemoteInterface)
        Naming.lookup("rmi://192.168.0.79:1099/RemoteObj");
        String result = remoteObj.remoteMethod();
        System.out.println(result);
    }
}
