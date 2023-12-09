import java.io.*;

public class Output1 {

    public static void main(String[] args) {
       try{
           // Making Person objects
           Person p1 = new Person("Masoud", "9381", 54);
           Person p2 = new Person("Shahram", "2214", 58);
           Person p3 = new Person("Mehran", "31d82", 59);
           String fileName = "persons.ser";

           // Writing person objects to file
           FileOutputStream fout = new FileOutputStream(fileName);
           ObjectOutputStream out = new ObjectOutputStream(fout);
           out.writeObject(p1);
           out.writeObject(p2);
            out.writeObject(p3);
            fout.close();
            out.close();

            // Reading person objects from file
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fin);
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
        }

    }
}
