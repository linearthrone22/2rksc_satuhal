package com.rksc.satuhalselesai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rksc.satuhalselesai.ui.theme.SatuhalselesaiTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SatuhalselesaiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuoteGenerator(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// List of inspirational quotes
val quotes = listOf(
    // Quotes Awal
    "Terbentur, terbentur, terbentuk. - Jovan Diego",
    "Tidak apa-apa Hedon asalkan buat perut. - Albryan Sandi",
    "Oke gas, oke gas. Lantai 6 kita gas . - Humam Arsy",
    "Kalau ada yang bilang ‘santai aja’, biasanya dia nggak ikut ngerjain. - Aristotle",
    "Pekerjaan berat akan terasa ringan… kalau nggak dikerjain. - Johanes Enda",
    "Diam tak akan menyelesaikan masalah, tapi diam juga tak akan menimbulkan masalah. - M. Gian Bhismawan",
    "Nilai bagus itu bonus. Yang penting naik kelas. - Gciyless",
    "PR itu seperti mantan. Sering bikin pusing tapi harus dikerjakan. - Kaitoshinc",
    "Jangan rendah diri. Rendah hati saja. - Mas Faiz",
    "Bahagia itu sederhana. Cukup punya duit banyak, sehat, dan ganteng. - Delon",
    "Kalau bingung, tanya saja sama mbah Google. - Aulia Rahma",
    "Kesehatan itu mahal. Makanya jangan dijual murah. - Clen William",
    "Manfaatkan waktu sebaik-baiknya. Tidur misalnya. - Donny",
    "Bermimpilah setinggi langit. Kalau jatuh kan masih ada awan-awan. - Alzena Widya",
    "Kerja itu ibadah. Jadi santai saja, ibadah tidak perlu ngoyo. - Indira Rachma",
    "Jangan tunda pekerjaan sampai besok, kalau masih bisa dikerjakan lusa. - Matius",
    "Hidup itu seperti matematika. Kalau terasa mudah, berarti caramu salah. - Gempar",
    "Rebahan adalah cara saya menghemat energi untuk masa depan yang tidak pasti. - Aristo",
    "Katanya 'You are what you eat'. Hari ini sepertinya aku adalah sebungkus nasi uduk. - Keisha",
    "Kerja kelompok itu seni. Seni menitipkan nasib pada satu teman yang paling rajin. - Dira",
    "Uang memang bukan segalanya, tapi segalanya butuh uang. Jadi, mari cari uang. - honda",
    "Motivasi terbaik datang dari dua hal: deadline dan tagihan. - MG",
    "Jangan menyerah, kecuali kalau kasur dan bantal sudah memanggil. - Nova",
    "Gajian itu seperti bintang jatuh, indah tapi cepat sekali hilangnya. - Aditia Hadi",
    "Kalau kamu cari yang sempurna, aku mundur. Tapi kalau cari yang bisa diajak makan gratis, aku maju paling depan. - Monica Pasopati",
    "Overthinking itu gratis, makanya peminatnya banyak. - Humam",
    "Jangan biarkan orang lain merendahkanmu. Cukup kamu saja yang tahu betapa rendahnya standarmu. - Tian",
    "Masalah hidup bisa diselesaikan dengan tidur. Kalau belum selesai, berarti tidurnya kurang lama. - Nana",
    "Hidup itu butuh keseimbangan. Seimbang antara kerja keras dan scroll TikTok. - Zena",
    "Kebahagiaan itu sederhana: Wi-Fi kencang, baterai penuh, dan tidak ada yang mengganggu. - Delon",
    "Jangan takut gagal. Takutlah kalau kuota internet habis pas lagi seru-serunya. - Ariq",
    "Katanya pengalaman adalah guru terbaik. Sepertinya aku sudah terlalu banyak belajar. - Jovan",
    "Kesehatan itu penting, makanya jangan lupa makan enak walaupun tanggal tua. - Clen",
    "Deadline itu bagai hantu, tidak terlihat tapi sukses bikin merinding. - Tary",
    "Menjadi dewasa adalah belajar pura-pura mengerti saat orang lain bicara investasi. - Lira",
    "Tugas paling berat itu bukan mengangkat beban, tapi mengangkat badan dari tempat tidur. - Enda",
    "Aku bukan pemalas, aku hanya sedang dalam mode 'hemat energi'. - gciyless",
    "Belajar dari kesalahan itu bagus, tapi lebih bagus belajar dari kesalahan teman. - xianchia",
    "Jadilah seperti nanas. Punya mahkota di kepala, tapi tetap manis di dalam. - relciaz",
    "Revisi itu adalah cara dosen berkata 'Aku sayang kamu, makanya aku nggak mau kamu cepat lulus'. - kaitoshinc",
    "Masa depan itu misteri. Sama misteriusnya dengan hilangnya satu kaos kaki setelah dicuci. - joyaela",
    "Dompetku seperti bawang. Setiap kali dibuka, bikin menangis. - ginzbi",
    "Hidup ini singkat. Habiskan untuk hal-hal yang membuatmu bahagia, misalnya cicilan. - Lmts LittleTzy",
    "Energi hari ini disponsori oleh kopi dan harapan semoga cepat pulang. - DONNY",
    "Jangan panggil aku pemimpi. Panggil saja aku ahli strategi tidur. - call me G",
    "Kalau hidup memberimu lemon, jual saja. Lumayan buat jajan. - Matius",
    "Semangatku hari Senin itu seperti sinyal di pedalaman, hilang-timbul. - Gempar",
    "Aku tidak tersesat, aku hanya sedang mencari jalan alternatif menuju warung kopi. - Aristo",
    "Status 'online' bukan berarti siap diganggu, bisa jadi cuma lagi cari promo makanan. - Keisha",
    "Percayalah, di balik setiap kata 'nanti aja', ada kemalasan yang terstruktur. - Dira",
    "Jadi orang jangan terlalu serius, nanti cepat tua. Kecuali kalau jadi kaya raya, itu seriusin aja. - honda",
    "Otakku butuh liburan, tapi dompetku bilang 'di rumah aja'. - MG",
    "Berpikir positif itu perlu. Positif akan ada promo diskon di akhir bulan. - Nova",
    "Kegagalan adalah kesuksesan yang tertunda. Mungkin tertundanya agak lama. - Aditia Hadi",
    "Kalau disuruh memilih antara cinta dan karier, aku pilih tidur siang. - Monica Pasopati",
    "Jangan ragu mengambil keputusan. Ragu-ragulah saat melihat tagihan kartu kredit. - Humam",
    "Kunci kesuksesan adalah bangun pagi. Tapi kuncinya sering hilang. - Tian",
    "Setiap masalah pasti ada solusinya. Kalau tidak ada, ya itu bukan masalahmu. - Nana",
    "Cita-citaku dulu jadi astronot, sekarang cukup jadi orang yang bisa tidur 8 jam sehari. - Zena",
    "Harta, tahta, dan kuota tak terbatas. - Delon",
    "Jangan hanya numpang hidup, setidaknya numpang Wi-Fi juga. - Ariq",
    "Jadilah unik. Saat semua orang berlari, kamu jalan santai saja. - Jovan",
    "Hidup sehat itu mudah. Jauhi gorengan, dekati tukang buah. Tapi abangnya sering sebelahan. - Clen",
    "Usia hanyalah angka. Yang penting semangat jajan tidak pernah pudar. - Tary",
    "Menjadi dewasa itu menyadari bahwa pahlawan sebenarnya adalah ibu yang tahu letak semua barang di rumah. - Lira",
    "Pekerjaan paling menyenangkan adalah hobi yang dibayar. Contohnya, tidur. - Enda",
    "Nilai ujian itu relatif. Yang absolut itu rasa kantuk di kelas. - gciyless",
    "Pasang alarm jam 5 pagi, lalu bangun jam 8. Itu namanya perencanaan strategis. - xianchia",
    "Jodoh itu di tangan Tuhan. Tapi kalau lama, mungkin Tuhan lupa naruhnya di mana. - relciaz",
    "Mantan itu seperti soal ujian. Ada yang mudah dilupakan, ada yang harus diingat sampai pusing. - kaitoshinc",
    "Tertawa itu menyehatkan, apalagi kalau menertawakan nasib sendiri. - joyaela",
    "Aku dan kasurku punya hubungan spesial. Orang lain tidak akan mengerti. - ginzbi",
    "Alarm pagi adalah musuh masyarakat nomor satu. - Lmts LittleTzy",
    "Niat kerja sudah 100%, tapi energi masih loading 10%. - DONNY",
    "Kalau ada yang melemparimu batu, lempar balik dengan bunga. Tapi pastikan potnya ikut. - call me G",
    "Berhenti menyalahkan diri sendiri. Salahkan saja keadaan. - Matius",
    "Hidup itu penuh warna. Terutama warna abu-abu di tanggal tua. - Gempar",
    "Olahraga favoritku adalah angkat sendok dan garpu. - Aristo",
    "Katanya cinta itu buta. Tapi kok masih bisa lihat saldo ATM? - Keisha",
    "Meeting online tanpa on-cam adalah puncak kenikmatan kerja dari rumah. - Dira",
    "Jadilah seperti Power Ranger. Masalah datang, langsung berubah. - honda",
    "Di dunia ini tidak ada yang gratis, kecuali senyum dan omelan orang tua. - MG",
    "Hari terbaik untuk memulai diet adalah besok. Selalu besok. - Nova",
    "Kesabaran itu ada batasnya. Apalagi kalau nungguin download-an. - Aditia Hadi",
    "Cantik itu butuh biaya. Kalau mau gratis, cukup pakai filter saja. - Monica Pasopati",
    "Kalau bingung mau ngapain, ngemil saja dulu. Siapa tahu dapat pencerahan. - Humam",
    "Tetap tenang, walaupun isi kepala sudah seperti pasar malam. - Tian",
    "Masa depan cerah itu butuh istirahat yang cukup. - Nana",
    "Jangan takut mencoba hal baru, kecuali resep masakan dari internet. - Zena",
    "Uang tidak bisa membeli kebahagiaan, tapi bisa membeli pizza, dan itu hampir sama. - Delon",
    "Jadilah orang baik, tapi jangan jadi orang yang gampang dimanfaatin. - Ariq",
    "Saat hidup terasa berat, ingatlah cicilanmu lebih berat. - Jovan",
    "Obat dari segala penyakit adalah liburan. Efek sampingnya, dompet jadi sakit. - Clen",
    "Jangan bandingkan dirimu dengan orang lain. Rumput tetangga memang selalu kelihatan lebih hijau, mungkin karena pakai pupuk subsidi. - Tary",
    "Dewasa adalah ketika kamu sadar, tagihan lebih menakutkan daripada film horor. - Lira",
    "Lebih baik ditolak cinta daripada ditolak HRD. - Enda",
    "Aku tipe orang yang setia. Setia sama rasa ngantuk. - gciyless",
    "Rencana A: sukses. Rencana B: kalau rencana A gagal, pakai rencana A lagi dengan lebih banyak doa. - xianchia",
    "Terkadang, solusi terbaik adalah bilang 'oh gitu'. - relciaz",
    "Kenangan itu seperti utang. Sulit dilupakan dan selalu menghantui. - kaitoshinc",
    "Prioritas hidup: satu, tidur. Dua, lihat nomor satu. - joyaela",
    "Jangan biarkan ekspektasi orang lain mengganggumu. Ekspektasimu sendiri saja sudah cukup merepotkan. - ginzbi",
    "Hidup itu harus produktif. Misalnya, produktif menghasilkan alasan untuk tidak melakukan apa-apa. - Lmts LittleTzy",
    "Setiap orang punya masalahnya masing-masing. Masalahku hari ini: mau makan apa? - DONNY",
    "Jadilah seperti durian. Dari luar tajam, tapi dalemnya dicari banyak orang. - call me G",
    "Makin dewasa, makin sadar kalau teman sejati itu cuma satu: duit. - Matius",
    "Fokus itu penting, tapi kalau lapar ya bubar. - Gempar",
    "Kenapa harus lari pagi kalau lari dari kenyataan saja sudah bikin capek? - Aristo",
    "Move on itu gampang. Yang susah itu bayar parkir di mall pas weekend. - Keisha",
    "Percaya diri itu bagus, tapi jangan sampai kelewat batas dan jadi malu-maluin. - Dira",
    "Jadilah air yang mengalir. Kalau ada batu, belok aja. Gak usah ditabrak. - honda",
    "Aku tidak pelit, aku hanya manajer keuangan yang baik untuk diriku sendiri. - MG",
    "Saat semua terasa salah, coba belok kanan. - Nova",
    "Kesempatan tidak datang dua kali. Tapi tukang paket bisa datang berkali-kali. - Aditia Hadi",
    "Bahagia itu pilihan. Dan hari ini aku memilih untuk tidak peduli. - Monica Pasopati"
)

@Composable
fun QuoteGenerator(modifier: Modifier = Modifier) {
    var currentQuoteIndex by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Kata-kata hari ini",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(32.dp))

        Card(
            modifier = Modifier.padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Text(
                text = quotes[currentQuoteIndex],
                style = MaterialTheme.typography.bodyLarge,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(24.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                currentQuoteIndex = Random.nextInt(quotes.size)
            }
        ) {
            Text("Lagi dong bang")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuoteGeneratorPreview() {
    SatuhalselesaiTheme {
        QuoteGenerator()
    }
}