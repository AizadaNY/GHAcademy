package coding.homework;

public class SumOfArray {

    public int getSum(int [] arr){
        int result=0;
        for (int i = 0; i < arr.length; i++) {
            result=result+arr[i];
        }

        return result;
    }
}
