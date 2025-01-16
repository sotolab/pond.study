import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class NonBlocking {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open(); // Selector 생성
        ServerSocketChannel serverChannel = ServerSocketChannel.open();

        serverChannel.bind(new InetSocketAddress(8095)); // 포트 바인딩
        serverChannel.configureBlocking(false); // 논블로킹 모드 설정
        serverChannel.register(selector, SelectionKey.OP_ACCEPT); // Selector에 채널 등록

        System.out.println("서버가 시작되었습니다. 포트: 8095");

        while (true) {
            selector.select(); // 이벤트 발생 대기
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();

            while (keys.hasNext()) {
                SelectionKey key = keys.next();
                keys.remove();

                if (key.isAcceptable()) { // 연결 요청 처리
                    SocketChannel clientChannel = serverChannel.accept();
                    clientChannel.configureBlocking(false);
                    clientChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("클라이언트 연결됨: " + clientChannel.getRemoteAddress());
                } else if (key.isReadable()) { // 읽기 요청 처리
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(256);
                    clientChannel.read(buffer);
                    buffer.flip();

                    String message = new String(buffer.array()).trim();
                    System.out.println("메시지 수신: " + message);

                    buffer.clear();
                    clientChannel.write(ByteBuffer.wrap(("응답: " + message).getBytes()));
                }
            }
        }
    }
}
