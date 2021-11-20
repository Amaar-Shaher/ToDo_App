package com.example.todo_app.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todo_app.data.Datasource

class Viewmodel :ViewModel()   {

    val title = MutableLiveData("")
    val des = MutableLiveData("")
    val deaddate = MutableLiveData("")

    fun AddToList(){
        var task:Datasource=Datasource()
        task.add(Todoinfo(title.value.toString(),des.value.toString(),deaddate.value.toString()) )
    }

}