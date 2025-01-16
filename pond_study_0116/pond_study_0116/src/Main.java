import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("C:\\Users\\pond\\workspace\\pond_study\\pond_study_0116\\pond_study_0116\\src\\test.txt"); // 읽을 파일 경로 설정

        CompletableFuture.runAsync(() -> {
            try {
                System.out.println("비동기 작업 스레드: " + Thread.currentThread().getName());
                Thread.sleep(1000); // 작업 시뮬레이션
                String content = Files.readString(filePath); // 파일 읽기
                System.out.println("파일 내용:");
                System.out.println(content);
                System.out.println("비동기 작업 완료");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }).thenRun(() -> System.out.println("후속 작업 실행!"));

        System.out.println("메인 스레드: " + Thread.currentThread().getName());
    }
}