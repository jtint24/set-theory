import java.util.ArrayList;
import java.util.Collections;

public class IntervalUnion extends Set {

    ArrayList<IntervalSet> intervals = new ArrayList<IntervalSet>();

    public IntervalUnion(ArrayList<IntervalSet> subsets) {
        intervals = subsets;
        coalesce();
    }

    public IntervalUnion(IntervalSet... subsets) {
        Collections.addAll(intervals, subsets);
        coalesce();
    }

    @Override
    public int cardinality() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Set unionWith(Set a) {
        ArrayList<IntervalSet> newIntervals = (ArrayList<IntervalSet>) intervals.clone();
        if (a instanceof IntervalSet) {
            newIntervals.add((IntervalSet) a);
        } else if (a instanceof IntervalUnion) {
            newIntervals.addAll(((IntervalUnion) a).intervals);
        }
        IntervalUnion unionToReturn = new IntervalUnion(newIntervals);
        unionToReturn.coalesce();
        return unionToReturn;
    }

    @Override
    public Set intersectionWith(Set a) {
        ArrayList<IntervalSet> newIntervals = new ArrayList<>();
        if (a instanceof IntervalSet) {
            for (int i = 0; i<intervals.size(); i++) {
                IntervalSet subInterval = intervals.get(i);
                if (subInterval.overlapsWith((IntervalSet) a)) {
                    newIntervals.add((IntervalSet) subInterval.intersectionWith(a));
                }
            }
        } else if (a instanceof IntervalUnion) {
            for (int i = 0; i<intervals.size(); i++) {
                for (int j = 0; j<((IntervalUnion) a).intervals.size(); j++) {
                    if (((IntervalUnion) a).intervals.get(j).overlapsWith(intervals.get(i))) {
                        newIntervals.add((IntervalSet) intervals.get(i).intersectionWith(((IntervalUnion) a).intervals.get(j)));
                    }
                }
            }
        }
        return new IntervalUnion(newIntervals);
    }

    @Override
    public Set productWith(Set a) {
        return null;
    }

    @Override
    public Set differenceWith(Set a) {
        ArrayList<IntervalSet> newIntervals = new ArrayList<>();
        if (a instanceof IntervalSet) {
            for (int i = 0; i<intervals.size(); i++) {
                IntervalSet subInterval = intervals.get(i);
                if (subInterval.overlapsWith((IntervalSet) a)) {
                    newIntervals.add((IntervalSet) subInterval.differenceWith(a));
                } else {
                    newIntervals.add(subInterval);
                }
            }
        } else if (a instanceof IntervalUnion) {
            for (int i = 0; i<intervals.size(); i++) {
                for (int j = 0; j<((IntervalUnion) a).intervals.size(); j++) {
                    if (((IntervalUnion) a).intervals.get(j).overlapsWith(intervals.get(i))) {
                        newIntervals.add((IntervalSet) intervals.get(i).differenceWith(((IntervalUnion) a).intervals.get(j)));
                    } else {
                        newIntervals.add(intervals.get(i));
                    }
                }
            }
        }
        return new IntervalUnion(newIntervals);
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

    public String toString() {
        String runningString = "{";
        for (int i = 0; i<intervals.size()-1; i++) {
            runningString+=intervals.get(i).toString()+", ";
        }
        runningString+=intervals.get(intervals.size()-1).toString();
        return runningString+"}";
    }

    public void coalesce() {
        boolean changesMade = false;
        for (int i = 0; i<intervals.size(); i++) {
            for (int j = i; j<intervals.size(); j++) {
                if(intervals.get(i).contains(intervals.get(j))) {
                    intervals.set(i, (IntervalSet) intervals.get(i).unionWith(intervals.get(j)));
                    changesMade = true;
                }
            }
        }
        if (changesMade) {
            coalesce();
        }
    }
}
