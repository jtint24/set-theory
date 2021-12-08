public abstract class Set<T>  {
    public abstract int cardinality();
    public abstract Set unionWith(Set a);
    public abstract Set intersectionWith(Set a);
    public Set productWith(Set a) {
        return new Product(this, a);
    }
    public abstract Set differenceWith(Set a);
    public Set complement() {
        return new Complement(this);
    }
    public abstract Set powerSet();
    public abstract Set elementsWhere(Condition c);
    public abstract boolean contains(T e);
    public abstract boolean isSubset(Set a);
    public boolean equals(Set a) {
        return a.isSubset(this) && this.isSubset(a);
    };
    public abstract boolean existsElementWhere(Condition c);
    public abstract boolean allElementsSatisfy(Condition c);
    public abstract T[] toArray();
}
