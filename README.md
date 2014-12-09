CSM6120 Assignment 2: Solving 8-puzzles with uninformed and informed search
===========================================================================
```
Project requires command line arguments to work:
<<<<<<< HEAD
To recompile and run the code from the commandline in windows:
1. enter the src folder
2. javac csm6120\*.java SearchTree\*.java SearchAlgorithms\*.java
3. java csm6120.Main pathToStartFile pathToGoalFile algorithmToUse

To recompile and run the code from a linux terminal:
1. enter the src folder
2. javac csm6120/*.java SearchTree/*.java SearchAlgorithms/*.java
3. java csm6120:Main pathToStartFile pathToGoalFile algorithmToUse

NOTE: 	The code is already compiled so it can be run directly by just doing step 3 from the src directory.
		The code is however compiled in on a windows machine and should run on all systems, however if problems
		arise please recompile it on your machine. 
		The Java JDK used to compile this is 8u25
=======
To compile from code and run:
javac src/csm6120/Main.java
java src/csm6120/Main pathToStartFile pathToGoalFile algorithmToUse
>>>>>>> 5d77351404693c2195ac2d45f6499f3c036cc041

To run the .jar file:
java -jar CSM6120_Assignment2.jar pathToStartFile pathToGoalFile algorithmToUse

Possible algirthm parameters are:
bfs   = Breadth-First search
dfs   = Depth-First search
gbfs  = Greedy Best-First search
astar = A Star search 
```