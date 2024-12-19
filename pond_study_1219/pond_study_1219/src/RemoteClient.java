import java.rmi.Naming;

public class RemoteClient {
    public static void main(String[] args) throws Exception {
        RemoteInterface remoteObj=(RemoteInterface)
        Naming.lookup("RemoteObj");
        String result = remoteObj.remoteMethod();
        System.out.println(result);
    }
}
