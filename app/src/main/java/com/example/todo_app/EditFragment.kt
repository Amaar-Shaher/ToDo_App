package com.example.todo_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.todo_app.R
import com.example.todo_app.data.Datasource
import com.example.todo_app.databinding.FragmentAddBinding
import com.example.todo_app.databinding.FragmentEditBinding
import com.example.todo_app.model.Todoinfo
import com.example.todo_app.model.Viewmodel
import javax.sql.DataSource

class EditFragment : Fragment() {

    private lateinit var binding: FragmentEditBinding


    private val viewModel : Viewmodel by viewModels()
    var index = 0
    var taskTitle = ""
    var taskDiescription = ""
    var taskDate = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        binding.apply {
//            lifecycleOwner=viewLifecycleOwner
//            viewmodelvar=viewModel
//        }

        arguments.let {
            index = it?.getInt("index")!!
            taskTitle = it.getString("taskTitle")!!
            taskDiescription = it.getString("diescription")!!
            taskDate = it.getString("date")!!



            binding.titleEditViewEdit.setText(taskTitle)
            binding.desEditViewEdit.setText(taskDiescription)
            binding.dateTextViewEdit.setText(taskDate)

        }

        binding?.saveBottonEdit?.setOnClickListener { view:View ->
            taskDate = binding.dateTextViewEdit.text.toString()
            taskTitle = binding.titleEditViewEdit.text.toString()
            taskDiescription = binding.desEditViewEdit.text.toString()
            Datasource().updateTask(index, Todoinfo(taskTitle, taskDiescription, taskDate))
            view.findNavController().navigate(R.id.action_editFragment_to_todoFragment)
        }

    }

    override fun onDestroy() {
        super.onDestroy()

    }


}