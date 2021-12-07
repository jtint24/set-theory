public class Tests {
    public static void main(String[] args) {
        Set mySet = new DiscreteSet("Hello", "goodbye", "welcome");
        mySet.powerSet();
        System.out.println(mySet.powerSet().toString());
    }
}
