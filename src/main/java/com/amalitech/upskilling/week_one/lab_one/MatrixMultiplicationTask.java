package com.amalitech.upskilling.week_one.lab_one;

import java.util.concurrent.RecursiveTask;

class MatrixMultiplicationTask extends RecursiveTask<int[][]> {
    private static final int THRESHOLD = 100; // Threshold for matrix size to switch to sequential multiplication
    private final int[][] matrix1;
    private final int[][] matrix2;
    private final int rowStart;
    private final int rowEnd;
    private final int columnStart;
    private final int columnEnd;

    public MatrixMultiplicationTask(int[][] matrix1, int[][] matrix2,
                                    int rowStart, int rowEnd, int columnStart, int columnEnd) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.rowStart = rowStart;
        this.rowEnd = rowEnd;
        this.columnStart = columnStart;
        this.columnEnd = columnEnd;
    }

    /**
     * A description of the entire Java function.
     *
     * @return result of matrix multiplication
     */
    @Override
    protected int[][] compute() {
        int numRowsA = rowEnd - rowStart;
        int numColsB = columnEnd - columnStart;
        int[][] result = new int[numRowsA][numColsB];

        if (numRowsA <= THRESHOLD || numColsB <= THRESHOLD) {
            for (int i = rowStart; i < rowEnd; i++) {
                for (int j = columnStart; j < columnEnd; j++) {
                    for (int k = 0; k < matrix2.length; k++) {
                        result[i - rowStart][j - columnStart] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
        } else {
            int midRow = (rowStart + rowEnd) / 2;
            int midCol = (columnStart + columnEnd) / 2;

            MatrixMultiplicationTask topLeft = new MatrixMultiplicationTask(matrix1, matrix2,
                    rowStart, midRow, columnStart, midCol);
            MatrixMultiplicationTask topRight = new MatrixMultiplicationTask(matrix1, matrix2,
                    rowStart, midRow, midCol, columnEnd);
            MatrixMultiplicationTask bottomLeft = new MatrixMultiplicationTask(matrix1, matrix2,
                    midRow, rowEnd, columnStart, midCol);
            MatrixMultiplicationTask bottomRight = new MatrixMultiplicationTask(matrix1, matrix2,
                    midRow, rowEnd, midCol, columnEnd);

            topLeft.fork();
            int[][] topRightResult = topRight.compute();
            int[][] bottomLeftResult = bottomLeft.compute();
            int[][] bottomRightResult = bottomRight.compute();
            int[][] topLeftResult = topLeft.join();

            // Combine results
            combineResults(result, topRightResult, bottomLeftResult, bottomRightResult, topLeftResult);
        }

        return result;
    }

    // Helper method to combine results
    private void combineResults(int[][] result, int[][] topRightResult, int[][] bottomLeftResult,
                                int[][] bottomRightResult, int[][] topLeftResult) {
        int numRows = result.length;
        int numCols = result[0].length;
        int midRow = numRows / 2;
        int midCol = numCols / 2;

        // Copy results to the appropriate positions in the final result matrix
        for (int i = 0; i < midRow; i++) {
            System.arraycopy(topLeftResult[i], 0, result[i], 0, midCol);
            System.arraycopy(topRightResult[i], 0, result[i], midCol, numCols - midCol);
        }
        for (int i = midRow; i < numRows; i++) {
            System.arraycopy(bottomLeftResult[i - midRow], 0, result[i], 0, midCol);
            System.arraycopy(bottomRightResult[i - midRow], 0, result[i], midCol, numCols - midCol);
        }
    }
}
