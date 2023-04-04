public class Stack {
    public int maxSize;
    public MilliPark[] stackArray;
    public int top;

    public Stack(int maxSize) { // constructor
        this.maxSize = maxSize;
        stackArray = new MilliPark[maxSize];
        top = -1;
    }

    public void push(MilliPark m) { // push metodu
        stackArray[++top] = m;
    }

    public Object pop() { // pop metodu
        return stackArray[top--];
    }

    public Object peek() { // peek metodu
        return stackArray[top];
    }

    public boolean isEmpty() { // isEmpty metodu
        return (top == -1);
    }

    public boolean isFull() { // isFull metodu
        return (top == maxSize - 1);
    }

}
