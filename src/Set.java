import java.util.ArrayList;

public abstract class Set<T>  {
    public abstract int cardinality();
    public abstract Set unionWith(Set a);
    public abstract Set intersectionWith(Set a);
    public Set productWith(Set a) {
        if (isDiscrete()) {
            ArrayList<OrderedPair> prodSetElements = new ArrayList<>();
            for (T multiplicand : this.toArray()) {
                for (Object multiplier : a.toArray()) {
                    prodSetElements.add(new OrderedPair(multiplicand, multiplier));
                }
            }
            return (Set) (new DiscreteSet<OrderedPair>(prodSetElements));
        } else {
            throw new RuntimeException("cannot find product of nondiscrete set!");
        }
    }
    public abstract Set differenceWith(Set a);
    public Set complement() {
        return new Complement(this);
    }
    public abstract Set powerSet();
    public abstract Set elementsWhere(Condition c);
    public abstract boolean contains(T e);
    public abstract boolean isSubset(Set a);
    @Override
    public boolean equals(Object a) {
        return ((Set)a).isSubset(this) && this.isSubset((Set)a);
    };
    public abstract boolean existsElementSatisfying(Condition c);
    public abstract boolean allElementsSatisfy(Condition c);
    public abstract T[] toArray();
    public abstract boolean isDiscrete();
}
