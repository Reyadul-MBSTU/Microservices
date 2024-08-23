package problemSolving;

public class RemoveDuplicates {

    public int getUniqueElement(int[] arr)
    {
        int index = 1;
        for(int i=0; i<arr.length-1; i++)
        {
            if(arr[i]<arr[i+1])
            {
                arr[index++] = arr[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,3,4,4,4,4,5,5};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int result = removeDuplicates.getUniqueElement(arr);
        System.out.println(result);
    }
}
