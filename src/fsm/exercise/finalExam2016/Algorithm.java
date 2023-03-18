package fsm.exercise.finalExam2016;

public class Algorithm {
    public static void main(String[] args) {
        int[][] numbers = {{1,1,1,2,4},
                            {4,4,4,4,4},
                            {4,4,5,5,6},
                            {7,7,7,9,9},
                            {9,9,9,9,9}};
        int[] newArray = new int[numbers.length*2];
        int total = 0;
        for(int i = 0; i < numbers.length; i++){
            total = 0;
            for(int j = 0; j < numbers[i].length; j++){
               total += numbers[i][j];
                newArray[numbers[i][j]]++;
            }
            System.out.printf("the sum of %d is %d\n",(i+1),total);
        }

        for(int k = 0; k < newArray.length; k++){
            System.out.printf("the num %d is repeated %d \n",k,newArray[k]);
        }
    }
}
