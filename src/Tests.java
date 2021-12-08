public class Tests {
    public static void main(String[] args) {
        Set mySet = new IntervalSet(1,true,10, true);
        System.out.println(mySet.toString());
        mySet = mySet.intersectionWith(new IntervalSet(1, false, 10, false));
        System.out.println(mySet.toString());
        mySet = mySet.intersectionWith(new IntervalSet(0.5, false, 5, true));
        System.out.println(mySet.toString());
    }
}
