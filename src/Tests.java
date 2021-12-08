import java.util.ArrayList;

public class Tests {
    public static void main(String[] args) {
        Set domain = new DiscreteSet<String>("hello", "goodbye", "welcome");
        Set range = new DiscreteSet<Integer>(1, 2, 3);
        Set product = domain.productWith(range);

        System.out.println(product.toString());

        Set mySet = new DiscreteSet<OrderedPair>(new OrderedPair<String, Integer>("goodbye", 2));

        System.out.println(product.contains(new OrderedPair<String, Integer>("hello", 2)));
        System.out.println(product.differenceWith(mySet).toString());
    }
}
