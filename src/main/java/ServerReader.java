import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerReader implements Runnable{

    private final Socket socket;

    public ServerReader(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            while (true) {
                writer.println("Line");
                System.out.println(reader.readLine());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
