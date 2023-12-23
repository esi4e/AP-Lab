import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Server {
    public static void main(String[] args) throws Exception{
        int port = 9999;
        try(ServerSocket ss = new ServerSocket(port);
        ){
            System.out.println("waiting for client...");
            Socket s = ss.accept();
            System.out.println("client connected");
            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(isr);
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            String msgRead = bf.readLine();
            String msgWrite = "Hello client from server";
            pw.println(msgWrite);
            pw.flush();
            System.out.println(msgRead);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
