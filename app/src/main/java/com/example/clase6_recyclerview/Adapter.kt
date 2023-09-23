package com.example.clase6_recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val context: Context) : ListAdapter<Pokemon, Adapter.ViewHolder>(DiffCallBack) {
    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val name: TextView = view.findViewById(R.id.textViewName)
        private val life: TextView = view.findViewById(R.id.textViewLife)
        private val atq: TextView = view.findViewById(R.id.textViewAttack)
        private val def: TextView = view.findViewById(R.id.textViewDefense)
        private val imagenType: ImageView = view.findViewById(R.id.imageViewType)
        private val image: ImageView = view.findViewById(R.id.imageViewImage)

        fun bind (pokemon: Pokemon) {
            name.text = pokemon.name
            life.text = "Vida: " + pokemon.life.toString()
            atq.text = "Ataque: " + pokemon.atq.toString()
            def.text = "Defensa: " + pokemon.def.toString()

            val imagen = when (pokemon.type) {
                TipoPokemon.PLANTA -> R.drawable.planta
                TipoPokemon.ELECTRICO -> R.drawable.electrico
                TipoPokemon.FUEGO -> R.drawable.fuego
                TipoPokemon.AGUA -> R.drawable.agua
                TipoPokemon.LUCHA -> R.drawable.fighter
            }

            imagenType.setImageResource(imagen)

            Glide.with(context).load(pokemon.image).into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
    }
}
