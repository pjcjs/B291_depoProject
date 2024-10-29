import java.util.*;

public class DepoManager {
    private Map<Integer, Urun> urunler;
    private Scanner scanner;

    public DepoManager() {
        this.urunler = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void calistir() {
        while (true) {
            System.out.println("\n=== DEPO YÖNETİM SİSTEMİ ===");
            System.out.println("1- Ürün Tanımla");
            System.out.println("2- Ürün Listele");
            System.out.println("3- Ürün Girişi");
            System.out.println("4- Ürünü Rafa Koy");
            System.out.println("5- Ürün Çıkışı");
            System.out.println("6- Çıkış");

            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    urunTanimla();
                    break;
                case 2:
                    urunListele();
                    break;
                case 3:
                    urunGirisi();
                    break;
                case 4:
                    urunuRafaKoy();
                    break;
                case 5:
                    urunCikisi();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    private void urunTanimla() {
        System.out.print("Ürün ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ürün İsmi: ");
        String isim = scanner.nextLine();
        System.out.print("Üretici: ");
        String uretici = scanner.nextLine();
        System.out.print("Birim: ");
        String birim = scanner.nextLine();

        urunler.put(id, new Urun(id, isim, uretici, birim));
        System.out.println("Ürün başarıyla tanımlandı.");
    }

    private void urunListele() {
        System.out.println("\nid      ismi    ureticisi   miktari     birimi      raf");
        System.out.println("---------------------------------------------------------------");
        for (Urun urun : urunler.values()) {
            System.out.printf("%-8d%-9s%-12s%-12d%-12s%s%n",
                    urun.getId(), urun.getUrunIsmi(), urun.getUretici(),
                    urun.getMiktar(), urun.getBirim(), urun.getRaf());
        }
    }

    private void urunGirisi() {
        System.out.print("Ürün ID: ");
        int id = scanner.nextInt();
        System.out.print("Giriş miktarı: ");
        int miktar = scanner.nextInt();

        Urun urun = urunler.get(id);
        if (urun != null) {
            urun.setMiktar(urun.getMiktar() + miktar);
            System.out.println("Ürün girişi başarıyla yapıldı.");
        } else {
            System.out.println("Ürün bulunamadı!");
        }
    }

    private void urunuRafaKoy() {
        System.out.print("Ürün ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Raf: ");
        String raf = scanner.nextLine();

        Urun urun = urunler.get(id);
        if (urun != null) {
            urun.setRaf(raf);
            System.out.println("Ürün rafa yerleştirildi.");
        } else {
            System.out.println("Ürün bulunamadı!");
        }
    }

    private void urunCikisi() {
        System.out.print("Ürün ID: ");
        int id = scanner.nextInt();
        System.out.print("Çıkış miktarı: ");
        int miktar = scanner.nextInt();

        Urun urun = urunler.get(id);
        if (urun != null) {
            if (urun.getMiktar() >= miktar) {
                urun.setMiktar(urun.getMiktar() - miktar);
                System.out.println("Ürün çıkışı başarıyla yapıldı.");
            } else {
                System.out.println("Yetersiz stok!");
            }
        } else {
            System.out.println("Ürün bulunamadı!");
        }
    }
}
