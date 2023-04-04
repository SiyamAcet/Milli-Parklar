import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MilliPark {
    public String milliParkAdi;
    public List<String> ilAdlari;
    public String ilanYili;
    public int yuzOlcumu;

    @Override
    public String toString() { // park nesnelerini yazdırma
        return "Milli Park Adı = " + milliParkAdi + '\n' +
                "Bulunduğu İl veya İller = " + ilAdlari + '\n' +
                "İlan Tarihi = " + ilanYili + '\n' +
                "Yüz Ölçümü = " + yuzOlcumu + " hektar";
    }

    public MilliPark(String milliParkAdi, List<String> ilAdlari, String ilanYili, int yuzOlcumu) {//constructor
        this.milliParkAdi = milliParkAdi;
        this.ilAdlari = ilAdlari;
        this.ilanYili = ilanYili;
        this.yuzOlcumu = yuzOlcumu;
    }

    public static void main(String[] args) {
        // buyuk ve küçük milli parkları tutmak için listeler
        List<MilliPark> kucukMPlar = new ArrayList<>();
        List<MilliPark> buyukMPlar = new ArrayList<>();
        // listeleri tutmak için array
        List dizi[] = new List[2];
        // stack, queue ve oncelikli kuyruk nesneleri
        Stack stack = new Stack(48);
        Queue queue = new Queue(48);
        OncelikliKuyruk oncelikliKuyruk = new OncelikliKuyruk(48);

        try {
            Scanner reader = new Scanner(new FileReader("milli parklar.txt"));
            // dosya okuma ile milli parkaların alınıp listeye, kuyruğa, stack'e ve öncelikli kuyruğa atılması

            while (reader.hasNextLine()) {
                String metin = reader.nextLine();
                String[] parcalanmisDizi = metin.split("  ");
                String parkAdi = parcalanmisDizi[0];
                int alan = Integer.parseInt(parcalanmisDizi[1]);
                String tarih = parcalanmisDizi[2];

                List<String> ilAdlari = new ArrayList<>();

                for (int i = 0; i < parcalanmisDizi.length - 3; ++i) {
                    ilAdlari.add(i, parcalanmisDizi[i + 3]);
                }

                MilliPark milliPark = new MilliPark(parkAdi, ilAdlari, tarih, alan);

                if (alan > 15000) {
                    buyukMPlar.add(milliPark);
                } else {
                    kucukMPlar.add(milliPark);
                }
                stack.push(milliPark);
                queue.insert(milliPark);
                oncelikliKuyruk.insert(milliPark);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı...");
        }


        for (int i = 0; i < 2; ++i) {
            if (i == 0) {
                dizi[i] = kucukMPlar;
            } else {
                dizi[i] = buyukMPlar;
            }
        }
        // istenilen değerlerin yazdırılması
        for (int i = 0; i < kucukMPlar.size(); ++i) {
            System.out.println(kucukMPlar.get(i));
            System.out.println();
        }

        for (int i = 0; i < buyukMPlar.size(); ++i) {
            System.out.println(buyukMPlar.get(i));
            System.out.println();
        }
        int kucukMPlarToplamAlan = 0;
        for (int i = 0; i < kucukMPlar.size(); ++i) {
            kucukMPlarToplamAlan += kucukMPlar.get(i).yuzOlcumu;
        }
        System.out.println("Küçük Milli parkların toplan alanı: " + kucukMPlarToplamAlan);
        int buyukMPlarToplamAlan = 0;
        for (int i = 0; i < buyukMPlar.size(); ++i) {
            buyukMPlarToplamAlan += buyukMPlar.get(i).yuzOlcumu;
        }
        System.out.println("Buyuk milli parkların toplam alanı: " + buyukMPlarToplamAlan);

        System.out.println();

        System.out.println("************************************************************************");
        System.out.println("Stack'e atılan nesnelerin pop metodu ile silinmesi ve ekrana yazılması..");
        System.out.println();
        for (int i = 0; i < stack.maxSize; ++i) {
            System.out.println(stack.pop());
        }
        System.out.println();
        System.out.println("******************************************************************************");
        System.out.println("Kuyruğa atılan nesnelerin remove metodu ile silinmesi ve ekrana yazdırılması..");
        System.out.println();
        for (int i = 0; i < queue.maxSize; ++i) {
            System.out.println(queue.remove());
        }
        System.out.println();
        System.out.println("*******************************************************************************");
        System.out.println("Kuyruktan Öncelikl olan elemanları silme metodu");
        System.out.println();
        for (int i = 0; i < oncelikliKuyruk.maxSize; ++i) {
            System.out.println(oncelikliKuyruk.oncelikliSil());
        }

    }

}
