package fsm.exercise.finalExam12012023;

public class finalExamAlgorithm12012023 {
    public static void main(String[] args) {
        int[][] numbers = {{1,2,0,0,1},
                            {2,4,3,3,2},
                            {0,6,1,6,0},
                            {1,2,6,3,1},
                            {1,6,1,6,1}};
        int sumOfRightSide= 0;
        int sumOfLeftSide= 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++){
                if(i>j){
                    sumOfLeftSide += numbers[i][j];
                }else if(i<j){
                    sumOfRightSide += numbers[i][j];
                }
            }
        }
        System.out.printf("%d\n", sumOfRightSide);
        System.out.printf("%d\n", sumOfLeftSide);
    }
}
