/*
    The concept of scope is relevant when class, method and variable headers are called into question. Scope
    describes the visibility of variables.

    Examples of headers below:
        Full variable header:
        private static final String[] wordList;
        [accessor] [static] [final] [type] [variable name]

        Full method header:
        protected static final ArrayList<Integer> printArray()
        [accessor] [static] [final] [type] [method name]

        Full class header:
        public final class Variable extends Object implements KeyListener
        [accessor] [final] [class] [class name] [inheritance stuff]


    Accessors (access types) specify visibility of the variable, method, or class to other classes. They are one
    of three types: private, public and protected. If no access type is specified, the default is "protected".
    For APCS, the main access types you will use are public and private. Public is visible to all other classes,
    private is visible only within the current class.

    The static keyword specifies whether the variable is in the "instance" space or the "static" space. Java is
    an "object-oriented" programming language, and the topic of objects is
 */
public class Objects
{

}
