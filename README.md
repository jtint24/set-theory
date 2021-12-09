# set-theory

A set theory library for Java, including the ability to create sets (collection-like structures with no duplicates) of any type. These sets support a wide variety of widely-used set operations including union, intersection, complement, difference, cartesian product, and subset detection. Additionally, sets support elementhood test and discrete/uncountable cardinalities. Discrete sets can also be converted into arrays.

## The Set Class

The set class is an abstract class that contains a variety of basic methods that all sets have (though infinite sets may not be able to perform all these methods in all circumstances). Sets contain elements of some singular type. These methods (for a Set of type T) are as follows:
 
 Method | Return Type | Description
 -------|-------------|------------
 `cardinality()` | int | Finds the cardinality of the set (the number of elements).
 `unionWith(Set a)` | Set | Gives a set with all the elements of either of the two sets.
 `intersectionWith(Set a)` | Set | Gives a set containing all the elements that are in both of the two sets.
 `differenceWith(Set a)` | Set | Gives a set containing all the elements of the receiver that are not in the argument.
 `productWith(Set a)` | Set | Gives the cartesian product of the two sets, that is, a set containing ordered pairs where the domain of the points is the receiver, and the range of them is the argument.
 `complement()` | Set | Gives a set containing exclusively all the elements not in the original set.
 `powerSet()` | Set | Gives a set containing all the subsets of the original set.
 `contains(T e)` | boolean | Tests whether the set contains the argument.
 `isSubset(Set a)` | boolean | Tests whether or not the argument is a subset of the receiver set.
 `equals(Set a)` | boolean | Tests if the sets contain exclusively all the same elements.
 `existsElementSatisfying(Condition c)` | boolean | Tests if there is an element in the set that satisfies the condition.
 `allElementsSatisfy(Condition c)` | boolean | Tests if all elements in the set satisfy the condition.
 `toArray()` | T[] | Gives an array with all the elements of the set.
 `isDiscrete[]` | boolean | Tests if the set is discrete or not.
 
 ### The DiscreteSet Class
 
 This class inherits Set and represents sets containing discrete elements. In addition to all the methods listed above, DiscreteClass also has the following constructors for a DiscreteSet containing elements of type T:
 
 Constructor | Description
  -------|--
 `DiscreteSet(T... elements)` | Makes DiscreteSet containing all the arguments.
 `DiscreteSet()` | Makes empty DiscreteSet.
 `DiscreteSet(ArrayList<T> elements)` | Makes DiscreteSet containing all the elements of the argument.
 
 This class also has two additional methods:
 
 Method | Return Type | Description
 -------|-------------|-------------
 `add(T e)` | void | Adds the argument to the set.
 `remove(T e)` | void | Removes the element from the set.
 
 ### The Complement Class
 
 Complement inherits from class and represents a set that is defined as some other set's compliment, a set which exclusively contains elements that the original does not. Because these sets are defined by what they *don't* include, not by what they *do* include, they have infinite cardinality. The Complement class has the following constructor
 
 Constructor | Description
 ------------|------------
 `Complement(Set a)` | Creates a complement with all the elements not in the argument.
 
 This class has no additional methods beyond what it inherits from Set and Object.
 
 ## OrderedPair
 
 OrderedPair is a class that contains an ordered pair, or two ordered values. These two values are the `domainValue` and the `rangeValue`. This class exists to support the productWith() method. 
 
 
