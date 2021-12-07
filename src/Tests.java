public class Tests {
    public static void main(String[] args) {
        Set mySet = new DiscreteSet("Hello", "goodbye", "howdy", "Hello", "bolon", "glorp");
        System.out.println(mySet);
        mySet = mySet.unionWith(new DiscreteSet("welcome", "Hello", "howdy"));
        System.out.println(mySet.toString());
        mySet = mySet.intersectionWith(new DiscreteSet("Hello", "goodbye", "howdy", "glorp", "snop", "welcome"));
        System.out.println(mySet.toString());
        mySet = mySet.differenceWith(new DiscreteSet("glorp", "shmoopy"));
        System.out.println(mySet.toString());
    }
}
