package com.revature.lab;

import java.io.File;
import java.io.IOException;

public class PipelineSimulation {

    public static void main(String[] args) {
        System.out.println("--- Starting Pipeline ---");

        // Stage 1: Build
        if (!runStage("Build", () -> checkSourceCode()))
            return;

        // Stage 2: Test
        if (!runStage("Test", () -> runRandomTests()))
            return;

        // Stage 3: Deploy
        if (!runStage("Deploy", () -> deployArtifact()))
            return;

        System.out.println("--- Pipeline SUCCESS ---");
    }

    private static boolean runStage(String name, Supplier<Boolean> task) {
        System.out.println("Running Stage: " + name + "...");
        
        // TODO: Execute task and handle return value
        boolean success = task.get();
        if (success) {
            System.out.println(name + " stage completed successfully.");
        } else {
            System.out.println(name + " stage FAILED.");
        }
        return success;
    }

    // TODO: Implement helper methods

    private static boolean checkSourceCode() {
        File file = new File("source_code.txt");
        if (file.exists()) {
            System.out.println("Compilation Success");
            return true;
        } else {
            System.out.println("Error: source_code.txt not found.");
            return false;
        }
    }

    private static boolean runRandomTests() {
        // Randomly returns true or false
        // Simulates a 50/50 chance of failure (0.0 to 1.0 range)
        // If > 0.5, tests pass; otherwise, the pipeline exits to prevent deploying bad code
        boolean passed = Math.random() > 0.5;
        if (passed) {
            System.out.println("Tests Passed");
        } else {
            System.out.println("Tests Failed");
        }
        return passed;
    }

    private static boolean deployArtifact() {
        try {
            // Create the artifact file
            File artifact = new File("artifact.jar");
            if (artifact.createNewFile()) {
                System.out.println("Artifact packaged.");
            }

            // Move to deploy folder
            File deployDir = new File("deploy");
            if (!deployDir.exists()) {
                deployDir.mkdir();
            }

            File destination = new File("deploy/artifact.jar");
            if (artifact.renameTo(destination)) {
                System.out.println("Deployed to deploy folder.");
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            System.out.println("Deployment Error: " + e.getMessage());
            return false;
        }
    }

    interface Supplier<T> {
        T get();
    }
}