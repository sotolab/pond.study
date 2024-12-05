import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 9999);
            System.out.println("Connected to Server");

            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            os.writeUTF("Hello from client... " + socket.getLocalSocketAddress());

            DataInputStream is = new DataInputStream(socket.getInputStream());
            System.out.println("Message from server: " + is.readUTF());

            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
