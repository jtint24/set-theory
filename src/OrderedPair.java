public class OrderedPair<T,S>{
    private T domainVal;
    private S rangeVal;

    public T getDomainVal() {
        return domainVal;
    }

    public void setDomainVal(T domainVal) {
        this.domainVal = domainVal;
    }

    public S getRangeVal() {
        return rangeVal;
    }

    public void setRangeVal(S rangeVal) {
        this.rangeVal = rangeVal;
    }

    public OrderedPair(T _domainVal, S _rangeVal) {
        domainVal = _domainVal;
        rangeVal = _rangeVal;
    }

    @Override
    public String toString() {
        return "("+domainVal+","+rangeVal+")";
    }

    @Override
    public boolean equals(Object op) {
        return ((T)((OrderedPair)op).domainVal).equals(domainVal) && ((S)((OrderedPair)op).rangeVal).equals(rangeVal);
    }

    @Override
    public int hashCode() {
        return domainVal.hashCode()+rangeVal.hashCode();
    }
}
