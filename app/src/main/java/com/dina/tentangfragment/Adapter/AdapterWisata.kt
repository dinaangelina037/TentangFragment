package com.dina.tentangfragment.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dina.tentangfragment.R
import com.dina.tentangfragment.model.DataItem
import com.squareup.picasso.Picasso

class AdapterWisata(var listWisata: List<DataItem?>?) : RecyclerView.Adapter<AdapterWisata.MyViewHolder>() {
    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){
        val imgWisata = itemview.findViewById<ImageView>(R.id.img_wisata)
        val tvNameWisata = itemview.findViewById<TextView>(R.id.tv_nama_wisata)
        val tvHargaWisata = itemview.findViewById<TextView>(R.id.tv_harga_wisata)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rows_wisata,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.tvNameWisata.text = listWisata?.get(position)?.namaWisata
            holder.tvHargaWisata.text = listWisata?.get(position)?.harga.toString()
            Picasso.get()
                .load(listWisata?.get(position)?.image)
                .placeholder(R.drawable.carousel2)
                .error(R.drawable.ic_home_black_24dp)
                .into(holder.imgWisata)

    }

    override fun getItemCount(): Int {
        if (listWisata !=null){
            return listWisata!!.size
        } else{
            return 0
        }
    }
}