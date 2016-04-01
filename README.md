# solution to coding challenge.
*Given an hour and minute return the time in words.*

Table of contents:

1. [Solution Client Class](README.md#solutionjava)
2. [Integer to String converter](README.md#2-intToStringConverterjava)
3. [Time Interpretation module](README.md#3-timeInterpreterjava)
4. [Solution Approach](README.md#4-solution-approach)
5. [Unit Tests](README.md#5-unit-tests)
 
## Solution.java 
[Solution Client Class](TimeInterpreter/src/Solution.java) - This is the main entry point to test out the classes.

## IntToStringConverter.java 
[Digit(s) to String representation converter](TimeInterpreter/src/IntToStringConverter.java)
A class that takes any digit and returns to the words representation
This class is largely inspired by my research online for a more robust way to
handle this type of conversion.
In the spirit of OOP, I've choosen to implement this class to abstract,
the core classes and this conversion. With just the API exposure, I can
utilize this class for other purposes.
The interaction between this class and TimeInterpreter.class is entirely
agnostic.

## TimeInterpreter.java
[Time Interpretation module](TimeInterpreter/src/TimeInterpreter.java)
This is the core of the application. In my solution design I had two choices.
1. Validate during class instantiation - This was I can utilize constructor
overloading to allow users the flexibility of input types. i.e - Hour and Minutes
can either be integers, floats (where I round to nearest hour), and string.

2. Let the construction be a plain constructor that accepts nothing. And then have the inputs
entered during the call to validateAndDisplay(). The advantage of this is that you just need
one instance of the TimeInterpreter class for various time conversion, but losing the utility of constructor/behavior overload

Both cases have merits and demerits, but for the sake of user flexibility, I have chosen option 2 above. a design that trades off memory
in the creation of class instance to giving the user the flexibility of input choices. The constructor allows the user to
input time as valid integers, string that can be parsed as valid integers
and floats that can be parsed as valid integers.

NOTE: To utilize the string overloaded constructor, it must be a valid integer encapsulated in string "5" and not a float
like "5.09"

## Solution Approach

In Solution.java, you will find sample test cases as the following.
```
TimeInterpreter timeInterpreter;

        // Validate constructor overloading with strings
        timeInterpreter = new TimeInterpreter("4", "59");
        timeInterpreter.validateAndDisplay();

        // Validate constructor overloading with floating point numbers
        timeInterpreter = new TimeInterpreter(5.009, 0.999);
        timeInterpreter.validateAndDisplay();

        // Validate constructor overloading with integers
        timeInterpreter = new TimeInterpreter(5, 01);
        timeInterpreter.validateAndDisplay();

        timeInterpreter = new TimeInterpreter(5, 10);
        timeInterpreter.validateAndDisplay();

        timeInterpreter = new TimeInterpreter(5, 15);
        timeInterpreter.validateAndDisplay();

        timeInterpreter = new TimeInterpreter(5, 30);
        timeInterpreter.validateAndDisplay();

        timeInterpreter = new TimeInterpreter(5, 40);
        timeInterpreter.validateAndDisplay();

        timeInterpreter = new TimeInterpreter(5, 45);
        timeInterpreter.validateAndDisplay();

        timeInterpreter = new TimeInterpreter(5, 47);
        timeInterpreter.validateAndDisplay();

        timeInterpreter = new TimeInterpreter(5, 28);
        timeInterpreter.validateAndDisplay();
```


The code executes and outputs the following results. As defined in the problem.
```
One minute to five  AM.
Five o' clock AM.
One minute past five  AM.
Ten minutes past five  AM.
Quarter past five  AM.
Half past five  AM.
Twenty minutes to six  AM.
Quarter to six  AM.
Thirteen minutes to six  AM.
Twenty eight minutes past five  AM.
```
## Unit Tests
The following link shows Junit4 test cases that have executed successfully with no failures.
[Successfully validated Testcases](TimeInterpreter/src/TimeInterpreterTest.java)
