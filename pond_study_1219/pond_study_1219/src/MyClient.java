import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyClient {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        MyRemoteInterface obj = (MyRemoteInterface)
        registry.lookup("RemoteObject");
        String result = obj.sayHello();
        System.out.println("Result: " + result);
    }
}
