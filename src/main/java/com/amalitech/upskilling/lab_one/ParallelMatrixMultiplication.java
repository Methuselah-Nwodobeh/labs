package com.amalitech.upskilling.lab_one;

import java.util.concurrent.ForkJoinPool;

public class ParallelMatrixMultiplication {
    public static void main(String[] args) {
        int[][] inputMatrixA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] inputMatrixB = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};

        int numberOfRowsOrA = inputMatrixA.length;
        int numberOfColumnsA = inputMatrixA[0].length;
        int numberOfRowsOrB = inputMatrixB.length;
        int numberOfColumnsB = inputMatrixB[0].length;

        if (numberOfColumnsA != numberOfRowsOrB) {
            System.out.println("Matrix dimensions are not compatible for multiplication.");
            return;
        }

        int[][] result;
        try (ForkJoinPool pool = new ForkJoinPool()) {
            MatrixMultiplicationTask task = new MatrixMultiplicationTask(inputMatrixA, inputMatrixB,
                    0, numberOfRowsOrA, 0, numberOfColumnsB);
            result = pool.invoke(task);
        }

        System.out.println("Matrix A:");
        printMatrix(inputMatrixA);
        System.out.println("Matrix B:");
        printMatrix(inputMatrixB);
        System.out.println("Result:");
        printMatrix(result);
    }

    // Helper method to print the matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}