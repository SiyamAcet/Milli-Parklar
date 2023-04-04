import java.util.ArrayList;
import java.util.List;

public class OncelikliKuyruk {
    public int maxSize;
    public List<MilliPark> oncelikliKuyruk;
    public int front;
    public int rear;
    public int nItems;

    public OncelikliKuyruk(int maxSize) { //constructor
        this.maxSize = maxSize;
        oncelikliKuyruk = new ArrayList<>(maxSize);
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(MilliPark m) { // insert metodu
        if (rear == maxSize - 1)
            rear = -1;
        oncelikliKuyruk.add(++rear, m);
        nItems++;
    }

    public MilliPark oncelikliSil() { // oncelikli silme metodu
        int min = oncelikliKuyruk.get(0).yuzOlcumu;
        int indeks = 0;

        for (int i = 0; i < oncelikliKuyruk.size(); ++i) {
            if (min > oncelikliKuyruk.get(i).yuzOlcumu) {
                min = oncelikliKuyruk.get(i).yuzOlcumu;
                indeks = i;
            }
        }
        MilliPark temp = oncelikliKuyruk.get(indeks);
        oncelikliKuyruk.remove(temp);
        return temp;
    }

    public MilliPark peekFront() { // peek metodu
        return oncelikliKuyruk.get(front);
    }

    public boolean isEmpty() { // isEmpty metodu
        return (nItems == 0);
    }


}
