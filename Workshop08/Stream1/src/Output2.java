import java.io.*;
import java.util.ArrayList;

public class Output2 {

    public static void main(String[] args) {
        FileOutputStream fout = null;
        ObjectOutputStream out = null;
        FileInputStream fin = null;
        ObjectInputStream in = null;
        try{
            // Making Person objects
            Person p1 = new Person("Masoud", "9381", 54);
            Person p2 = new Person("Shahram", "2214", 58);
            Person p3 = new Person("Mehran", "31d82", 59);
            String fileName = "persons.ser";

            // Writing person objects to file
            fout = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fout);
            out.writeObject(p1);
            out.writeObject(p2);
            out.writeObject(p3);
            fout.close();
            out.close();

            // Reading person objects from file
            fin = new FileInputStream(fileName);
            in = new ObjectInputStream(fin);
            while(true){
                try{
                    Object obj = in.readObject();
                    Person p = (Person) obj;
                    System.out.println(p);
                }catch(EOFException e){
                    break;
                }catch(ClassNotFoundException e){
                    e.printStackTrace();
                    /*
                    This exception typically occurs in scenarios where the
                    runtime environment is unable to locate and load the
                    specified class. Some common reasons for this exception include:
                    */
                }
            }
            fin.close();
            in.close();

        }catch(IOException e){
            e.printStackTrace();
        }catch(NumberFormatException e){
            System.err.println("[National id cannot contain noninteger characters]");
            e.printStackTrace();
        }finally{
            if(fout != null){
                try {
                    fout.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(out != null){
                try {
                    fout.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(fin != null){
                try {
                    fin.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(in != null){
                try {
                    in.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
