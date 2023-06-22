// 1.0
// collection 1.2 and Generics 1.5
// they provide Dynamic array
import java.util.*;


// iterator
// enhanced forloop
public class listPractice {
    public static void main(String[] args) throws Exception{
        // int values[] = new int[4]; // array of integers with the size of 4
        Object values1[] = new Object[4]; // An Object array with the size of 4. it can have any data type string, int, even a Class
        values1[0] = "Navin";
        values1[1] = 7;
        
        // lines above are fixed so we need Collection
        Collection<Object> values2 = new ArrayList<>();
        values2.add(3);
        values2.add("Navin");
        values2.add(5.8f);
        values2.add(77);
        
        values2.remove(77); // if you want to remove an element


        /* 
        Iterator<Object> i = values2.iterator(); // but the iterator is an old method

        while(i.hasNext()){
        System.out.println(i.next()); 
        }
        */
        for(Object i : values2){
            System.out.println(i);
        }
    }
}
