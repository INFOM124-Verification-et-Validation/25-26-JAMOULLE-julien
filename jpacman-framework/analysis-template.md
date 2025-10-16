# Specification-based Testing

## 1. Goal, inputs and outputs
- Goal: Determine the next direction where clyde will go
- Input domain: Map, player (pacman) , clyde position
- Output domain: Direction or Null

## 2. Explore the program (if needed)

## 3. Identify input and output partitions

Partition: ensemble de valeur qui font que le programme se comportera de la même manière

### Input partitions

#### Individual inputs
Distance partition (clyde and packman): 
- 01: Clyde is within 8 grid spaces of pacman(distance<8)
- 02: Clyde is at 8 grid spaces of pacman(distance=8)
- 03: Clyde is at more than 8 grid spaces of pacman(distance>8)

Pacman not on the board partition
Pacman on the edge of the board partition
Pacman does not have a square partition 

Obstacle direction partition:
-01: Path of clyde is free
-02: Path of clyde is blocked 
-03: Clyde is on pacman
-04: Clyde has several equivalent movements

Not valid maps:
-01: Multiple clyde 
-02: Multiple pacman
-03: Clyde is on pacman

#### Combinations of input values

Combine the partition case. Obstacle and Distance are the most important here. 

Distance <8 and path free
Distance <8 and path block
Distance <8 and multiple path 

Distance =8 and path free
Distance =8 and path block
Distance =8 and multiple path

Distance >8 and path free
Distance >8 and path block
Distance >8 and multiple path

### Output partitions
-Empty direction
-Direction closer from pacman
-Direction further from pacman

## 4. Identify boundaries
Not valid maps:
-01: Multiple clyde
-02: Multiple pacman
-03: Clyde is on pacman

Pacman at the edge of the board partition 
Pacman go from one edge to the other edge 

## 5. Select test cases

Distance<8:
 t1: Path free => Direction further from pacman
 t2: Path blocked => Empty direction 
 t3: Multiple moves => Direction further from pacman

And so forth for the other distance
For the boundaries try to test them alone (no need to combine)
Boundaries:
 t10: Multiple clyde
 t11: Multiple pacman
 ...



