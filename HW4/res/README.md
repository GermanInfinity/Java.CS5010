README
How to use Program: 
Please run the driver. The encoding class gives you the ability to encode a 
message without a symbol set and with a symbol set. The encoding class also has
a function that returns the encoded message. 
Messages and symbol sets can be read in from a file or the command line. 
Please provide full file path to read from file. 
The file sample must have a message on the first line, the second line contains
the code length. The encoded result is written to a specified file. 

We use the number of printable characters in a computer to give an upper bound on 
coding length (ASCII PRINTABLE CHARACTERS (CHARACTER CODE 48-127)).
Every element in the priority starts counting from the ASCII value of 48, which 
is a symbol of 0. We only take symbols up to 127th ASCII number. 


Completed parts: 
Encode class is completed, along with an implementation of a priority queue
that uses a comparator. 
The encode class has two constructors, one for encoding with a symbol set and 
another for encoding without one. Symbol sets are represented with dictionaries. 



DESIGN: 
