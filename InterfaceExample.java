// an interface should be written outside of the main method
interface WaterBottleInterface{
    String color = "Blue";

    void fillUp();
}


// this is the main method
class InterfaceExample implements WaterBottleInterface{
        public static void main(String[] args) {
            System.out.println(color);

            InterfaceExample ex = new InterfaceExample();
            ex.fillUp();
        }

        @Override
        public void fillUp(){
           System.out.println("It is filled");
        }
    }
