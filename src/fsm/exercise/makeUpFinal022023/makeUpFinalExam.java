package fsm.exercise.makeUpFinal022023;

public class makeUpFinalExam {
    public static void main(String[] args) {
        int[][] number = {{1,2,3,5,89},
                         {2,4,6,7,3},
                        {9,0,39,20},
                        {2,2,4,6,7}};
        int[] newNumber = new int[number.length+1];
        int maxValue = 0;
        for(int i = 0; i < number.length; i++){
            maxValue = number[i][0];
            for(int j = 0; j < number[i].length; j++){
                maxValue = (number[i][j] > maxValue) ? number[i][j] : maxValue;
                newNumber[i+1] = maxValue;
            }
           // System.out.printf("Row %d : %d \n",(i+1), maxValue );
        }
        //If he wants the max value in the matrix
        int max = 0;
        for(int k = 0; k < newNumber.length; k++){
            max = (newNumber[1] > newNumber[k]) ? newNumber[1] : newNumber[k];
            System.out.printf("the max value is %d in row %d ",max,k+1);
            return;
        }
    }
    }
