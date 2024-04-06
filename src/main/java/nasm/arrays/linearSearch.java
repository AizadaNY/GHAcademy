package nasm.arrays;

public class linearSearch {

    /*
    3.2.3 Linear Search: Write a function that performs a linear search on an array. The function
    should return the index of the first occurrence of a specified value, or -1 if the value is not
    found
     */

    public boolean search(int[] arr, int num) {
        boolean isNumberExist = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                isNumberExist = true;
            }
        }
        return isNumberExist;
    }


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
 mov ebx ,num

 .loop_start
 cmp rsi,ebx
 cmp eax,ebx
 je .loop_end


 .end res
*/
