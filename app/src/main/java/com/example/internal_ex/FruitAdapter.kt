package com

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.internal_ex.Fruit
import com.example.internal_ex.R
import kotlinx.android.synthetic.main.card_item.view.*


class PersonAdapter(val context:Context,var arr:ArrayList<Fruit>)
    :RecyclerView.Adapter<PersonAdapter.PersonViewHolde>()

{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolde {
        var inflater=LayoutInflater.from(parent.context)
        var view= inflater.inflate(R.layout.card_item,parent,false)
        return PersonViewHolde(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolde, position: Int) {
        holder.bind(arr[position])

    }

    override fun getItemCount(): Int {
        return  arr.size
    }

    class PersonViewHolde(var view:View):RecyclerView.ViewHolder(view)
    {
        fun bind(p:Fruit)
        {
            view.tvname.setText(p.fr_name)
            view.tvfathername.setText(p.fr_fathername)
            view.tvage.setText(p.fr_age.toString())

        }
    }
}
