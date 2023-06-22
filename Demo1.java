// https://www.youtube.com/watch?v=KAWoOgKsQns
import java.io.*;

class Student implements Serializable{
    // instance variable
    int rno; // for room number
    String name;
    int total_marks;
    
    // Make a constructor
    Student(int rno, String name, int total_marks){
        this.rno = rno;
        this.name = name;
        this.total_marks = total_marks;
    }
    public String toString(){
        return rno+" "+name+" "+total_marks; // " " is for spaces
    }
}
// Run this class --> java StudentDemo,  so that the system detects the main method
class StudentDemo{ 
    public static void main(String[] atgs) throws Exception {
        File file = new File("student.txt");
        Student s1 = new Student(101, "Love love love", 456);
        System.out.println(s1);
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(s1);
        oos.close();

    }
}