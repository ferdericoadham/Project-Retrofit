package com.example.project_retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DataAdapter(val dataAdapter: List<ResultsItem>) : RecyclerView.Adapter<DataAdapter.MyViewHolder>() {
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val theImagePP = view.findViewById<ImageView>(R.id.pp_profile)
        var theName = view.findViewById<TextView>(R.id.the_name)
        var theSpecies = view.findViewById<TextView>(R.id.the_species)
        var theStatus = view.findViewById<TextView>(R.id.live_status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_items, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(dataAdapter !=null){
            return dataAdapter.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.theName.text = dataAdapter?.get(position)?.name
        holder.theStatus.text = dataAdapter?.get(position)?.status
        holder.theSpecies.text = dataAdapter?.get(position)?.species

        Glide.with(holder.theImagePP)
            .load(dataAdapter?.get(position)?.image)
            .error(R.drawable.ic_launcher_background)
            .into(holder.theImagePP)
        holder.itemView.setOnClickListener {
            val name = dataAdapter?.get(position)?.name
            Toast.makeText(holder.itemView.context, "${name}", Toast.LENGTH_SHORT).show()

        }


    }
}