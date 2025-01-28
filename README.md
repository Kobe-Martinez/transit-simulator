# Transit Simulation

The Transit Simulation project is a Java implementation that models a transportation system using layered linked lists to represent train stations, bus stops, and walking paths. Each layer is interconnected to simulate real-world transit, ensuring smooth transitions between modes of transportation. The project includes features for dynamically modifying the system, such as adding or removing train stations and bus stops, and introduces new layers like scooters when needed. It also supports finding the optimal path to a destination, recording all visited nodes for a comprehensive traversal overview. Additionally, the program can create a deep copy of the entire system, preserving all connections and data integrity.

This simulation is an excellent tool for understanding advanced linked list operations, pathfinding algorithms, and data structure management in Java. It provides a practical demonstration of how layered structures can be used to model complex systems and is ideal for students and developers exploring computer science concepts.


## Table of Contents

- [Features](#features)
- [Usage](#usage)
- [Code Structure](#code-structure)
- [Requirements](#requirements)
- [File Outputs](#file-outputs)
- [License](#license)
- [Important Note](#important-note)

## Features

- **Layered Linked List Representation**
  - Models train stations, bus stops, and walking paths as layers of a linked list.

- **Dynamic Modifications**
  - Add or remove train stations and bus stops.
  - Add new transportation layers such as scooters.

- **Pathfinding**
  - Computes the optimal path to a destination, recording all visited nodes.

- **Duplication**
  - Creates a deep copy of the entire layered linked list structure.

- **Data Consistency**
  - Ensures connections between layers are correctly maintained during modifications.

## Usage

1. **Clone the Repository**
   ```bash
   git clone https://github.com/Kobe-Martinez/transit-simulation.git
   ```

2. **Compile the Code**
   ```bash
   javac Transit.java
   ```

3. **Run the Program**
   Implement custom test cases in the `main` method to simulate transit system operations.

## Code Structure

- **Transit.java**
  - Core class containing methods to manage and simulate the transit system.

- **Layer Management**
  - Handles creation of layered linked lists representing the transit system.
  - Includes utilities for modifying and traversing the system.

- **Pathfinding**
  - Methods for computing optimal paths and recording visited nodes.

- **Duplication**
  - Ensures a deep copy of the layered list with all connections preserved.

## Requirements

- **Java**: Version 8 or higher.

## File Outputs

- No explicit file outputs. Results are printed to the console, and the layered list structure is maintained in memory.

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Important Note

This project is designed for educational purposes to demonstrate the use of layered linked lists in modeling and simulating transit systems. It serves as a valuable resource for understanding linked list operations and data structure management in Java.
