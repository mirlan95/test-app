package com.example.mirlan.diplom.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.text.BoringLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mirlan.diplom.R
import com.example.mirlan.diplom.model.Exam
import kotlinx.android.synthetic.main.recycler_item_row.view.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import java.util.*

/**
 * Created by mirlan on 5/15/18.
 */
class ExamAdapter(private val examList: ArrayList<Exam>, private val listener: Listener) : RecyclerView.Adapter<ExamAdapter.ViewHolder>() {


    interface Listener{
        fun onItemClick(mExam: Exam)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){

        holder.bind(examList[position], listener, position)
       // holder?.examName?.text = examList[position].exam

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_row,parent,false)
        return ViewHolder(v)

   }

    override fun getItemCount():Int = examList.count()

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){


        @SuppressLint("SimpleDateFormat")
        fun bind(mExam :Exam, listener: Listener, position: Int){
           // val date = LocalDateTime.parse(mExam.time.toString())
            //val currentData = LocalDateTime.now()
            //val form = currentData.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))
            val day = Calendar.getInstance()

            ///val month = Calendar.MONTH
            val sdf = SimpleDateFormat("yyyy-MM-dd")
            val currentDate = sdf.format(Date())
            val serverDate = mExam.date?.substring(0..9)
            //val mMonth = mExam.date?.substring(5..6)?.toInt()

            //Toast.makeText()
            if(mExam.enabled == 1 && serverDate == currentDate) {
                itemView.examName.text = mExam.exam
                itemView.dateText.text = mExam.date

            }else{
                itemView.card_view.visibility = View.GONE
            }

                itemView.setOnClickListener{listener.onItemClick(mExam)}

        }


    }

}