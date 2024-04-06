package nasm.arrays;

public class IsSorted {
    /*
    3.2.1 Check if Array is Sorted: Implement a function that checks whether an array is sorted
    in ascending order and returns a boolean value (0 for false, 1 for true)
     */

    public boolean isSorted(int [] arr){
        Boolean isSorted=false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<arr[i+1]){
                isSorted=true;
            }else{
                isSorted=false;
            }
        }
        return isSorted;
    }

    //Assembly code
    /*
 section  .text
 global isSorted


 isSorted:
 xor rax,rax

 test rsi,rsi
 jz.end

 mov eax, [rdi]   ;first element of an array
 mov ebx ,[eax+4]
 .loop_start
 cmp rsi,ebx
 cmp eax,ebx
 jl eax+4
 jge .loop_end

 .end res
*/
}
