import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class OptimizedSocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.setReuseAddress(true); // 포트 재사용 설정
        serverSocket.bind(new InetSocketAddress(8095));

        System.out.println("서버가 시작되었습니다. 포트: 8095");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("클라이언트 연결됨: " + clientSocket.getInetAddress());

            // 성능 최적화를 위한 소켓 설정
            clientSocket.setTcpNoDelay(true); // Nagle 알고리즘 비활성화
            clientSocket.setReceiveBufferSize(64 * 1024); // 수신 버퍼 크기 증가
            clientSocket.setSendBufferSize(64 * 1024); // 송신 버퍼 크기 증가

            new Thread(() -> handleClient(clientSocket)).start(); // 멀티스레드 처리
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {

            String input;
            while ((input = in.readLine()) != null) {
                System.out.println("수신: " + input);
                out.write("응답: " + input + "\n");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
