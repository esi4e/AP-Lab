import java.io.Serializable;

public class Person implements Serializable {
   private String name;
   private String id;
   private int age;

   public Person(String name, String id, int age) throws IllegalArgumentException , NumberFormatException{
       if(name == null)
           throw new IllegalArgumentException("name cannot be null");
       if(id == null)
           throw new IllegalArgumentException("id cannot be null");
       if(age <= 0)
           throw new IllegalArgumentException("age cannot be null");
       Integer.parseInt(id);
       this.name = name;
       this.id = id;
       this.age = age;
   }

   @Override
   public String toString(){
       return "\nName:" + name + " \nAge:" + age + " \nId:" + id + "\n------------------------------------------------";
   }
}
