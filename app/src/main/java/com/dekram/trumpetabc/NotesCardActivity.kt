package com.dekram.trumpetabc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class NotesCardActivity : AppCompatActivity() {

    private lateinit var notesCard: ImageView
    private lateinit var playButton: ImageView
    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_card)
        viewPager = findViewById(R.id.view_pager)
        notesCard = findViewById(R.id.notes_card)
        viewPager.adapter = ViewPagerAdapter()
    }
}

class ViewPagerAdapter : RecyclerView.Adapter<PagerVH>() {

    private val notes = intArrayOf(
        R.drawable.a_dur,
        R.drawable.a_moll,
        R.drawable.as_dur,
        R.drawable.b_dur
    )

    private val sounds = intArrayOf(
        1,
        2,
        3,
        4
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH =
        PagerVH(LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false))

    override fun onBindViewHolder(holder: PagerVH, position: Int) =
        holder.itemView.run {
//            notesCard.setImageResource(notes[position])
//            playButton.setImageResource(sounds[position])
        }

    override fun getItemCount(): Int = notes.size

}

class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView)