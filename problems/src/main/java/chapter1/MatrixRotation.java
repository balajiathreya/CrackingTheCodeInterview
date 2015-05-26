package chapter1;

/**
 * Created by baathreya on 4/1/15.
 *
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to
 * rotate the image by 90 degrees. Can you do this in place?
 *
 * TBD: do it in place, instead of using a rotated array.
 *
 */
public class MatrixRotation {

    public static void main(String[] args) {
        MatrixRotation rotation = new MatrixRotation();
        int[][] matrix3x3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotation.printArray(matrix3x3);
        rotation.rotate(matrix3x3);
        rotation.rotateInPlace(matrix3x3, 3);
        int[][] matrix4x4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotation.printArray(matrix4x4);
        rotation.rotate(matrix4x4);
        rotation.rotateInPlace(matrix4x4, 4);
        int[][] matrix5x5 = {{10, 11, 12, 13, 14}, {15, 16, 17, 18, 19}, {20, 21, 22, 23, 24}, {25, 26, 27, 28, 29}, {30, 31, 32, 33, 34}};
        rotation.printArray(matrix5x5);
        rotation.rotate(matrix5x5);
        rotation.rotateInPlace(matrix5x5, 5);
    }

    private void rotate(int[][] matrix) {
        int[][] rotated = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < matrix.length; j++) {
                rotated[j][matrix.length - i - 1] = row[j];
            }
        }
        printArray(rotated);
    }

    private void printArray(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("==========");
    }

    private void rotateInPlace(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; ++i) {
                int offset = i - first;
                int top = matrix[first][i]; // save top
                int left = matrix[last - offset][first];
                int bottom = matrix[last][last - offset];
                int right = matrix[i][last];
                // left -> top | top is equal to left
                matrix[first][i] = matrix[last - offset][first];
                // bottom -> left | left is equal to bottom
                matrix[last - offset][first] = matrix[last][last - offset];
                // right -> bottom | bottom is equal to right
                matrix[last][last - offset] = matrix[i][last];
                // top -> right | right is equal to top
                matrix[i][last] = top; // right <- saved top
            }
        }
        printArray(matrix);
    }
}