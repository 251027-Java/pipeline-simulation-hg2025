[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/edG9ClaZ)
# Lab: Simulate a CI/CD Pipeline

## Goal
Write a shell script (or Java program) that simulates a Build Pipeline. This helps understand the logic flow of CI/CD without needing a heavy Jenkins server.

## Requirements
1.  **Script**: Create `pipeline.sh` (or `Pipeline.java`).
2.  **Steps**:
    -   **Step 1 (Compile)**: Check if a dummy file `source_code.txt` exists. If yes, print "Compilation Success". If no, print "Error" and exit.
    -   **Step 2 (Test)**: Run a command that randomly passes or fails (use `RANDOM` in bash or `Math.random()` in Java).
        -   If fail: Print "Tests Failed", Exit.
        -   If pass: Print "Tests Passed", Continue.
    -   **Step 3 (Package)**: Create a file named `artifact.jar` (touch it).
    -   **Step 4 (Deploy)**: Move `artifact.jar` to a `deploy/` folder.

## Starter Code
-   `PipelineSimulation.java` provided.
