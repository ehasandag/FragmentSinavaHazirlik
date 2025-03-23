package com.hasandag.fragmentsinavahazirlik

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hasandag.fragmentsinavahazirlik.databinding.FragmentKitapDetayBinding


class KitapDetayFragment : Fragment() {

    private var _binding: FragmentKitapDetayBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKitapDetayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val kitapAdi = arguments?.getString("kitapAdi")
        val yazarAdi = arguments?.getString("yazarAdi")
        val sayfaSayisi = arguments?.getInt("sayfaSayisi")
        val yayinEvi = arguments?.getString("yayinEvi")
        binding.textKitapAdi.text = kitapAdi
        binding.textYazarAdi.text = yazarAdi
        binding.textSayfaSayisi.text = sayfaSayisi.toString()
        binding.textYayinEvi.text = yayinEvi

    }

}