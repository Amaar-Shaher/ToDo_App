package com.example.todo_app.data

import TaslList
import com.example.todo_app.R
import com.example.todo_app.model.TodoFragment
import com.example.todo_app.model.Todoinfo
import java.util.*

class Datasource {


    fun loadTodoFragment(): List<Todoinfo> {
    return TaslList

    }
    fun add (task: Todoinfo){
        TaslList.add(task)
    }
    fun deleteTask(index:Int){
        TaslList.removeAt(index)
    }
    fun updateTask(index: Int, task: Todoinfo){
       TaslList.set(index, task)
    }

}

