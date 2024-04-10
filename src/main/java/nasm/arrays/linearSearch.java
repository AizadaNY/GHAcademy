package nasm.arrays;

public class linearSearch {

    /*
    3.2.3 Linear Search: Write a function that performs a linear search on an array. The function
    should return the index of the first occurrence of a specified value, or -1 if the value is not
    found
     */

    public int search(int[] arr, int num) {
        int index=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                index=i;
            }else{
                index=-1;
            }
        }
        return index;
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

//how to return rsult
//how to get number