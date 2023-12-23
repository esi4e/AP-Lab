import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client{
    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int port = 9999;
        try(Socket s = new Socket(ip, port) ;
            OutputStream os = s.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            ){
            String msg = "Hello server from client\r\n";
//            while(true){
//                pw.println(msg);
//                Thread.sleep(2000);
//            }
//            pw.println(msg);
            pw.write(msg);
            pw.flush();
            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(isr);
            String msgRead = bf.readLine();
            System.out.println(msgRead);
        }catch(Exception e){
           e.printStackTrace();
        }

    }

}