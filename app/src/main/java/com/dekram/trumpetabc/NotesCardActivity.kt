package com.dekram.trumpetabc

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class NotesCardActivity : AppCompatActivity() {

    private lateinit var playButton: ImageView
    private lateinit var viewPager: ViewPager2
    private lateinit var tabs: TabLayout
    private val tabTitles = arrayOf("C", "D", "E", "F", "G", "A", "B")
    private val notesNames = listOf("C", "D", "E", "F", "G", "A", "B")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_card)
        viewPager = findViewById(R.id.view_pager)
        tabs = findViewById(R.id.tabs)
        viewPager.adapter = PagerAdapter(this, notesNames)
        TabLayoutMediator(tabs, viewPager) { tabs, position ->
            tabs.text = tabTitles[position]
        }.attach()
    }

}

class PagerAdapter(private val context: Context, private val notesNames: List<String>): RecyclerView.Adapter<PagerAdapter.PageHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageHolder  =
        PageHolder(LayoutInflater.from(context).inflate(R.layout.item_card, parent, false))

    override fun onBindViewHolder(holder: PageHolder, position: Int) {
        holder.notesCard.text = notesNames[position]
        holder.notesView.setImageResource(
            when(position) {
                0 -> R.drawable.scales_ces_dur
                1 -> R.drawable.scales_b_dur
                2 -> R.drawable.scales_des_dur
                3 -> R.drawable.scales_a_dur
                4 -> R.drawable.scales_b_moll
                5 -> R.drawable.scales_e_dur
                6 -> R.drawable.scales_f_dur
                else -> R.drawable.scales_b_moll
            }
        )
    }

    override fun getItemCount(): Int = notesNames.size

    inner class PageHolder(view: View): RecyclerView.ViewHolder(view){
        val notesCard: TextView = view.findViewById(R.id.notes_card)
        val notesView: ImageView = view.findViewById(R.id.notesView)
    }
}