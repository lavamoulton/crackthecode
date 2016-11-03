/**
 * Created by Daniel on 11/3/2016.
 */
public class ZeroMatrix {
    /*
     * Implementation of an algorithm to find 0s in a matrix and convert their entire rows and columns to 0s
     */

    public static void main(String[] args) {
        int[][] testMatrix1 = new int[2][2];
        testMatrix1[0][0] = 0;
        testMatrix1[0][1] = 2;
        testMatrix1[1][0] = 2;
        testMatrix1[1][1] = 3;

        int[][] testMatrix2 = new int[3][2];
        testMatrix2[0][0] = 1;
        testMatrix2[0][1] = 2;
        testMatrix2[1][0] = 0;
        testMatrix2[1][1] = 2;
        testMatrix2[2][0] = 5;
        testMatrix2[2][1] = 5;

        printMatrix(testMatrix1);
        int[][] matrixResult = addZeros(testMatrix1);
        printMatrix(matrixResult);

        System.out.println();

        printMatrix(testMatrix2);
        matrixResult = addZeros(testMatrix2);
        printMatrix(matrixResult);
    }

    private static int[][] addZeros(int[][] testMatrix) {
        int[][] matrixResult = copyMatrix(testMatrix);

        for (int i=0; i<testMatrix.length; i++) {
            for (int j=0; j<testMatrix[0].length; j++) {
                if (testMatrix[i][j] == 0) {
                    matrixResult = rowZeros(matrixResult, j);
                    matrixResult = colZeros(matrixResult, i);
                }
            }
        }

        return matrixResult;
    }

    private static int[][] copyMatrix(int[][] testMatrix) {
        int[][] resultMatrix = new int[testMatrix.length][testMatrix[0].length];

        for (int i=0; i<testMatrix.length; i++) {
            for (int j=0; j<testMatrix[0].length; j++) {
                resultMatrix[i][j] = testMatrix[i][j];
            }
        }

        return resultMatrix;
    }

    private static int[][] rowZeros(int[][] testMatrix, int y) {
        // converts entire row in matrix to zeros
        for (int i=0; i<testMatrix.length; i++) {
            testMatrix[i][y] = 0;
        }

        return testMatrix;
    }

    private static int[][] colZeros(int[][] testMatrix, int x) {
        // converts entire column in matrix to zeros
        for (int j=0; j<testMatrix[0].length; j++) {
            testMatrix[x][j] = 0;
        }

        return testMatrix;
    }

    private static void printMatrix(int[][] testMatrix) {
        for (int i=0; i<testMatrix.length; i++) {
            for (int j=0; j<testMatrix[0].length; j++) {
                System.out.print(testMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
