import java.lang.NumberFormatException;
public class Exceptions {

    public static void main(String[] args) {
       try{
           Person p1 = new Person(null, "9381", 54);
           Person p2 = new Person("Shahram", "2214", 58);
           Person p3 = new Person("Mehran", "31d82", 59);
       }
       catch (NumberFormatException e) {
           System.err.println("There is a problem with the Person id");
           e.printStackTrace();
       }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
