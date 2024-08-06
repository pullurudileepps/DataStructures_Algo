package SlidingWindow;

public class SpiralOrderMatrix {

    public static void main(String[] args) {
        int n = 5;
        int[][] ints = generateMatrix(n);
        printMatrix(ints);
    }
    public static int[][] generateMatrix(int A) {
        int count = 1;
        int left=0;int top=0;
        int n = A;
        int right = n-1;int down = n-1;
        int [][] ans = new int[n][n];
        while(left <= right){
            for(int i=left;i<=right;i++){
                ans[top][i] = count++;
            }
            top++;
            for(int i=top;i<=down;i++){
                ans[i][right] = count++;
            }
            right--;
            for(int i=right;i>=left;i--){
                ans[down][i] = count++;
            }
            down--;
            for(int i=down;i>=top;i--){
                ans[i][left] = count++;
            }
            left++;
        }
        return ans;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}
