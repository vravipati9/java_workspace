import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


public class StackEx {

	 //stores the parentheses
	 final Deque<Character> paranthesesStack = new ArrayDeque<Character>();
	 
	 public boolean isBalanced(String s) {
	 
	  for (int i = 0; i < s.length(); i++) {
	 
	   if (s.charAt(i) == PARENTHESIS.LP.getSymbol() || 
	       s.charAt(i) == PARENTHESIS.LB.getSymbol() ||
	       s.charAt(i) == PARENTHESIS.LSB.getSymbol())
	     
	     paranthesesStack.push(s.charAt(i));      // auto boxing takes place
	                                              // push the opening parentheses
	 
	   //for each RHS parenthesis check if there is a matching LHS Parenthesis
	   //if the stack is empty or does not have a matching LHS parenthesis then not balanced.
	   else if (s.charAt(i) == PARENTHESIS.RP.getSymbol()){  
	    if (paranthesesStack.isEmpty() || paranthesesStack.pop() != PARENTHESIS.LP.getSymbol())
	     return false;
	   }
	 
	   else if (s.charAt(i) == PARENTHESIS.RB.getSymbol() ) {
	    if (paranthesesStack.isEmpty() || paranthesesStack.pop() !=PARENTHESIS.LB.getSymbol() )
	     return false;
	   }
	 
	   else if (s.charAt(i) == PARENTHESIS.RSB.getSymbol()) {
	    if (paranthesesStack.isEmpty() || paranthesesStack.pop() != PARENTHESIS.LSB.getSymbol())
	     return false;
	   }
	 
	  }
	   
	  return paranthesesStack.isEmpty(); //if the stack is empty, then all matched well, otherwise not matched.
	 }

}
enum PARENTHESIS {
	 
	 LP('('), RP(')'), LB('{'), RB('}'), LSB('['), RSB(']');
	 
	 char symbol;
	 
	 PARENTHESIS(Character symbol) {
	  this.symbol = symbol;
	 }
	 
	 char getSymbol() {
	  return this.symbol;
	 }
	} 
