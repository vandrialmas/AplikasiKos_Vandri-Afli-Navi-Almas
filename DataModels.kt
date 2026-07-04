// File: DataModels.kt

import java.util.Date

/**
 * 1. Implementasi Class Barang
 * Menerapkan enkapsulasi pada 'stok' dan 'harga' agar nilainya tidak bisa diset minus (negatif).
 */
class Barang(
    val idBarang: String,
    val namaBarang: String,
    hargaAwal: Double,
    stokAwal: Int
) {
    // Custom setter untuk harga agar tidak boleh kurang dari 0
    var harga: Double = hargaAwal
        set(value) {
            if (value >= 0) {
                field = value
            } else {
                println("Error: Harga tidak boleh negatif!")
            }
        }

    // Custom setter untuk stok (Validasi: stok barang tidak boleh minus)
    var stok: Int = stokAwal
        set(value) {
            if (value >= 0) {
                field = value
            } else {
                println("Error: Stok barang tidak boleh minus!")
            }
        }

    fun kurangiStok(jumlah: Int) {
        if (stok - jumlah >= 0) {
            stok -= jumlah
        } else {
            println("Error: Stok tidak mencukupi untuk dikurangi!")
        }
    }

    fun tambahStok(jumlah: Int) {
        if (jumlah > 0) {
            stok += jumlah
        }
    }
}

/**
 * 2. Implementasi Class Pengguna
 * Menerapkan validasi format email pada custom setter atribut 'email'.
 */
class Pengguna(
    val idPengguna: String,
    val nama: String,
    emailAwal: String
) {
    // Custom setter untuk validasi email sederhana (harus mengandung '@')
    var email: String = emailAwal
        set(value) {
            if (value.contains("@")) {
                field = value
            } else {
                println("Error: Format email tidak valid!")
            }
        }

    fun cariBarang(): List<Barang> {
        return emptyList()
    }

    fun checkoutBarang(): String {
        return "Transaksi Berhasil"
    }

    fun bayarBarang(idTransaksi: String): Boolean {
        return true
    }

    fun cetakInvoice(idTransaksi: String) {
        println("Mencetak invoice untuk $idTransaksi")
    }
}
