// https://youtu.be/uu20xO9AaU4
// The lectue for map interface
import java.util.Map;
// import java.util.HashMap;
import java.util.Set;
import java.util.*;


public class MapDemo {
    public static void main(String[] args){
        // Map <String, String> map = new HashMap<>();
        Map <String, String> map = new Hashtable<>(); // Hashtable which implements Map inside of its class does the same thing as HashMap does.
        map.put("myName", "Navin");
        map.put("actor", "John");
        map.put("ceo", "Marisa");
        map.put("actor", "Pole"); // You can not ue the same key name otherwise it's overridden 
        
        // keySet method returns you a set of the key
        Set<String> keys = map.keySet();

        for(String key : keys){
            System.out.println(key + " " + map.get(key));
        }
}
}