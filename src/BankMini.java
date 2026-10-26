import java.util.Scanner;

public class BankMini {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rekening rekening = new Rekening("001", "Ani", 100000);

        // jika menggunakan
        // rekening.saldo = 1000000;
        // Pesan error: error: saldo has private access in Rekening
        //Sebabnya saldo bersifat private, jadi hanya kode di dalam class Rekening
        // yang boleh menyentuhnya. Dari luar harus lewat method setor() dan tarik().

        System.out.println("============ BANK MINI ============");
        System.out.println("Rekening " + rekening.getNomor() + " a.n. " + rekening.getPemilik());

        int pilihan;
        do {
            System.out.print("Menu (1 setor, 2 tarik, 3 info, 0 keluar): ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1 -> {
                    System.out.print("Jumlah: ");
                    int jumlah = scanner.nextInt();
                    System.out.println(rekening.setor(jumlah) ? "  Berhasil" : "  Ditolak");
                }
                case 2 -> {
                    System.out.print("Jumlah: ");
                    int jumlah = scanner.nextInt();
                    System.out.println(rekening.tarik(jumlah) ? "  Berhasil" : "  Ditolak");
                }
                case 3 -> rekening.cetakInfo();
                case 0 -> { }
                default -> System.out.println("Menu tidak dikenal");
            }
        } while (pilihan != 0);

        System.out.println();
        System.out.println("=========== SALDO AKHIR ===========");
        rekening.cetakInfo();

        scanner.close();
    }
}