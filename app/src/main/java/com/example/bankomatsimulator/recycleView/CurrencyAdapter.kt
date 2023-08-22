package com.example.bankomatsimulator.recycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankomatsimulator.Data
import com.example.bankomatsimulator.R
import com.example.bankomatsimulator.databinding.ListItemBinding

class CurrencyAdapter: RecyclerView.Adapter<CurrencyAdapter.CurViewHolder>() {

    private var currencies = Data.curList

    class CurViewHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = ListItemBinding.bind(item)

        fun bind(currency: CurrencyModel){
            binding.curIcon.setImageResource(currency.icon)
            binding.curName.text = currency.name
            binding.curValue.text = currency.cost.toString()


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return  CurViewHolder(view)
    }

    override fun onBindViewHolder(holder: CurViewHolder, position: Int) {
        holder.bind(currencies[position])
    }

    override fun getItemCount(): Int {
        return currencies.size
    }
}