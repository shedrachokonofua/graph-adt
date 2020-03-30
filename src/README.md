## Compile
Within the src directory, run
```bash
javac graph/*.java utils/*.java Driver.java
```

## Usage
Within the src directory, run
```bash
java Driver <fileName> <action> <starting>
```
- <fileName> the name of the text file containing a description of a graph as defined below.
- <action> is either DFS, BFS or PATH, telling the program to execute a DFS or a BFS, or a path finding algorithm respectively.
- <starting> is a natural number telling the program which node to start the search from.

The input text file should follow this format
```
1 3
1 2
3 2
1 4
4 1
4 5
2 4
```
To represent the graph G(V,E) such that V:{1; 2; 3; 4;5} and E:{ (1, 3); (1, 2); (3, 2); (3, 4);(1, 4) ;(4, 1);(4,5)}