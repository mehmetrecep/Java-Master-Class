package fsm.exercise.finalExam2017;

public class algorithmV2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {0, 0, 6, 6},
                {0, 2, 1, 3},
                {5, 3, 1, 1},
                {1, 0, 1, 1}
        };
        int[] number = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++){
                stringBuilder.append(matrix[i][j]);
            }
            number[i] = Integer.parseInt(stringBuilder.toString());
        }
        for (int k = 0; k < number.length; k++){
            System.out.printf("%d\n",number[k]);
        }



}
}
