import java.util.ArrayList;

public class Tests {
    public static void main(String[] args) {
        Set complemented = new DiscreteSet<String>("hello", "goodbye", "welcome");
        Set myComplement = new Complement(complemented);
        System.out.println("contains hello "+ myComplement.contains("hello"));
        System.out.println("contains rufus "+ myComplement.contains("rufus"));
        Set otherSet = new DiscreteSet("this thing", "hello", "not me");
        myComplement = myComplement.unionWith(otherSet);
        System.out.println("union performed ");
        System.out.println("contains hello "+myComplement.contains("hello"));
        System.out.println("toString "+myComplement.toString());
        myComplement = myComplement.differenceWith(new DiscreteSet("rufus","hello","melow","welcome"));
        System.out.println("difference performed");
        System.out.println("toString: "+myComplement.toString());
    }
}
