package com.example.todo_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.navigation.Navigation
import com.example.todo_app.R
import com.example.todo_app.databinding.FragmentAddBinding
import com.example.todo_app.databinding.FragmentTodoBinding
import com.example.todo_app.model.Viewmodel


class AddFragment : Fragment() {
private lateinit var binding: FragmentAddBinding



private val viewModel : Viewmodel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       binding.apply {
           lifecycleOwner=viewLifecycleOwner
           viewmodelvar=viewModel
       }
binding?.saveBotton?.setOnClickListener { view:View ->
    Navigation.findNavController(view).navigate(AddFragmentDirections.actionAddFragmentToTodoFragment())
    viewModel.AddToList()
}
    }
}