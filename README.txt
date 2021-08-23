THE PROJECT

This is a java library that includes the basic functionality to retrieve the k-complementary pairs for a given integer array.
Within the library we can find two public functions:

- findComplementaryPairs will return a StringBuffer containing the k-complementary pairs, removing all the duplicates.
  The algorithm implemented only goes through the input array once (O(n), but the array is sorted at the beginning (O(NlogN)), so it has a estimated time complexity of O(n)*O(NlogN) = O(NlogN).
  As it stores the output in a new variable with size proportional to the input array, the estimated space complexity should be O(n).

- findComplementaryPairIndexes will return a list of pairs of integers (ComplementaryPairs), representing the indexes of the numbers in the original array.
  For instance, for the array [1, 2, 3] and k=4, it will return [0,2].
  The algorithm implemented goes through the input array one time for every element, so the time complexity should be O(N^2).
  As it stores the output in a new variable with size proportional to the input array, the estimated space complexity should be O(n).


INSTALLATION AND DEPENDENCIES

This is a maven project created with eclipse, and can be imported in any other eclipse environment or built in a machine properly configured with Java and Maven.
Internet access is required to build it (or access to a maven repository containing all the dependencies).
The main dependencies are:
- Java 16
- jUnit 4.11
- Maven 3.8.1


USAGE

This library can be included and used in your java project.
For examples of usage, please refer to the jUnit tests.


