package Problems;

import java.util.Stack;

public class ReversePolish {
	public int evalRPN(String[] tokens) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Stack<Integer> stack =  new Stack<Integer>();
        for(int i=0;i<tokens.length; i++){
        	if(isInteger(tokens[i]))
        		stack.push(Integer.parseInt(tokens[i]));
        	else if(isOperator(tokens[i])){
        		int num1 = stack.pop();
        		int num2 = stack.pop();
        		stack.push(calculate(num1, num2, tokens[i]));
        	}
        }
        
        return stack.pop();
    }
	
	private boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}
	
	private boolean isOperator(String s){
		if(s.length() == 1){
			if(s.equals("*") || s.equals("/") || s.equals("-") || s.equals("+"))
				return true;
		}
		
		return false;
	}
	
	private int calculate(int num1, int num2, String operator){
		if(operator.equals("*"))
			return num1*num2;
		else if(operator.equals("-"))
			return num2 - num1;
		else if(operator.equals("/"))
			return num2 / num1;
		else if(operator.equals("+"))
			return num1 + num2;
		else
			return 0;
	}
	
	
}
