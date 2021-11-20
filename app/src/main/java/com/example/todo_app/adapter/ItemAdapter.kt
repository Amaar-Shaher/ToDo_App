package com.example.todo_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_app.R
import com.example.todo_app.data.Datasource
import com.example.todo_app.model.TodoFragmentDirections
import com.example.todo_app.model.Todoinfo

class ItemAdapter(var dataSet:List<Todoinfo>, var context : Context, val view: View):RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
var datasourceObject = Datasource()
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        var title:TextView = view.findViewById(R.id.title_text_view)
        var des:TextView = view.findViewById(R.id.des_text_view)
        var date:TextView = view.findViewById(R.id.date_text_view)
        val delete :ImageButton= view.findViewById(R.id.delete_icon)
        val edit: ImageButton = view.findViewById(R.id.edit_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.title.text = item.Tasktitle
        holder.des.text = item.Description
        holder.date.text = item.deadLine
        holder.delete.setOnClickListener {
            datasourceObject.deleteTask(position)
            notifyDataSetChanged()
        }
        holder.edit.setOnClickListener {
            val action = TodoFragmentDirections.actionTodoFragmentToEditFragment(position, item.Tasktitle, item.Description, item.deadLine)
           view.findNavController().navigate(action)

        }

    }
    override fun getItemCount(): Int {
        return dataSet.size
    }
}