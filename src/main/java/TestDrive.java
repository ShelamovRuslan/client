import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TestDrive {
    public static void main(String[] args) {
        new TestDrive().run();
    }
    public void run () {
        try ( Socket socket = new Socket("localhost",9988)){
        new Thread(new ServerReader(socket)).start();
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                printWriter.println(bufferedReader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
