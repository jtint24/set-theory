import java.util.ArrayList;

public class Complement<T> extends Set {
    private Set complemented;

    public <T> Complement(Set<T> _Set) {
        complemented = _Set;
    }

    @Override
    public int cardinality() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Set unionWith(Set a) {
        ArrayList<T> newComplemented = new ArrayList<>();
        for (Object antielement : complemented.toArray()) {
            if (!a.contains(antielement)) {
                newComplemented.add((T)antielement);
            }
        }
        return new Complement(new DiscreteSet(newComplemented));
    }

    @Override
    public Set intersectionWith(Set a) {
        ArrayList<T> aElements = new ArrayList<>();
        for (Object aElement : a.toArray()) {
            if (contains(aElement)) {
                aElements.add((T) aElement);
            }
        }
        return new DiscreteSet(aElements);
    }

    @Override
    public Set differenceWith(Set a) {
        ArrayList<T> aElements = new ArrayList<>();
        for (Object aElement : a.toArray()) {
            aElements.add((T) aElement);
        }
        for (Object antiElement : complemented.toArray()) {
            if (!aElements.contains(antiElement)) {
                aElements.add((T) antiElement);
            }
        }
        return new Complement(new DiscreteSet(aElements));
    }

    @Override
    public Set powerSet() {
        throw new RuntimeException("can't get power set of an indiscrete set!");
    }

    @Override
    public Set elementsWhere(Condition c) {
        return null;
    }

    @Override
    public boolean contains(Object e) {
        return !complemented.contains(e);
    }

    @Override
    public boolean isSubset(Set a) {
        for (Object element : a.toArray()) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
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
        throw new RuntimeException("can't get an array of an indiscrete set!");
    }

    @Override
    public boolean isDiscrete() {
        return false;
    }

    public String toString() {
        return "complement:"+complemented.toString();
    }
}
