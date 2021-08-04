package com.talisol.abjadtrainer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.talisol.abjadtrainer.databinding.SingleLetterBinding

class LetterAdapter (
    var letters: MutableList<Letter>
): RecyclerView.Adapter<LetterAdapter.LetterViewHolder>(){

    inner class LetterViewHolder(val binding: SingleLetterBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val view = SingleLetterBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return LetterViewHolder(view)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        holder.itemView.apply{
            holder.binding.textView3.text = letters[letters.size  - position - 1].arabicLetter
            holder.binding.textView4.text = letters[letters.size - position - 1].letterValue.toString()
//            holder.binding.textView3.text = letters[position].arabicLetter
//            holder.binding.textView4.text = letters[position].letterValue.toString()
        }

    }

    override fun getItemCount(): Int {
        return letters.size
    }
}