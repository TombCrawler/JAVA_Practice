// class helloworld
// {
// public static void main(String[] args)
//   {
//     System.out.println("Hello World");
//   }
// }


// with Swing
// Hello.java (Java SE 8)
import javax.swing.*;

public class helloworld extends JFrame {
    public  helloworld() {
        super("Hello World");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(new JLabel("Hello, world! Made it"));
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater( helloworld::new);
    }
}
