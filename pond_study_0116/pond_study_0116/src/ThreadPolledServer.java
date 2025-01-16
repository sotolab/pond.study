import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPolledServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8095);
        ExecutorService threadPool = Executors.newFixedThreadPool(10); // 고정 크기 스레드 풀 생성

        System.out.println("서버 시작 (포트 8095)");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            threadPool.execute(() -> handleClient(clientSocket));
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (clientSocket) {
            System.out.println("클라이언트 처리: " + clientSocket.getInetAddress());
            // 클라이언트와 통신 처리
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
