package com.br.appsantanderclone.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.appsantanderclone.R
import com.br.appsantanderclone.data.Pix

class PixAdapter(private val context: Context, private val pixList: MutableList<Pix>): RecyclerView.Adapter<PixViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_layout, parent, false)
        return PixViewHolder(view)
    }

    override fun onBindViewHolder(holder: PixViewHolder, position: Int) {

        holder.bindView(pixList[position])

        //val resources = context.getResources()
        //val pix: Pix
        //val resourceId = context.resources.getIdentifier(pix.imagem), "drawable",
        //context.getPackageName())
        //holder.itemView.iv_pix.setImageDrawable(resources.getDrawable(resourceId))

    }

    override fun getItemCount(): Int = pixList.size

    //holder.itemView.apply {
     //   movieTitle.text = moviesList[position].titulo
    //    movieImage.load(moviesList[position].imagem) {
     //       placeholder(R.drawable.ic_image)
      //      fallback(R.drawable.ic_image)
    //    }
 //   }

}


/*
class PessoaAdapter(private val context: Context, private var pessoaList: MutableList<Pessoa>):
        RecyclerView.Adapter<PessoaAdapter.PessoaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.pessoa_item, parent, false)
        return PessoaViewHolder(view)
    }

    override fun getItemCount() = pessoaList.size

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        holder.bindView(pessoaList[position])
    }

    class PessoaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textViewNome = itemView.textViewNome
        val textViewEmail = itemView.textViewEmail
        val textViewTelefone = itemView.textViewTelefone

        fun bindView(pessoa: Pessoa) {
            textViewNome.text = pessoa.nome
            textViewEmail.text = pessoa.email
            textViewTelefone.text = pessoa.telefone
        }
    }
}
 */