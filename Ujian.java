import java.util.Scanner;

//class node untuk doubly LinkedList
class Node{
    String data;
    Node next;
    Node prev;
    static int kunjungan = 0;
    
    int nomorKunjungan;

    //konstruktor
    public Node(String data){
        this.data = data;
        this.next = null;
        this.prev = null;
        kunjungan += 1;

        this.nomorKunjungan = kunjungan;
    }
}

class RiwayatKunjungan{
    
    //deklarasi Node Head dan Tail
    private Node head;
    private Node tail;
    // mendeklarasi varible current untuk menentukan lokasi terkini
    private Node current;


    //method untuk menambahkan kunjungan diakhir/ terbaru
     public void tambahKunjungan(String catatan){
        //deklarasi newNode
        Node newNode = new Node(catatan);
        

        //mengecek apakah head null
        if(head == null){
            head = newNode;
            tail = newNode; // buat simpan node ke tail juga, jadi ketika belum ada node sebelumnya makan head dan tail sama sama mereferensi newNode
            current = tail; // posisi current sekarang di tail
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            current = tail; // posisi current sekarang di tail
        }
    }

    //method untuk mengubah posisi ke node sebelumnya
    public void sebelumnya(){
        if(head == null || tail == null){
            return;
        }
        else if(current.prev == null){
            System.out.println("Tidak Ada Riwayat Kunjungan Sebelumnya!!");
        }
        else{
            current = current.prev;
        }
    }

    //method untuk mengubah posisi ke node sebelumnya
    public void berikutnya(){
        if(head == null || tail == null){
            return;
        }
        else if(current.next == null){
            System.out.println("Tidak Ada Riwayat Kunjungan terbaru!!");
        }
        else{
            current = current.next;
        }
    }

    //method untuk menampilkan data node posisi saat ini
    public void tampilkanSaatIni(){
        if(head == null || tail == null){
            System.out.println("Tidak ada Riwayat kunjungan");
            System.out.println("Silahkan Tambah Riwayat !!");
        }
        else{
            System.out.println("Pasien bernama "+current.data + " dengan nomor kunjugan " +current.nomorKunjungan);
        }
    }



}






class Ujian{
    public static void main(String[] args) {
        RiwayatKunjungan riwayat = new RiwayatKunjungan();
        
        System.out.print("=======================");
        System.out.print("Sistem Riwayat Kujungan Rumah Sakit A");
        System.out.print("=======================");
        System.out.println("");
        System.out.println("");

        boolean ulang = true;

        // untuk menyimpan nama pasien yang diinput oleh user
        String namaPasien;
        
        //untuk menyimpan pilihan menu yang diinput oleh user
        int menu ;

        //membuat instance dari class Scanner untuk menerima input dari user
        Scanner scanner = new Scanner(System.in);
        
        while(ulang){

            System.out.println("MENU:");
            System.out.println("1. Tambah Riwayat Kunjungan.");
            System.out.println("2. Pindah Ke Riwayat Sebelumnya.");
            System.out.println("3. Pindah ke Riwayat Berikutnya.");
            System.out.println("4. Keluar");

            System.out.println();
            System.out.println();


            //membaca inputan menu sebagai string lalu mengonversikannya menjadi integer
            System.out.print("Silahkan Pilih Menu : ");
            menu = Integer.parseInt(scanner.nextLine());

            switch (menu) {
                case 1 :
                    System.out.print("Masukan Nama Pasien : ");
                    namaPasien = scanner.nextLine();
                    riwayat.tambahKunjungan(namaPasien);
                    break;
                case 2:
                    riwayat.sebelumnya();
                    riwayat.tampilkanSaatIni();
                    break;
                case 3:
                    riwayat.berikutnya();
                    riwayat.tampilkanSaatIni();
                    break;
                case 4:
                    System.out.println("Terima kasih Sampai Jumpa :)");
                    ulang = false;
                    break;
                default:
                    System.out.println("Silahkan Pilih Menu yang Tersedia.");
            }
        }
        
    }
}