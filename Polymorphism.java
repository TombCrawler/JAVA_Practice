// everything that's in side of a class is just variables and methods
// in real world, properties and things we can do
class Bird{
    public void sing(String song){
        System.out.println("Tweet tweet tweet");
    } 
}

// To inherit the method of Bird, you can copy and paste
// class Robin{
//          public void sing(){
//         System.out.println("Tweet tweet tweet");
//     } 
// }

// But you can simplify the class above by just using the extends method
// class Robin extends Bird{
        
//     }

// Apply polymorphism. Robin knows how to sing as Bird does, but overrides the Robin's own method.  
class Robin extends Bird{
    public void sing(){
        System.out.println("Twiddle Twiddle");
    } 
    }


// class Pelican extends Bird{
//        public void sing(){
//         System.out.println("KWAH KWAHH");
//        }
//  }   


public class Polymorphism {
    public static void main(String[] args){
        Robin b = new Robin();  // the "new" keyword is used to create a new instance (object) of a class.
        b.sing();
    }
}
