import java.util.Stack;

class Discrete_3_Stack{

    private Stack<Double> stack = new Stack<>();
    private String dataLine;
    private double tmp;
    private double ans;

    public Discrete_3_Stack(String dataLine) {
        this.dataLine = dataLine;
    }

    public void getAns(){

        for(String chr : dataLine.split(" ")){

            switch(chr){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    tmp = stack.pop();
                    stack.push(stack.pop() - tmp);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    tmp = stack.pop();
                    stack.push(stack.pop() / tmp);
                    break;
                default :
                    stack.push(Double.parseDouble(chr));
                    break;
            }

        }

        ans = stack.peek();
        if(ans-(int)ans == 0.0) System.out.println((int)ans);
        else System.out.println(ans);
        
    } 

}