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
    public int cardinality(Set a) {
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
            for (Object element : elements) {
                if (!newElements.contains((T) element) && !a.contains((T) element)) {
                    newElements.add((T) element);
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
            for (int j = 1; i<elements.size(); i++) {
                if (i%Math.pow(2,j)>Math.pow(2,j-1)) {
                    //System.out.println(elements.get());
                    newElements.add(elements.get(j-1));
                }
            }
            powerSet.add(new DiscreteSet(newElements));
        }
        return powerSet;
    }

    @Override
    public Set elementsWhere(Condition c) {
        return null;
    }

    @Override
    public boolean contains(Object a) {
        return false;
    }

    @Override
    public boolean equals() {
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
    public void forEach() {

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
        String retString = "{";
        for (T element : elements) {
            retString+=element.toString()+", ";
        }
        return retString+"}";
    }
}
