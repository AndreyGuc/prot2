package com.andoc.tp103

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (listArray:ArrayList<ListItemPlus>, context: Context): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    var listArr = listArray
    var contextR = context

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvContent = view.findViewById<TextView>(R.id.tvContent)
        val tvUrl = view.findViewById<TextView>(R.id.tvUrl)

        fun bind( listItem:ListItemPlus, context: Context) {

            tvTitle.text = listItem.titleText
            tvContent.text = listItem.contentText
            tvUrl.text = listItem.urlLink
            itemView.setOnClickListener(){
                Toast.makeText(context,"Pressed : ${tvTitle.text}",Toast.LENGTH_LONG).show()
                val i = Intent(context,ContentActivity::class.java).apply {
                    putExtra("title",tvTitle.text.toString())
                    putExtra("content",tvContent.text.toString())
                    putExtra("url",tvUrl.text.toString())
                }
                context.startActivity(i)
            }

        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout,parent,false))
    }
    override fun getItemCount(): Int {
        return listArr.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listArr.get(position)
        holder.bind(listItem,contextR)
    }
    fun updateAdapter(listArray : List<ListItemPlus>)
    {listArr.clear()
        listArr.addAll(listArray)
        notifyDataSetChanged()
    }
}