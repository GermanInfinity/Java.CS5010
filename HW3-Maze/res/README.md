README
How to use Program: 
Please run the driver, and follow the instructions on the command line. 
The instructions are the information needed to construct the specified maze. 
Providing the program with unexpected inputs would disrupt the program, by 
throwing exceptions. 
When the maze is constructed, the user navigates the player through the maze; via
command line inputs. 


Completed parts: 
Constructed Perfect, Room, and Wrapping room maze with an interface and an 
abstract class. 
The program is constructed as an intereactive puzzle, whereby the user has to 
guide the player. 
Player reaching goal location ends program. 
20% of the rooms in the maze have gold that is taken out when the player reaches
the room. 
10% of the rooms in the maze have a theif that always robs the player 10% of 
the players gold. 
IF the total number of rooms in a maze are odd, the math.ceil of 20% and 10% 
values of that number is taken to place gold and thieves respectively. 
At each the location, the maze always produces the possible moves of the player 
to the command line. 
The player, controlled by the use, make moves by specifying a direction. 

One difference in my implementation is the player never knows their location, 
I keep it this way as it makes it more realistic in that the player is lost 
and never really knows where they are, all they know are what directiosn they can
take; and only the maze knows the players location. 


DESIGN: 
The desgin was an interface implemented by an abstract class. 
The subclasses that inherit from the MazeImpl abstract class were the different 
types of mazes. 


** P.s: please bear with my design document, it was too big so i had to do it in 
two pieaces **