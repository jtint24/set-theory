import java.util.ArrayList;

public class Union extends Set {
    private ArrayList<Set> subsets = new ArrayList<>();

    public ArrayList<Set> getSubsets() {
        return subsets;
    }

    @Override
    public int cardinality() {
        int runningCardinality = 0;
        for (Set subset : subsets) {
            runningCardinality+=subset.cardinality();
        }
        return runningCardinality;
    }

    @Override
    public Set unionWith(Set a) {
        if (a instanceof Union) {
            for (Set subset : ((Union) a).getSubsets()) {
                if (!this.contains(subset)) {
                    subsets.add(subset);
                }
            }
        } else {
            if (!this.contains(a)) {
                subsets.add(a);
            }
        }
        return null;
    }

    @Override
    public Set intersectionWith(Set a) {
        return null;
    }

    @Override
    public Set productWith(Set a) {
        return null;
    }

    @Override
    public Set differenceWith(Set a) {
        return null;
    }

    @Override
    public Set complement() {
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
    public boolean equals(Set a) {
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

    @Override
    public void forEach(Iterated expr) {

    }

    @Override
    public void add(Object e) {

    }

    @Override
    public void remove(Object e) {

    }
}
