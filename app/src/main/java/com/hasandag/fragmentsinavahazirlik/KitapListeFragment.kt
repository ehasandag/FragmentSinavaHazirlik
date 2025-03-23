package com.hasandag.fragmentsinavahazirlik

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hasandag.fragmentsinavahazirlik.databinding.FragmentKitapListeBinding


class KitapListeFragment : Fragment() {

    private var _binding: FragmentKitapListeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentKitapListeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Kitap listesi oluşturma
        val kitapListesi = mutableListOf(
            Kitap("Sefiller", "Victor Hugo", 200, "Can Yayınları"),
            Kitap("İnce Memed", "Yaşar Kemal", 300, "İthaki Yayınları"),
            Kitap("Kuyucaklı Yusuf", "Sabahattin Ali", 400, "Can Yayınları"),
            Kitap("İki Şehrin Hikayesi", "Charles Dickens", 500, "İthaki Yayınları"),
            Kitap("Fareler ve İnsanlar", "John Steinbeck", 600, "Can Yayınları")
        )
        // Adaptörü oluştur ve tıklama olayını ayarla
        val adapter = KitapAdapter(kitapListesi) { kitap ->
            // Kitap bilgilerini Bundle içine koy
            val bundle = Bundle().apply {
                putString("kitapAdi", kitap.kitapAdi)
                putString("yazarAdi", kitap.yazarAdi)
                putInt("sayfaSayisi", kitap.sayfaSayisi)
                putString("yayinEvi", kitap.yayinEvi)
            }
            // Kitap detayına geçiş yap
            findNavController().navigate(R.id.action_kitapListeFragment_to_kitapDetayFragment, bundle)
        }
        // RecyclerView'e adaptörü bağla
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}