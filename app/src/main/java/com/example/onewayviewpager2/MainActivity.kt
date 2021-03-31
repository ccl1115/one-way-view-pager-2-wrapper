package com.example.onewayviewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vp: ViewPager2 = findViewById(R.id.vp)

        vp.adapter = Adapter {
            vp.currentItem = 0
        }
    }
}

class PageMainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val text: TextView = itemView.findViewById(R.id.text)
    init {
        itemView.tag = "main"
    }
}

class PageSecondViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val btn: Button = itemView.findViewById(R.id.btn)
    init {
        itemView.tag = "second"
    }
}

class Adapter(val onBackClickListener: View.OnClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            0 -> {
                return PageMainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.page_main, parent, false))
            }
            1 -> {
                return PageSecondViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.page_second, parent, false))
            }
        }
        throw IllegalStateException()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PageMainViewHolder -> {
                holder.text.text = "I'm the main page"
            }
            is PageSecondViewHolder -> {
                holder.btn.setOnClickListener(onBackClickListener);
            }
            else -> {
            }
        }
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun getItemViewType(position: Int): Int {
        return position;
    }

}