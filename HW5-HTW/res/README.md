OVERVIEW
The problem this progrram solves is creating a Model Controller application
that gives a user the ability to play the hunt the wumpus game. On the
technical aspect of the problem, the challege was to design a model controller
relationship with limited information and connections shared between the 
model and controller, but still with the capability of havign a user play 
hunt the wumpus with no issues. 

LIST OF FEATURES
Wrapping Room Maze map for the game
Room maze map for the game
Shooting arrows into caves
Shooting arrows through tunnels into other caves
Building of tunnels between caves
Game characters perform giving actions: Wumpus eats player, Superbat
whisks player away, Pit falls kill player, Player kills wumpus with an arrow
Player successfully navigates both maps

HOW TO RUN 
Please navigate to the folder where the JAR file is located, and run this command
java -jar Jar.jar
No arguements required. 

HOW TO USE 
The program is an interactive traversal and shooting game, please follow the 
onscreen instructions to play. Be sure to only input numbers please. 

DESCRIPTION OF EXAMPLE RUNS
Run 1 [ Filename: KillWumpus.txt]:
	This example runs shows the player traversing the map. Once the player smells
	the wumpus, they try to kill the wumpus by shooting arrows. 

Run 2 [ Filename: WumpusEatsPlayer.txt]:
	This example runs shows the wumpus eating the player. The player traverses the maze until they run into the wumpus. 

Run 3 [ Filename:  SuperbatPitExample.txt]:
	This example runs shows the player traversing the map until they run into a 
	superbat. The superbat whisks the player away into another location, which 
	happened to be a pit. Thus, the player dies. 

DESIGN CHANGES
Some new functionns were introduced into the MazeImpl.java; 
previously rooms were referred to with the row column numbers, but the MazeImpl
now refers to positions in the maze as integer locations, i.e Location 1 or 
Location 12. 
Changes were made to the Room class. The room class initially did not have a 
secondary name, but the inclusion of a secondary name was required to represet 
tunnels in the maze. As such rooms that were tunnels had a secondary name of tunnel. 
Rooms were now called Caves, and rooms now had a list of occupants in them. This
was required to account for a super bat, wumpus or player in the room, and finally
tunnel rooms also had a list of neighbours they led too.  

Included character interface player inherits from. 
This was done for more purpose of extensibility, for example, in case in later 
versions of the game; the player could shoot arrows that'd kill superbats, or 
superbats could move around. As such, characters were made into objects bearing
in mind possible future inclusions.


ASSUMPTIONS 
THe main assumption made in this project, was that a room with two doors was 
actually a tunnel. Another assumption made was that arrows wrap around a wrapping 
room maze. 

LIMITATIONS
The main limitation was that testing was not done with a random seed that ensures 
the same radom numbers were generated during testing. Instead testing was done 
on multiple mazes, and by the developer playing the game and checking for 
expected behaviours.