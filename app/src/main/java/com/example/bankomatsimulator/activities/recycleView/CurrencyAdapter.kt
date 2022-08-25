package com.example.bankomatsimulator.activities.recycleView

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bankomatsimulator.R
import com.example.bankomatsimulator.databinding.ListItemBinding

class CurrencyAdapter: RecyclerView.Adapter<CurrencyAdapter.CurViewHolder>() {

    class CurViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root)

    var currencies: List<Currency> = emptyList()
        set(newValue){
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return  CurViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CurViewHolder, position: Int) {
        var currency = currencies[position]
        with(holder.binding){
            curIcon.setImageResource(R.drawable.ic_baseline_attach_money_24)
            curName.text = currency.name
            curValue.text = currency.cost.toString()
        }
    }

    override fun getItemCount(): Int {
        return currencies.size
    }
}