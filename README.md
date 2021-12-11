# set-theory

A set theory library for Java, including the ability to create sets (collection-like structures with no duplicates) of any type. These sets support a wide variety of widely-used set operations including union, intersection, complement, difference, Cartesian product, and subset detection. Additionally, sets support elementhood tests and discrete/uncountable cardinalities. Discrete sets can also be converted into arrays.

## The Set Class

The set class is an abstract class that contains a variety of basic methods that all sets have (though infinite sets may not be able to perform all these methods in all circumstances). Sets contain elements of some singular type. These methods (for a Set of type T) are as follows:
 
 Method | Return Type | Description
 -------|-------------|------------
 `cardinality()` | int | Finds the cardinality of the set (the number of elements).
 `unionWith(Set a)` | Set | Gives a set with all the elements of either of the two sets.
 `intersectionWith(Set a)` | Set | Gives a set containing all the elements that are in both of the two sets.
 `differenceWith(Set a)` | Set | Gives a set containing all the elements of the receiver that are not in the argument.
 `productWith(Set a)` | Set | Gives the Cartesian product of the two sets, that is, a set containing ordered pairs where the domain of the points is the receiver, and the range of them is the argument.
 `complement()` | Set | Gives a set containing exclusively all the elements not in the original set.
 `powerSet()` | Set | Gives a set containing all the subsets of the original set.
 `contains(T e)` | boolean | Tests whether the set contains the argument.
 `isSubset(Set a)` | boolean | Tests whether or not the argument is a subset of the receiver set.
 `equals(Object a)` | boolean | Tests if the sets contain exclusively all the same elements.
 `existsElementSatisfying((T)->boolean c)` | boolean | Tests if there is an element in the set that satisfies the condition.
 `allElementsSatisfy((T)->boolean c)` | boolean | Tests if all elements in the set satisfy the condition.
 `toArray()` | T[] | Gives an array with all the elements of the set.
 `isDiscrete()` | boolean | Tests if the set is discrete or not.
 
 ### The DiscreteSet Class
 
 This class inherits Set and represents sets containing discrete elements. In addition to all the methods listed above, DiscreteSet also has the following constructors for a DiscreteSet containing elements of type T:
 
 Constructor | Description
  -------|--
 `DiscreteSet(T... elements)` | Makes a DiscreteSet containing all the arguments.
 `DiscreteSet()` | Makes an empty DiscreteSet.
 `DiscreteSet(ArrayList<T> elements)` | Makes a DiscreteSet containing all the elements of the argument.
 
 This class also has two additional methods:
 
 Method | Return Type | Description
 -------|-------------|-------------
 `add(T e)` | void | Adds the argument to the set.
 `remove(T e)` | void | Removes the element from the set.
 `toString()` | String | Returns a String formatted as a list of the elements of the set, seperated by commas, inside brackets
 
 ### The Complement Class
 
 Complement inherits from class and represents a set that is defined as some other set's compliment, a set which exclusively contains elements that the original does not. Because these sets are defined by what they *don't* include, not by what they *do* include, they have infinite cardinality. The Complement class has the following constructor
 
 Constructor | Description
 ------------|------------
 `Complement(Set a)` | Creates a complement with all the elements not in the argument.
 
 This class also inherits a `toString` method from Object:
 
 Method | Return Type | Description
 -------|-------------|------------
 `toString()` | String | Returns a String formatted "complement: " followed by the string representing the complemented set.
 
 This class has no additional methods beyond what it inherits from Set and Object.
 
 ## OrderedPair
 
 OrderedPair is a class that contains an ordered pair, or two ordered values. These two values are the `domainVal` of type T and the `rangeVal` of type S, which are the only two instance variables. This class exists to support the productWith() method. This product has the following constructor:
 
 Constructor | Description
 ------------|------------
 `OrderedPair(T _domainVal,S _rangeVal)` | sets the domain and range values to the arguments
 
 This product has/overrides the following methods:
 
 Method | Return Type | Description
 -------|-------------|------------
 `getDomainVal()` | T | returns `domainVal`
 `getRangeVal()` | S | returns `rangeVal`
 `setDomainVal(T e)` | void | sets `domainVal` to the argument
 `setRangeVal(S e)` | void | sets `rangeVal` to the argument
 `toString()` | String | returns a string of the format "("+domainVal+","+"rangeVal"+")"
 `equals(Object ob)` | boolean | returns whether the argument object is an OrderedPair with identical domain and range values
 
 ## Condition
 
 Condition is an interface used to support the use of condition lambdas on elements of type T in the Set class. It has one method, `satisfiedBy(T element)`, which returns a boolean.
 
