# Tugas 7 - Tabel dan Menu (Aplikasi Daftar Kontak)

|                 |                                                     |
| --------------- | --------------------------------------------------- |
| **Mata Kuliah** | Pemrograman Berbasis Objek 2 (TIF1508)              |
| **Pertemuan**   | 7 - Tabel, Menu, dan Mini Proyek                    |
| **Nama**        | Siti Ekarina Septianor                              |
| **NIM**         | 2410010364                                          |
| **Kelas**       | 5C Reg BJM                                          |
| **Proyek**      | `p07-tabel-dan-menu` (repository `pbo2-2410010364`) |

---

## 1. Tentang Proyek

Aplikasi **Daftar Kontak** dari Praktikum 1 sampai 6 Pertemuan 7. Aplikasi memakai `JTable` dengan `AbstractTableModel`, Menu Bar, dialog modal, pencarian, dan tombol yang aktif sesuai pilihan baris.

| Kelas              | Jenis                | Fungsi                                                      |
| ------------------ | -------------------- | ----------------------------------------------------------- |
| `Kategori`         | enum                 | Kategori kontak: Keluarga, Teman, Kampus, Kerja             |
| `Kontak`           | record               | Data satu kontak: nama, telepon, email, kategori            |
| `KontakTableModel` | `AbstractTableModel` | Menghubungkan `List<Kontak>` dengan `JTable`                |
| `DialogKontak`     | JDialog Form (modal) | Form tambah dan ubah kontak beserta validasi                |
| `AplikasiKontak`   | JFrame Form          | Jendela utama: tombol, tabel, pencarian, menu, label status |

File `.form`: `AplikasiKontak.form` dan `DialogKontak.form`.

**Cara menjalankan:** buka proyek di Apache NetBeans, Clean and Build, lalu Run File pada `AplikasiKontak.java`.

---

## 2. Peta Event

| Komponen                     | Menu Events               | Aksi                                                      |
| ---------------------------- | ------------------------- | --------------------------------------------------------- |
| `tambahButton`, `tambahItem` | Action: `actionPerformed` | `tambah()`: buka `DialogKontak` kosong                    |
| `ubahButton`, `ubahItem`     | Action: `actionPerformed` | `ubah()`: buka `DialogKontak` berisi data baris terpilih  |
| `hapusButton`, `hapusItem`   | Action: `actionPerformed` | `hapus()`: konfirmasi, lalu hapus dari model              |
| `cariField`                  | Key: `keyReleased`        | `saring()`: saring tabel berdasarkan nama, telepon, email |
| `kontakTable`                | Mouse: `mouseClicked`     | Klik dua kali memanggil `ubah()`                          |
| `keluarItem`                 | Action: `actionPerformed` | `dispose()`                                               |
| `tentangItem`                | Action: `actionPerformed` | `JOptionPane` berisi keterangan aplikasi                  |
| `batalButton` (dialog)       | Action: `actionPerformed` | `dispose()`                                               |
| `simpanButton` (dialog)      | Action: `actionPerformed` | `simpan()`: validasi, buat `Kontak`, tutup dialog         |

---

## 3. Jawaban Eksperimen Praktikum 5

**Eksperimen 1.** Setelah `fireTableRowsInserted(baris, baris);` dijadikan komentar, kontak baru tidak langsung muncul di tabel. Label status menampilkan 6 kontak, padahal tabel hanya menampilkan 5 baris. Baris baru baru muncul setelah tabel diurutkan lewat klik judul kolom.
Penjelasan: data sudah masuk ke `List` di model, tetapi `JTable` tidak diberi tahu sehingga tidak menggambar ulang. Method `fire...` adalah cara model memberi tahu tabel bahwa datanya berubah.

**Eksperimen 2.** Setelah `barisTerpilih()` diganti menjadi `return kontakTable.getSelectedRow();`, saya mencari "ah", memilih Ahmad Fauzi, lalu klik Hapus. Nama yang muncul di dialog konfirmasi adalah Budi Santoso, bukan Ahmad Fauzi.
Penjelasan: setelah disaring, Ahmad Fauzi ada di baris tampilan 1 tetapi di baris model 2. Tanpa `convertRowIndexToModel`, nomor 1 dipakai untuk `model.get(1)`, yaitu Budi Santoso. Kalau saya pilih Yes, kontak yang salah yang terhapus.

**Eksperimen 3.** Setelah `super(pemilik, judul, true)` diubah menjadi `false`, dialog tidak lagi modal dan kontak yang diisi lalu disimpan tidak muncul di tabel.
Penjelasan: pada dialog non-modal, `setVisible(true)` tidak menunggu dialog ditutup. Method `tampilkan()` langsung mengembalikan `hasil` yang masih `null`, sehingga `if (baru != null)` tidak pernah terpenuhi dan kontak tidak ditambahkan ke model. Karena itu dialog tambah dan ubah dibuat modal.

**Eksperimen 4.** Sebelum ada baris yang dipilih, Ctrl+E dan Ctrl+D tidak memunculkan apa pun. Setelah memilih baris, Ctrl+E membuka jendela Ubah dan Ctrl+D memunculkan pesan konfirmasi hapus.
Penjelasan: `perbaruiTombol()` menjalankan `ubahItem.setEnabled(adaPilihan)` dan `hapusItem.setEnabled(adaPilihan)`, jadi kedua item menu nonaktif selama tidak ada baris yang dipilih. Item menu yang nonaktif tidak menjalankan accelerator-nya.

**Eksperimen 5.** Setelah accelerator `hapusItem` diubah menjadi tombol Delete tanpa Ctrl, baris yang berubah di `initComponents()` adalah `hapusItem.setAccelerator(...)`. Pada baris itu, `KeyEvent.VK_D` berganti menjadi `KeyEvent.VK_DELETE`, dan `InputEvent.CTRL_DOWN_MASK` berganti menjadi `0` (tanpa modifier Ctrl).

**Eksperimen 6.** Setelah `model` dideklarasikan tanpa nilai dan baru diisi setelah `initComponents()`, program gagal dijalankan dengan pesan `java.lang.IllegalArgumentException: Cannot set a null TableModel`.
Penjelasan: `initComponents()` dipanggil di awal konstruktor dan menjalankan `kontakTable.setModel(model)`, padahal saat itu `model` masih `null`. `JTable` menolak model `null`. Dengan `private final KontakTableModel model = new KontakTableModel();`, objek sudah dibuat sebelum konstruktor berjalan.

---

## 4. Catatan Penggunaan AI

Jawaban Eksperimen 1 sampai 4 berasal dari pengamatan saya sendiri saat menjalankan aplikasi. Penjelasan dan jawaban Eksperimen 5 dan 6 dibantu AI (Claude). Deklarasi lengkap penggunaan AI ada di README proyek `p07-mini-proyek`.
