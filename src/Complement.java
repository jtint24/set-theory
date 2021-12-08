public class Complement<T> extends Set {
    private Set complemented;

    public <T> Complement(Set<T> _Set) {
        complemented = _Set;
    }

    @Override
    public int cardinality() {
        return 0;
    }

    @Override
    public Set unionWith(Set a) {
        return null;
    }

    @Override
    public Set intersectionWith(Set a) {
        return null;
    }

    @Override
    public Set differenceWith(Set a) {
        return null;
    }

    @Override
    public Set powerSet() {
        return null;
    }

    @Override
    public Set elementsWhere(Condition c) {
        return null;
    }

    @Override
    public boolean contains(Object e) {
        return false;
    }

    @Override
    public boolean isSubset(Set a) {
        return false;
    }

    @Override
    public boolean existsElementWhere(Condition c) {
        return false;
    }

    @Override
    public boolean allElementsSatisfy(Condition c) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}
