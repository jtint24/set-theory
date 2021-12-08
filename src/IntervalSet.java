public class IntervalSet<T> extends Set {
    private double minimum;
    private double maximum;
    private boolean minInclusive;
    private boolean maxInclusive;

    public IntervalSet(double min, boolean mnInc, double max, boolean mxInc) {
        minimum = min;
        maximum = max;
        minInclusive = mnInc;
        maxInclusive = mxInc;
    }


    @Override
    public int cardinality() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Set unionWith(Set a) {
        if (a instanceof IntervalSet && a.isSubset(this)) {
            return a;
        }
        if (a instanceof IntervalSet && this.isSubset(a)) {
            return this;
        }
        if (a instanceof IntervalSet && this.contains(((IntervalSet<?>) a).minimum)) {
            return new IntervalSet(minimum, minInclusive, ((IntervalSet<?>) a).maximum, ((IntervalSet<?>) a).maxInclusive);
        }
        if (a instanceof IntervalSet && this.contains(((IntervalSet<?>) a).maximum)) {
            return new IntervalSet(((IntervalSet<?>) a).minimum, ((IntervalSet<?>) a).minInclusive, maximum, maxInclusive);
        }
        return null;
    }

    @Override
    public Set intersectionWith(Set a) {
        if (a instanceof IntervalSet && a.isSubset(this)) {
            return this;
        }
        if (a instanceof IntervalSet && this.isSubset(a)) {
            return a;
        }
        if (a instanceof IntervalSet && (this.contains(((IntervalSet<?>) a).minimum) || this.contains(((IntervalSet<?>) a).maximum))) {
            double largestMin = minimum>((IntervalSet<?>) a).minimum ? minimum : ((IntervalSet<?>) a).minimum;
            double smallestMax = maximum<((IntervalSet<?>) a).minimum ? maximum : ((IntervalSet<?>) a).maximum;
            boolean largestMinInclusive = minimum>((IntervalSet<?>) a).minimum ? minInclusive : ((IntervalSet<?>) a).minInclusive;
            boolean smallestMaxInclusive = maximum<((IntervalSet<?>) a).maximum ? maxInclusive : ((IntervalSet<?>) a).maxInclusive;
            if (minimum == ((IntervalSet<?>) a).minimum) {
                largestMinInclusive = minInclusive && ((IntervalSet<?>) a).minInclusive;
            }
            if (maximum == ((IntervalSet<?>) a).maximum) {
                smallestMaxInclusive = maxInclusive && ((IntervalSet<?>) a).maxInclusive;
                System.out.println(smallestMaxInclusive);
            }
            return new IntervalSet(largestMin, largestMinInclusive, smallestMax, smallestMaxInclusive);
        }
        return null;
    }

    @Override
    public Set productWith(Set a) {
        return null;
    }

    @Override
    public Set differenceWith(Set a) {
        if (a instanceof IntervalSet && !(this.contains(((IntervalSet<?>) a).minimum) && this.contains(((IntervalSet<?>) a).maximum))) {
            double resultantMinimum;
            double resultantMaximum;
            boolean resultantMinInc;
            boolean resultantMaxInc;
            if (this.contains(((IntervalSet<?>) a).minimum)) {
                resultantMinimum = ((IntervalSet<?>) a).minimum;
                resultantMinInc = ((IntervalSet<?>) a).minInclusive;
            } else {
                resultantMinimum = minimum;
                resultantMinInc = minInclusive;
            }
            if (this.contains(((IntervalSet<?>) a).maximum)) {
                resultantMaximum = ((IntervalSet<?>) a).maximum;
                resultantMaxInc = ((IntervalSet<?>) a).maxInclusive;
            } else {
                resultantMaximum = maximum;
                resultantMaxInc = maxInclusive;
            }
            return new IntervalSet(resultantMinimum, resultantMinInc, resultantMaximum, resultantMaxInc);
        }
        return null;
    }

    @Override
    public Set complement() {
        return null;
    }

    @Override
    public Set powerSet() {
        throw new RuntimeException("Power Sets cannot be formed with Intervals!");
    }

    @Override
    public Set elementsWhere(Condition c) {
        return null;
    }

    @Override
    public boolean contains(Object e) {
        if ((double)e > minimum && (double)e < maximum) {
            return true;
        }
        if (minInclusive && (double)e == minimum) {
            return true;
        }
        if (maxInclusive && (double)e == maximum) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isSubset(Set a) {
        if (a instanceof IntervalSet) {
            boolean hasSmallerMin = minimum<((IntervalSet<?>) a).minimum;
            if (((IntervalSet<?>) a).minimum==minimum && !((IntervalSet<?>) a).minInclusive==minInclusive) {
                hasSmallerMin = true;
            }
            boolean hasLargerMax = maximum>((IntervalSet<?>) a).maximum;
            if (((IntervalSet<?>) a).maximum==maximum && !((IntervalSet<?>) a).maxInclusive==maxInclusive) {
                hasLargerMax = true;
            }
            return hasLargerMax && hasSmallerMin;
        }
        return false;
    }

    public boolean overlapsWith(IntervalSet a) {
        return (this.contains(a.minimum) || this.contains(a.maximum));
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
        throw new RuntimeException("Can't iterate across an Interval!");
    }

    @Override
    public void add(Object e) {

    }

    @Override
    public void remove(Object e) {

    }

    public String toString() {
        String runningString = "";
        if (minInclusive) {
            runningString+="[";
        } else {
            runningString+="(";
        }
        runningString+=minimum+" to "+maximum;
        if (maxInclusive) {
            runningString+="]";
        } else {
            runningString+=")";
        }
        return runningString;
    }
}
