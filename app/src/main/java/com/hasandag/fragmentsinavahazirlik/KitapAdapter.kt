package com.hasandag.fragmentsinavahazirlik

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasandag.fragmentsinavahazirlik.databinding.KitapRowBinding

class KitapAdapter( private val kitapListesi: List<Kitap>, private val onItemClick: (Kitap) -> Unit) : RecyclerView.Adapter<KitapAdapter.KitapViewHolder>() {

    inner class KitapViewHolder(val binding: KitapRowBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    // Burada tıklanan kitabı onItemClick fonksiyonuna gönderiyoruz
                    onItemClick(kitapListesi[adapterPosition])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitapViewHolder {
        val view = KitapRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KitapViewHolder(view)
    }

    override fun getItemCount(): Int {
        return kitapListesi.size
    }

    override fun onBindViewHolder(holder: KitapViewHolder, position: Int) {
        val kitap = kitapListesi[position]
        holder.binding.textKitapAdi.text = kitap.kitapAdi
        holder.binding.textYazarAdi.text = kitap.yazarAdi
        holder.binding.textYayinEvi.text = kitap.yayinEvi
        holder.binding.textSayfaSayisi.text = "${kitap.sayfaSayisi} sayfa"

        /*
            holder.binding.root.setOnClickListener {
                onItemClick(kitap)
            }
         */
        // Öğe tıklama olayını burada ayarla
    }
}
