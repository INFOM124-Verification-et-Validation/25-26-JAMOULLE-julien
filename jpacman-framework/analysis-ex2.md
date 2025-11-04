# Specification-based Testing

## 1. Goal, inputs and outputs
- Goal: Determine the next direction Inky will go
- Input domain: Map,Blinky location,Pacman (square two space ahead), Inky position
- Output domain: Direction, empty and null 

## 2. Explore the program (if needed)

## 3. Identify input and output partitions

Partition: ensemble de valeur qui font que le programme se comportera de la même manière

### Input partitions


#### Individual inputs:


Obstacle direction partitions:
- O1: Path of Inky is free
- 02: Path of Inky is blocked

Obstacle direction partitions:
- O1: Path of Blinky is free
- 02: Path of Blinky is blocked
- 03: Blinky  has mutliple valid moves

Pacman position partition:
Pacman is at the position where the bug is not present 
pacman as a partition where the bug is present
pacman has not two square in front of him 

#### Combinations of input values

Combine the partition case. 


### Output partitions

- Empty direction
- Direction as behavior specifies

## 4. Identify boundaries

Two phantoms are blocked 
there is no blinky
there is no pacman 


## 5. Select test cases





