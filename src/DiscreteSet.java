import java.util.ArrayList;

public class DiscreteSet<T> extends Set {
    private ArrayList<T> elements;

    public DiscreteSet(T... _elements) {
        elements = new ArrayList<>();
        for (T element : _elements) {
            if (!elements.contains(element)) {
                elements.add(element);
            }
        }
    }

    public DiscreteSet(ArrayList<T> _elements) {
        elements = new ArrayList<>();
        for (T element : _elements) {
            if (!elements.contains(element)) {
                elements.add(element);
            }
        }
    }

    public DiscreteSet() {
        elements = new ArrayList<>();
    }

    @Override
    public int cardinality() {
        return elements.size();
    }

    @Override
    public Set unionWith(Set a) {
        ArrayList<T> newElements = elements;
        if (a instanceof DiscreteSet) {
            for (Object element : a.toArray()) {
                if (!newElements.contains((T)element)) {
                    newElements.add((T) element);
                }
            }
            return new DiscreteSet(newElements);
        }
        return null;
    }

    @Override
    public Set intersectionWith(Set a) {
        ArrayList<T> newElements = new ArrayList<>();
        if (a instanceof DiscreteSet) {
            for (Object element : a.toArray()) {
                if (!newElements.contains((T) element) && elements.contains((T) element)) {
                    newElements.add((T) element);
                }
            }
            return new DiscreteSet(newElements);
        }
        return null;
    }

    @Override
    public Set productWith(Set a) {
        return null;
    }

    @Override
    public Set differenceWith(Set a) {
        ArrayList<T> newElements = new ArrayList<>();
        if (a instanceof DiscreteSet) {
            for (T element : elements) {
                if (!newElements.contains(element) && !a.contains(element)) {
                    newElements.add(element);
                }
            }
            return new DiscreteSet(newElements);
        }
        return null;
    }

    @Override
    public Set complement() {
        return null;
    }

    @Override
    public Set powerSet() {
        Set<Set<T>> powerSet = new DiscreteSet();
        for (int i = 0; i<Math.pow(2, elements.size()); i++) {
            ArrayList<T> newElements = new ArrayList<>();
            for (int j = 1; j<=elements.size(); j++) {
                if (i%Math.pow(2,j)>=Math.pow(2,j-1)) {
                    newElements.add(elements.get(j-1));
                }
            }
            powerSet.add(new DiscreteSet(newElements));
        }
        return powerSet;
    }

    @Override
    public Set elementsWhere(Condition c) {
        Set<T> qualifiedSet = new DiscreteSet<T>();
        for (T element : elements) {
            if (c.satisfiedBy(element)) {
                qualifiedSet.add(element);
            }
        }
        return qualifiedSet;
    }

    @Override
    public boolean contains(Object a) {
        return elements.contains(a);
    }

    @Override
    public boolean isSubset(Set a) {
        for (T element : (T[]) a.toArray()) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Set a) {
        return this.isSubset(a) && a.isSubset(this);
    }

    @Override
    public boolean existsElementWhere(Condition c) {
        boolean retValue = false;
        for (T element : elements) {
            retValue = retValue || c.satisfiedBy(element);
        }
        return retValue;
    }

    @Override
    public boolean allElementsSatisfy(Condition c) {
        boolean retValue = true;
        for (T element : elements) {
            retValue = retValue && c.satisfiedBy(element);
        }
        return retValue;
    }

    @Override
    public Object[] toArray() {
        T[] retArray = (T[]) new Object[elements.size()];
        for (int i = 0; i<retArray.length; i++) {
            retArray[i] = elements.get(i);
        }
        return retArray;
    }

    @Override
    public void forEach(Iterated expr) {
        for (T element : elements) {
            expr.run(element);
        }
    }

    @Override
    public void add(Object e) {
        if (!elements.contains(e)) {
            elements.add((T) e);
        }
    }

    @Override
    public void remove(Object e) {
        elements.remove((T) e);
    }

    public String toString() {
        if (elements.size()>0) {
            String retString = "{";
            for (int i = 0; i < elements.size() - 1; i++) {
                retString += elements.get(i).toString() + ", ";
            }
            return retString + elements.get(elements.size() - 1) + "}";
        } else {
            return "{}";
        }
    }
}
