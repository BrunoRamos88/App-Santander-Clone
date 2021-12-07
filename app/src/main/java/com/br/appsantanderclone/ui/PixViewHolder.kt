package com.br.appsantanderclone.ui

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.br.appsantanderclone.data.Pix
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.cardview_layout.view.*

class PixViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {



    var textViewNome = itemView.tv_pix
    var imageViewPagar = itemView.iv_pix
    //itemView.product_icon.setImageDrawable(ContextCompat.getDrawable(context, _list.drawableResourceId)
    //var cardViewTransferir = itemView.mcv_card_transferir
    //var cardViewRecarga = itemView.mcv_card_recarga
    //var cardViewCobrar = itemView.mcv_card_cobrar

    fun bindView(pix: Pix) {
        textViewNome.text = pix.nome
        imageViewPagar

    }
}
