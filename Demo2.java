// https://www.youtube.com/watch?v=KAWoOgKsQns
import java.io.*;

  
// Run this class --> java Demo2,  so that the system detects the main method
class Demo2{ 
    public static void main(String[] atgs) throws Exception {
        File file = new File("student.txt");
        
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Student s1 = (Student)ois.readObject();
        ois.close();
        
        System.out.println(s1);
    }
}