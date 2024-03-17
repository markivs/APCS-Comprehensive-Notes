import java.util.ArrayList;

/*
    Notes and exercises regarding variable types and properties in Java,
 */
public class Variables
{
    /*
            Below is a comprehensive list of all possible "primitive" type variables in Java. The important ones to note
            for the AP exam are int, double, boolean and char.

            The number primitive types (byte, short, int, long, float, double) are divided into integer and float types.

                These types are further defined by the number of "bits" of space they take in memory, from 8 bits in the
                case of "byte" and 64 bits in the case of "long". Remember that a bit is a single binary 1 or 0.
                Following the logic of binary numbers, the range of the primitive type values are listed next to the
                variable examples in the form: [lower limit, upper limit].

                The amount of space a variable takes up matters when you start making large arrays, arraylists, etc.
                where the difference between a 32-bit "int" and an 8-bit "byte" (4 times less space!) is a significant
                improvement if you expect numbers within the range [-128, 127].
     */

    // non-decimal (integer) primitive number types
    private static byte int8; // [-128, 127]
    private static short int16; // [-32768, 32767]
    private static int int32; // [-2^31, 2^31 - 1] = [-2147483648, 2147483647]
    private static long int64; // [-2^63, 2^64 - 1] = [-big number, big number]

    // decimal (float) primitive number types
    private static float dec32;
    private static double dec64;

    // other primitive types
    private static boolean flag;
    private static char character;

    /*
           All other (non-primitive) variables in Java are known as "Objects". This may sound familiar as Java is an
           object-oriented programming language, and defining objects lies at the heart of working with the language.
    */
    private static String word;
    private static int[] numbers;
    private static ArrayList<String> wordList;
    private static Variables thisObject;


    public static void main(String[] args)
    {
        printDefaultValues();
    }
    public static void printDefaultValues()
    {
        System.out.println("byte " + int8);
        System.out.println("short " + int16);
        System.out.println("int " + int32);
        System.out.println("long " + int64);
        System.out.println("float " + dec32);
        System.out.println("double " + dec64);
        System.out.println("boolean " + flag);
        System.out.println("char " + character + " <-- empty char, expressed as '' ");

        System.out.println("String " + word);
        System.out.println("int[] " + numbers);
        System.out.println("wordList " + wordList);
    }

    public static void scope()
    {

    }
    public static void instanceVSStaticSpace()
    {

    }
    public static void
}
