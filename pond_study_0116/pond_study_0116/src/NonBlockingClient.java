import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NonBlockingClient {
    public static void main(String[] args) {
        try {
            // 서버에 연결
            InetSocketAddress serverAddress = new InetSocketAddress("localhost", 8095);
            SocketChannel clientChannel = SocketChannel.open(serverAddress);

            // 서버로 메시지 전송
            String message = "Hello, Non-blocking Server!";
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
            clientChannel.write(buffer);

            // 서버로부터 응답 수신
            buffer.clear();
            clientChannel.read(buffer);
            buffer.flip();
            System.out.println("서버 응답: " + new String(buffer.array(), 0, buffer.limit()));

            clientChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
