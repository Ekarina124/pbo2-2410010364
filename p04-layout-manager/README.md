Jawaban Refleksi pda bagian G :

1.
2.
3.
4.
5.

Eksperimen
A. Praktikum 2 
    1. semua button akan mempertahankan posisinya ditengah jendela, dan kode yang berubah
    awalnya :flowPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 8));
    menjadi : flowPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 8, 8));

    2. Hanya 5 baris terbentuk karena menyesuaikan dengan column

    3.

B. Praktikum 4
    1. Tidak ada perubahan, isian tetap melebar saat jendela dilebarkan. Karena Weight X dihitung per kolom dengan mengambil nilai terbesar, dan isian lain di kolom yang sama masih 1.0, kolom isian tetap mendapat sisa lebar. Weight X baru terlihat pengaruhnya jika semua isian dalam kolom itu bernilai 0.0.

    2. Dengan North, baris form tetap menempel di bagian atas saat jendela ditinggikan. Dengan Center, formPanel ikut ditarik memenuhi tinggi panel sehingga baris-barisnya bergeser ke tengah dan muncul ruang kosong di atas dan bawah. Itulah alasan formPanel dibungkus isiPanel dan ditaruh di North.

    3. Jendela bisa dikecilkan sampai sangat kecil dan tampilan rusak. Bagian yang terpotong lebih dulu adalah isi form (alamat dan isian di bagian bawah), lalu panel tombol, dan terakhir header. Hal ini karena BorderLayout memberi North dan South ukuran yang dibutuhkan, sedangkan Center hanya mendapat sisanya. setMinimumSize mencegah hal ini dengan membatasi ukuran terkecil jendela.


C. Saran teman pada Tahap 4

Screenshot FormAnggotaPerpustakaan

Tab desain FormAnggotaPerpustakaan

Deklarasi Penggunaan AI:
