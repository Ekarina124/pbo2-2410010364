# P03 — Komponen GUI

**Nama:** Siti Ekarina Septianor  
**NPM:** 2410010364  
**Kelas:** 5C REG BJM

## 1. Screenshot Form Pemesanan Tiket Travel


![Form Tiket Travel Tema Terang](Screenshot-dan-jawaban/SS%20FormTiketTravel%20tema%20terang.png)

![Form Tiket Travel Tema Gelap](Screenshot-dan-jawaban/SS%20FormTiketTravel%20tema%20gelap.png)

![Tab Design Form Tiket Travel](Screenshot-dan-jawaban/SS%20Tab%20Design.png)

## 3. Jawaban Refleksi Bagian G

1. Top-level container adalah jendela utama yang memiliki bingkai dan judul, contohnya JFrame dan JDialog. Intermediate container adalah wadah untuk mengelompokkan komponen, contohnya JPanel, JScrollPane, dan JTabbedPane. Sedangkan atomic component adalah komponen yang berinteraksi langsung dengan pengguna, contohnya JLabel, JTextField, dan JButton.

2. Karena buttonGroup membuat beberapa radio button dalam satu grup hanya bisa dipilih salah satu, jadi tidak bisa aktif secara bersamaan.

3. JComboBox cocok digunakan jika pilihan yang tersedia cukup banyak sehingga lebih praktis ditampilkan dalam bentuk dropdown. Sedangkan JRadioButton cocok jika pilihannya sedikit dan terbatas sehingga semua pilihan bisa langsung terlihat.

4. Karena initComponents() merupakan kode yang dibuat otomatis oleh NetBeans dari pengaturan pada tab Design. Jika diedit langsung, perubahan tersebut bisa tertimpa saat NetBeans membuat ulang kode. Kode tambahan sebaiknya ditulis di luar bagian generated code, misalnya setelah initComponents() atau pada method sendiri.

5. FlatLightLaf.setup() dipanggil sebelum form dibuat agar saat JFrame dibuat, tampilannya sudah menggunakan tema FlatLaf dan tidak sempat menggunakan tampilan bawaan terlebih dahulu.
