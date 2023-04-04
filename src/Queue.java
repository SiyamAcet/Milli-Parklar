public class Queue {
    public int maxSize;
    public MilliPark[] queArray;
    public int front;
    public int rear;
    public int nItems;

    public Queue(int maxSize) { // constructor
        this.maxSize = maxSize;
        queArray = new MilliPark[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    public void insert(MilliPark m) { //insert metodu
        if (rear == maxSize - 1)
            rear = -1;
        queArray[++rear] = m;
        nItems++;
    }

    public MilliPark remove() { // remove metodu
        MilliPark temp = queArray[front++];
        if (front == maxSize)
            front = 0;
        nItems--;
        return temp;
    }

    public MilliPark peekFront() { // peek metodu
        return queArray[front];
    }

    public boolean isEmpty() { // isEmpty metodu
        return (nItems == 0);
    }

    public boolean isFull() { // isFull metodu
        return (nItems == maxSize);
    }

    public int size() { // size metodu
        return nItems;
    }


}
