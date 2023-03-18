package fsm.exercise.finalExam2017;

public class algorithm {
    public static void main(String[] args) {
//        int[][] number = {{1,3,5,7}
//                        ,{0,0,6,6},
//                        {0,2,1,3},
//                        {5,3,1,1}};
//        int[] newArray = new int[20];
//        int max = 0;
//        int n = 0;
//        for(int i = 0; i < number.length; i++){
//                max *= 10;
//                max += number[0][i];
//            for(int k = 0; k < number[i].length; k++){
//                n *= 10;
//                n += number[0][k];
//            }
//        }
//            System.out.printf("the number is %d\n ", max);
//
//        int max = 0;
//        for(int j = 0; j < newArray.length; j++){
//            max = (newArray[0] > newArray[j]) ?
//                    newArray[0] : newArray[j];
//        }
//        System.out.printf("the big number is %d\n ", max);
//
//
//        int[] nums = {1, 0, 2, 2, 1};
//
//        int retval = 0;
//
//        for (int digit : nums)
//        {
//            retval *= 10;
//            retval += digit;
//        }
//
//        System.out.println("Return value is: " + retval);

        int[][] matrix = {
                {1, 3, 5, 7},
                {0, 0, 6, 6},
                {0, 2, 1, 3},
                {5, 3, 1, 1},
                {1, 0, 1, 1}
        };

// Concatenate digits in each row to form a number
        int[] numbers = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]);
            }
            numbers[i] = Integer.parseInt(sb.toString());
        }

// Find the largest number
        int largest = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }

        System.out.println("The largest number is: " + largest);
    }
}
