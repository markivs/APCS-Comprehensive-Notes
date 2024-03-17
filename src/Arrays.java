public class Arrays {
    /*
        "Data structures" are a programming concept that concerns storing and organizing information.

        Some popular data structures are lists, stacks, trees -- and the topic of this class, Arrays. The most efficient
        way to learn a new data structure is by discussing its properties first, then mentally assessing why one would
        be useful over another. Here are some such properties of arrays.

        1. Arrays have an unchangeable size, set once during initialization
        2. Arrays must contain values only of the same data type.

     */
    public static void main(String[] args) {
        int[] numbers = new int[4];
        int[] values = {1, 3, 5, 7, 9};
        numbers = new int[5];

        System.out.println(values[values.length-1]);
        System.out.println(values.length);

        String result = arrayToString(oddNumbers(10));
        System.out.println(result);
    }

    // public/private
    // static
    // return type
    /*
        oddNumbers
        @param size
     */
    public static int[] oddNumbers(int size) {

        // i < odds.length  <--> i <= odds.length-1
        int[] odds = new int[size];
        int currentOdd = 1;

        for(int index = 0; index < odds.length; index++) {
            odds[index] = currentOdd;
            // odds[index] = 2*index + 1;
            currentOdd+=2;
        }
        return odds;
    }

    public static String arrayToString(int[] array) {
        String returnString = "";
        for(int index = 0; index <= array.length-1; index++) {
            returnString += array[index] + ", ";
        }
        return returnString;
    }

}