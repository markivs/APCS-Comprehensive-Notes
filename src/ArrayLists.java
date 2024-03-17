// note that ArrayLists require an import: they are an object implemented in the "java.util" package
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayLists
{
    /*
        ArrayLists are a special structure in Java that have a similar functionality to arrays. They can store multiple
        values of the same type, in a way that is easy to keep track of and traverse.

        They are special, however, in that you don't have an unchangeable size specification at initialization: you can
        keep adding to an ArrayList, and it will make room for the new objects. Much more convenient than arrays!

        Some examples of ArrayList declarations are below.
     */
    private ArrayList<Integer> intList;
    private ArrayList<String> stringList;
    private ArrayList<int[]> arrayArrayList;
    private ArrayList<ArrayList<String>> arrayListArrayList;
    private ArrayList<ArrayLists> selfReferentialList;

    /*
        There are a few things to note in the declaration of an ArrayList:
            1. ArrayLists are data types that have the first letter capitalized - they are non-primitive types (objects).
               The ArrayList object additionally needs to be imported from tbe java.util package (unlike String,
               another non-primitive type).

            2. ArrayLists have an interesting angle bracket notation ("ArrayList<T>") required when specifying data type.
                Behind the scenes, this lets any class take in what's called a "Generic Type" that lets classes from
                outside a given package view a class from within the package. You can't include a primitive type inside
                the Angle braces (more in #3).
                    Think of it as the equivalent of a method parameter (e.g. String.equals(word)) where the parameter
                    is an object, but for a class the parameter is a data type.

                An example of what that looks like within the ArrayList implementation is below, in the GenericTest
                class.

            3. ArrayLists can only take in non-primitive types as an argument during declaration.
               Notice that to make an ArrayList of numbers, you have to use ArrayList<Integer> instead of
               ArrayList<int>.

               This is a property of the "Generic Type" notation, but more generally it's just because
               every class has primitive types already "within scope", so passing in a primitive type is redundant.
      */

    public ArrayLists()
    {
        /*
            When initializing an ArrayList, don't be intimidated by the new angle brackets. Just like every other
            non-primitive variable initialization, it is just a constructor call.

            It is helpful  to inwardly group the phrases "ArrayList" and "<Type>" so that the data type
            is "ArrayList<Type>", an "ArrayList of Types". This is the same principle as considering "Type[]" as a single
            data type, a "Type array".

            ArrayList initialization structure: new ArrayList<Type>();
            Array initialization structure: new Type[size];
            Any object initialization structure: new Object();

            And because ArrayList has a constructor, there are a couple of parameters you can include on initialization:
            new ArrayList<>(5); // makes ArrayList of starting size 5. Note that this always contains nulls.
            new ArrayList<>(Arrays.asList(arrayOfObjects)); // Uses static Arrays method to convert an Array into
            a "Collection" object, the other constructor implemented in ArrayList.
         */
        Integer[] toIntList = {1, 2, 3, 4, 5};
        intList = new ArrayList<>(Arrays.asList(toIntList));
        System.out.println("Made intList with initial values:");
        printArrayList(intList);
        stringList = new ArrayList<String>(5);
        System.out.println("Made stringList with initial values:");
        printArrayList(stringList);
        arrayArrayList = new ArrayList<int[]>();
        arrayListArrayList = new ArrayList<ArrayList<String>>();
        selfReferentialList = new ArrayList<ArrayLists>();
    }

    /*
        To use an ArrayList the same way we would use an array, we need to establish the procedures for declaration,
        initialization, population and manipulation of these structures. As we've already covered the first two, we're
        left with population and manipulation.

        To populate an ArrayList, use the add() method on an instance of ArrayList. For example:
            ArrayList<String> wordList = new ArrayList<String>();
            intList.add("first entry");

     */

    // fill an ArrayList with values
    public void populateArrayList()
    {
        int size = 5;
        for(int i = 0; i < size; i++) // fill with ascending numbers
        {
            stringList.add("word number " + i);
        }
        printArrayList(stringList);
        stringList.add(3, "word number 5"); // add (insert) entry at index 3
        printArrayList(stringList);
    }
    public static void printArrayList(ArrayList list)
    {
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i)==null)
            {
                System.out.print("null ");
            }
            else
            {
                System.out.print(list.get(i) + " ");
            }
        }
        System.out.println();
    }

    public static void print2dArrayList(ArrayList<ArrayList<Object>> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            for(int j = 0; j < list.get(i).size(); j++)
            {
                if(list.get(i).get(j)==null)
                {
                    System.out.print("null ");
                }
                else
                {
                    System.out.print(list.get(i).get(j) + " ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        ArrayLists currentClass = new ArrayLists();
        currentClass.populateArrayList();

        sortingSearching();
    }
    public static void sortingSearching()
    {
        ArrayList<Integer> toSearch = new ArrayList<>();
        int size = 10;
        for(int i = 0; i < size; i++)
        {
            toSearch.add((int)(Math.random()*size));
        }
        long startTime = System.currentTimeMillis();
        System.out.println(SortingSearching.sequentialSearch(15, toSearch));
        System.out.println("sequentialSearch took " + (System.currentTimeMillis()-startTime) + " ms");

        startTime = System.currentTimeMillis();
        System.out.println(SortingSearching.binarySearchIter(15, toSearch));
        System.out.println("binarySearch took " + (System.currentTimeMillis()-startTime) +" ms");

        startTime = System.currentTimeMillis();
        printArrayList(SortingSearching.selectionSort(toSearch));
        System.out.println("selectionSort took " + (System.currentTimeMillis()-startTime) +" ms");

        startTime = System.currentTimeMillis();
        printArrayList(SortingSearching.mergeSortIter(toSearch));
        System.out.println("mergeSort took " + (System.currentTimeMillis()-startTime) +" ms");
    }
}




/*
    A class to demonstrate an example of angle bracket notation. Angle brackets can be used in any class header to
    define a "generic" type which can then be used as a placeholder for an object type within the class.
 */
class GenericTest<Type>
{
    /*
        Notice how the "Type" data type for object can be an arbitrary name. Placeholders like this are practical in the
        case of ArrayList, where you want to take in arbitrary data type and let users of your class do useful things on
        "generic" types.
     */
    Type object;
    GenericTest(Type object)
    {
        this.object = object;
    }
    public Type getObject()
    {
        return object;
    }
    public static <T> boolean isEqual(GenericTest<T> g1, GenericTest<T> g2){
        return g1.getObject().equals(g2.getObject());
    }
}
class SortingSearching
{
    public static int sequentialSearch(int query, ArrayList<Integer> toSearch)
    {
        for(int i = 0; i < toSearch.size(); i++)
        {
            if(toSearch.get(i).equals(query))
            {
                return i;
            }
        }
        return -1;
    }
    public static int binarySearchIter(int query, ArrayList<Integer> toSearch)
    {
        return -1;
    }

    public static int binarySearchRecurse(int query, ArrayList<Integer> toSearch)
    {
        return -1;
    }

    public static ArrayList<Integer> selectionSort(ArrayList<Integer> toSort)
    {
        ArrayList<Integer> sorted = new ArrayList<>(toSort);
        ArrayLists.printArrayList(sorted);
        for(int i = 0; i < sorted.size(); i++)
        {
            int minIndex = 0;
            for(int j = i; j < sorted.size(); j++)
            {
                Integer current = sorted.get(j);
                if(current <= sorted.get(minIndex))
                {
                    minIndex = j;
                }
            }
            int temp = sorted.get(i);
            sorted.set(i, toSort.get(minIndex));
            sorted.set(minIndex, temp);
        }
        return sorted;
    }

    public static ArrayList<Integer> mergeSortIter(ArrayList<Integer> toSort)
    {
        return new ArrayList<>();
    }

    public static ArrayList<Integer> mergeSortRecurse(ArrayList<Integer> toSort)
    {
        return new ArrayList<>();
    }
}