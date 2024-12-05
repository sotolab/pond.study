import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TCPServer {
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(9999); // 9999 포트로 서버 대기
            System.out.println("Server is waiting for a connection...");

            Socket socket = serverSocket.accept(); // 클라이언트 연결 대기
            System.out.println("Client connected!");
            socket.getRemoteSocketAddress();

            DataInputStream is = new DataInputStream(socket.getInputStream());
            System.out.println("Message from client: " + is.readUTF());

            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            os.writeUTF("Hello from server..." + socket.getLocalSocketAddress() + "\nGoodbye!");

            socket.close();
            serverSocket.close();
        } catch (SocketTimeoutException s){
            System.out.println("Socket Timed out!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
