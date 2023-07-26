package com.dekram.trumpetabc

import android.content.Context
import android.media.MediaPlayer
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
                0 -> R.drawable.nc1_gis0
                1 -> R.drawable.nc2_a0
                2 -> R.drawable.nc3_ais0
                3 -> R.drawable.nc4_b0
                4 -> R.drawable.nc5_c1
                5 -> R.drawable.nc6_cis1
                6 -> R.drawable.nc7_d1
                else -> 0
            }
        )

        val mp3files = listOf(
            R.raw.sounds_gis0,
            R.raw.sounds_a0,
            R.raw.sounds_ais0,
            R.raw.sounds_b0,
            R.raw.sounds_c1,
            R.raw.sounds_cis1,
            R.raw.sounds_d1
        )
        val mp3file = mp3files[position]
        holder.bind(mp3file)
    }

    override fun getItemCount(): Int = notesNames.size


    inner class PageHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val notesCard: TextView = itemView.findViewById(R.id.notes_card)
        val notesView: ImageView = itemView.findViewById(R.id.notesView)
        val playButton: ImageView = itemView.findViewById(R.id.play_button)

        fun bind(mp3file: Int) {
            playButton.setOnClickListener {
                val mediaPlayer: MediaPlayer = MediaPlayer.create(itemView.context, mp3file)
                mediaPlayer.start()
            }
        }
    }
}