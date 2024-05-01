package coding.homework;

public class Matrix {

   /*
   Implement Basic Matrix multiplication
    */

    public int[][] multiplication(int[][] matrixA, int[][] matrixB) {
        int rowA = matrixA.length;
        int colB = matrixB.length;
        int[][] result = new int[rowA][colB];

        for (int k = 0; k < result.length; k++) {
            for (int i = 0; i < rowA; i++) {
                for (int j = 0; j < colB; j++) {
                    result[k][i] += matrixA[i][j] * matrixB[j][i];
                }
            }
        }

        return result;
    }

    
}
