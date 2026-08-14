class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[] result = new int[rows * cols];
        int index = 0;

        for (int d = 0; d < rows + cols - 1; d++) {

            if (d % 2 == 0) {

                // Even diagonal → row decreases
                int row = Math.min(d, rows - 1);

                while (row >= 0) {

                    int col = d - row;

                    if (col >= cols) {
                        break;
                    }

                    result[index++] = mat[row][col];
                    row--;
                }

            } else {

                // Odd diagonal → row increases
                int row = Math.max(0, d - cols + 1);

                while (row < rows) {

                    int col = d - row;

                    if (col < 0) {
                        break;
                    }

                    result[index++] = mat[row][col];
                    row++;
                }
            }
        }

        return result;
    }
}