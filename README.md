# hopper_coding_challenge
The coding challenge for hopper.com

## Solution.java 
[Solution Client Class](TimeInterpreter/src/Solution.java) - This is the main entry point to test out the classes.

## IntToStringConverter.java 
[Digit(s) to String representation converter](TimeInterpreter/src/IntToStringConverter.java)
A generic class that takes any digit and returns to the words representation
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

