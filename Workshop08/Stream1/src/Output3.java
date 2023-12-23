import java.io.*;
import java.util.ArrayList;

public class Output3{

    public static void main(String[] args) {
        String fileName = "persons.ser";
        try(FileOutputStream fout = new FileOutputStream(fileName) ;
            ObjectOutputStream out = new ObjectOutputStream(fout);
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fin)){
            // Making Person objects
            Person p1 = new Person("Masoud", "9381", 54);
            Person p2 = new Person("Shahram", "2214", 58);
            Person p3 = new Person("Mehran", "3182", 59);

            // Writing person objects to file
            out.writeObject(p1);
            out.writeObject(p2);
            out.writeObject(p3);
            fout.close();
            out.close();

            // Reading person objects from file
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

        }catch(IOException e){
            e.printStackTrace();
        }catch(NumberFormatException e){
            System.err.println("[National id cannot contain noninteger characters]");
            e.printStackTrace();
        }

    }
}
