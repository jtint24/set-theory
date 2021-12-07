public abstract class Set<T>  {
    public abstract int cardinality(Set a);
    public abstract Set unionWith(Set a);
    public abstract Set intersectionWith(Set a);
    public abstract Set productWith(Set a);
    public abstract Set differenceWith(Set a);
    public abstract Set complement();
    public abstract Set powerSet();
    public abstract Set elementsWhere(Condition c);
    public abstract boolean contains(T e);
    public abstract boolean equals();
    public abstract boolean existsElementWhere(Condition c);
    public abstract boolean allElementsSatisfy(Condition c);
    public abstract T[] toArray();
    public abstract void forEach();
    public abstract void add(T e);
    public abstract void remove(T e);
}
