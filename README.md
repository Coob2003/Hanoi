# Hanoi
A simple Java implementation of the towers of Hanoi puzzle.  
Uses 4 rings, but can be changed by editing the ringCount variable in controller/Play.java  
  
## Dir structure
Hanoi  
L controller  
|  L Play.java // Program containing the main() function. Run this file to run the solution  
L model  
  L Game.java // Class definition for the game of Hanoi. Contains three towers  
  L Ring.java // Class definition for the Ring object  
  L RingSizeException.java // Exception class interrupting the program if an invalid ring placement is found  
  L Tower.java // Class definition for the Tower object. Contains a variable number of rings  
