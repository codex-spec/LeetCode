

public class LinkedStackTester<E> extends LinkedStack<E> {

    public static void main(String[] args) {
        Stack<Integer> stack1 = new LinkedStack<Integer>();
        stack1.push(2); 
        stack1.push(4);
        stack1.push(6); 
        stack1.push(8);
        stack1.push(10); 
        stack1.push(12);

        //this should return 12, 10, 8
        // System.out.println(stack1.pop());
        // System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        //this shoudl return false
        System.out.println(stack1.isEmpty());
        System.out.println();
        //this should return 3
        System.out.println(stack1.size());
        //this should return 6
        System.out.println(stack1.top());

        System.out.println("different implmentation however using a different data type");

        Stack<String> stack2 = new LinkedStack<String>();

        stack2.push("depression and ptsd");
        stack2.push("and i have");
        stack2.push("abdullah");
        stack2.push("my name is");

        //this shoudl print out the correct sentence
        System.out.println(stack2.pop());
        // System.out.println(stack2.pop());
        // System.out.println(stack2.pop());
        // System.out.println(stack2.pop());
        System.out.println();
        System.out.println(stack2.isEmpty());
        System.out.println(stack2.top());
        System.out.println();
        stack2.popEverythingRec(stack2.size());
        System.out.println(stack2.isEmpty());

        Stack<Integer> s3 = new LinkedStack<Integer>();
        s3.transfer(stack1);
        System.out.println(s3.top());
        System.out.println(s3.pop());
        System.out.println(s3.pop());
        System.out.println(s3.pop());
        
    }

    

}