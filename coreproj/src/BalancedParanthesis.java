import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public final class BalancedParanthesis {

    private static final Map<Character, Character> allowedBrackets = new HashMap<Character, Character>();
    static {
        allowedBrackets.put('[', ']');
        allowedBrackets.put('{', '}');
        allowedBrackets.put('(', ')');
    }  

    private BalancedParanthesis() {};

    /**
     * Returns true is parenthesis match open and close.
     * Understands [], {}, () as the brackets
     * It is clients responsibility to include only valid paranthesis as input.
     * A false could indicate that either parenthesis did not match or input including chars other than valid paranthesis
     * 
     * @param str   the input brackets
     * @return      true if paranthesis match.
     */
    public static boolean isBalanced(String value) {
        if (value.length() == 0) {
            throw new IllegalArgumentException("String is Blank");
        }
        
        if ((value.length() % 2) != 0) {
            return false;
        }

        final Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < value.length(); i++) {
            if (allowedBrackets.containsKey(value.charAt(i))) {
                stack.push(value.charAt(i));
            } else if (stack.empty() || (value.charAt(i) != allowedBrackets.get(stack.pop()))) {
                return false;
            } 
        }
        return true;
    } 

    public static void main(String[] args) {
//        System.out.println(isBalanced("{}([])"));
//        System.out.println(isBalanced("([}])"));
//        System.out.println(isBalanced("([])"));
//        System.out.println(isBalanced("()[]{}[][]"));
        System.out.println(isBalanced("{[}]"));
    }

}