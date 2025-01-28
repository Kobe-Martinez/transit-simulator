# Transit Simulation

This project implements a transit simulation using a layered linked list to model various modes of transportation such as trains, buses, and walking paths. The simulation supports dynamic modifications to the transit system, including adding stops, removing stations, and finding optimal paths. Designed for exploring data structures and linked list concepts in Java.

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
