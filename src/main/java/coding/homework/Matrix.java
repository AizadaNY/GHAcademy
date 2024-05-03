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
        int size=50;
        int[][] matrixA=new int[size][size];
        int[][] matrixB=new int[size][size];
        int[][] result = new int[size][size];

        //assign values to matrix
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j <size ; j++) {
                Random random=new Random();
                matrixA[i][j]= random.nextInt(100);
                matrixB[i][j]= random.nextInt(100);
            }
        }

        //Basic Matrix multiplication
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j]+=matrixA[j][k]*matrixB[k][j];
                }
            }
        }

        //Matrix multiplication with Transposing
        //The transpose of a matrix is given by interchanging rows and columns.
        int temp;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temp=matrixA[i][j];
                matrixA[i][j]=matrixB[j][i];
                matrixB[j][i]=temp;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j]+=matrixA[j][k]*matrixB[j][k];
                }
            }
        }

        //Tiled Matrix multiplication








    }






    public int[][] multiplicationWithTransposing(int[][] matrixA, int[][] matrixB) {
        int rowA = matrixA.length;
        int colB = matrixB.length;
        int[][] result = new int[rowA][colB];

        for (int k = 0; k < result.length; k++) {
            for (int i = 0; i < rowA; i++) {
                for (int j = 0; j < colB; j++) {
                    result[k][i] += matrixA[i][j] * matrixB[i][j];
                }
            }
        }

        return result;
    }

    
}
