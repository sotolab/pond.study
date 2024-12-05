import java.net.InetAddress;

public class IPAddress {
    public static void main(String[] args){
        try{
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println("IP Address " + address.getHostAddress());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
