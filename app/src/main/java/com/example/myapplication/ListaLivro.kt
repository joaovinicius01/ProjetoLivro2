package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaLivro : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LivroAdapter

    private val listaLivros = listOf(
        Livro("Livro 1", "Autor 1"),
        Livro("Livro 2", "Autor 2"),
        Livro("Livro 3", "Autor 3")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lista_livro, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        adapter = LivroAdapter(listaLivros)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        return view
    }

    data class Livro(val titulo: String, val autor: String)

    class LivroAdapter(private val listaLivros: List<Livro>) : RecyclerView.Adapter<LivroAdapter.LivroViewHolder>() {

        class LivroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val tituloTextView: TextView = itemView.findViewById(R.id.tituloTextView)
            val autorTextView: TextView = itemView.findViewById(R.id.autorTextView)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_livro, parent, false)
            return LivroViewHolder(view)
        }

        override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {
            val livro = listaLivros[position]
            holder.tituloTextView.text = livro.titulo
            holder.autorTextView.text = livro.autor
        }

        override fun getItemCount(): Int = listaLivros.size
    }

    interface OnLivroSelectedListener {
        fun onLivroSelected(livro: Livro)
    }

}
