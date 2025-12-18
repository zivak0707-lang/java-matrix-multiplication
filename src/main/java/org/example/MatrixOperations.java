package org.example;

public class MatrixOperations {
    
    public static void main(String[] args) {
        // Вихідні дані для демонстрації
        double[][] firstMatrix = {{2, 3}, {2, 4}};
        double[][] secondMatrix = {{0, 1}, {5, 6}};
        
        // Виконання операції множення
        double[][] productMatrix = performMultiplication(firstMatrix, secondMatrix);
        
        // Форматований вивід
        displayMatrixInfo("Перша матриця", firstMatrix);
        displayMatrixInfo("Друга матриця", secondMatrix);
        displayMatrixInfo("Результат множення", productMatrix);
    }
    
    /**
     * Метод для множення двох матриць
     * @param matrixA перша вхідна матриця
     * @param matrixB друга вхідна матриця
     * @return добуток матриць
     * @throws IllegalArgumentException якщо розміри несумісні
     */
    public static double[][] performMultiplication(double[][] matrixA, double[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;
        
        // Валідація вимірності
        if (colsA != rowsB) {
            throw new IllegalArgumentException(
                String.format("Неможливо перемножити матриці: %dx%d та %dx%d. " +
                             "Стовпці А (%d) ≠ Рядки В (%d)", 
                             rowsA, colsA, rowsB, colsB, colsA, rowsB)
            );
        }
        
        // Ініціалізація результуючої структури
        double[][] resultMatrix = new double[rowsA][colsB];
        
        // Алгоритм множення
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                double cellSum = 0.0;
                for (int k = 0; k < colsA; k++) {
                    cellSum += matrixA[i][k] * matrixB[k][j];
                }
                resultMatrix[i][j] = cellSum;
            }
        }
        
        return resultMatrix;
    }
    
    /**
     * Форматований вивід матриці з назвою
     * @param title заголовок для матриці
     * @param matrix дані для відображення
     */
    public static void displayMatrixInfo(String title, double[][] matrix) {
        System.out.println("\n" + "=".repeat(40));
        System.out.println(title + ":");
        System.out.println("=".repeat(40));
        
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("│ ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%8.2f ", matrix[i][j]);
            }
            System.out.println("│");
        }
        System.out.println("=".repeat(40));
    }
    
    /**
     * Додатковий метод: транспонування матриці
     */
    public static double[][] transpose(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] transposed = new double[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }
}