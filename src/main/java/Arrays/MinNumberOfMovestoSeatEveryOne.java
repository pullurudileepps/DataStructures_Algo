package Arrays;
import java.util.*;
/*2037. Minimum Number of Moves to Seat Everyone */
public class MinNumberOfMovestoSeatEveryOne {
    //T.C: NLogn + NLogn + N => 3NLogn => NLogn
    //S.C : O(1)
    public static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0;
        for(int i = 0;i<seats.length;i++){
            ans += Math.abs(seats[i] - students[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] seats = {3,1,5};
        int[] students = {2,7,4};
        int output = minMovesToSeat(seats, students);
        System.out.println(output);
    }
}
