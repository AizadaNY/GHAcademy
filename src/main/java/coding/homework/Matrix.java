package coding.homework;

import java.util.Random;

public class Matrix {

   /*
   7.1 - Horizontal vs Vertical partitioning
   7.2 - Coding: Implement Basic Matrix multiplication
   7.3 - Coding: Implement Matrix multiplication with Transposing
   7.4 - Coding: Implement Tiled Matrix multiplication
   7.5 - Coding: Implement Tiled Matrix multiplication with Transposing
    */

    public static void main(String[] args) {

    }

    public void basicMultiplication(int[][] matrixA,int[][] matrixB,int[][] result){
        int rowA=matrixA.length;
        int columnB=matrixB[0].length;

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j <columnB ; j++) {
                for (int k = 0; k <columnB ; k++) {
                    result[i][j]=matrixA[i][k]*matrixB[k][j];
                }
            }
        }
    }

    public void multiplicationWithTransposing(int[][] matrixA, int[][] matrixB,int[][] result) {
        int rowA=matrixA.length;
        int columnB=matrixB[0].length;

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j <columnB ; j++) {
                for (int k = 0; k <columnB ; k++) {
                    result[i][j]=matrixA[i][k]*matrixB[j][k];
                }
            }
        }
    }

    public void TiledMultiplication(int[][] matrixA,int[][] matrixB,int[][] result,int blockSize){
        int rowA=matrixA.length;
        int columnA=matrixA[0].length;
        int columnB=matrixB[0].length;

        for (int i = 0; i <rowA ; i+=blockSize) {
            for (int j = 0; j <columnB ; j+=blockSize) {
                for (int k = 0; k <columnA ; k+=blockSize) {

                    for (int ii = 0; ii <Math.min(i+blockSize, rowA) ; ii++) {
                        for (int jj = 0; jj <Math.min(j+blockSize, columnB) ; jj++) {
                            for (int kk = 0; kk <Math.min(k+blockSize, columnA) ; kk++) {
                                result[ii][jj]=matrixA[ii][kk]*matrixB[kk][jj];
                            }
                        }
                    }
                }
            }
        }
    }

    public void TiledMultiplicationWithTransposing(int[][] matrixA,int[][] transposedB,int[][] result,int blockSize){
        int rowA=matrixA.length;
        int columnA=matrixA[0].length;
        int columnB=transposedB[0].length;

        for (int i = 0; i <rowA ; i+=blockSize) {
            for (int j = 0; j <columnB ; j+=blockSize) {
                for (int k = 0; k <columnA ; k+=blockSize) {

                    for (int ii = 0; ii <Math.min(i+blockSize, rowA) ; ii++) {
                        for (int jj = 0; jj <Math.min(j+blockSize, columnB) ; jj++) {
                            for (int kk = 0; kk <Math.min(k+blockSize, columnA) ; kk++) {
                                result[ii][jj]=matrixA[ii][kk]*transposedB[jj][kk];
                            }
                        }
                    }
                }
            }
        }
    }

    public int[][] generateMatrix(int row, int column) {
        int[][] matrix = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Random random = new Random();
                matrix[i][j] = random.nextInt(1000);

            }
        }

        return matrix;
    }

    //The transpose of a matrix is given by interchanging rows and columns.
    public int[][] transpose(int[][] matrix) {
        int temp;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        return matrix;
    }




}
