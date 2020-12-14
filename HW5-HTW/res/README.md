OVERVIEW
The problem this progrram solves is creating a View Controller application
based on the Model designed to play a hunt the wumpus game. 
On the technical aspect of the problem, the challege was to design a view controller
relationship with limited information and connections shared between the 
view and controller, but still with the capability of having a user play 
hunt the wumpus with no issues. 
All testing in this project was done via playing the game on the graphical interface. 

LIST OF FEATURES
GUI Implementation of game 
Graphical view of tunnels between caves
Restarting the game with a random seed
Multiple view screens that work together
Room maze map for the game
Shooting arrows into caves
Shooting arrows through tunnels into other caves
Game characters perform giving actions: Wumpus eats player, Superbat
whisks player away, Pit falls kill player, Player kills wumpus with an arrow
Player successfully navigates both maps

HOW TO RUN 
Please navigate to the folder where the JAR file is located, and run this command
java -jar Jar.jar --text : to run the text based version of the game
java -jar Jar.jar --gui : to run the gui based version of the game

HOW TO USE 
The program is an interactive traversal and shooting game, please follow the 
onscreen instructions to play. Be sure to only input numbers please. 
The game is played by navigating the player through a maze that has all 
cell locations covered. Cell locations are revealed when the player 
clicks or reaches the cells with arrow keys. If they player encounters objects
in the maze, the player is liable to die or win the game. 

DESCRIPTION OF EXAMPLE RUNS
No Example runs required on submission. Photo of maze provided in /res folder. 

DESIGN CHANGES
Not many changes were made to the model for the GUI implementation. 
The contorller however changed as it included methods that provided access between
the model and the view. Additionally, the controller was aware of all views 
playable in this game, and so had private field variables for them.
Additionally, the controller implement a features interface. 

ASSUMPTIONS 
The main assumption made in this project, was that a player can only 
traverse a tunnel if they have revealed it by a click. 

LIMITATIONS
The main limitation on this project was that the two player mode was not
able to be fully implemented. 