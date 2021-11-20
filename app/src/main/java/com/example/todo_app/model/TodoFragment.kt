package com.example.todo_app.model


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_app.adapter.ItemAdapter
import com.example.todo_app.data.Datasource
import com.example.todo_app.databinding.FragmentTodoBinding

class TodoFragment  : Fragment() {
var binding:FragmentTodoBinding?=null
   // private lateinit var recyclerView: RecyclerView
    private var dataset= Datasource().loadTodoFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoBinding.inflate(inflater, container, false)
        binding!!.lifecycleOwner = viewLifecycleOwner
        val view = binding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Toast.makeText(context, "here", Toast.LENGTH_SHORT).show()
       // recyclerView = binding?.recyclerView!!
        binding?.recyclerView?.adapter= ItemAdapter(dataset,requireContext(), view)
        binding?.addIcon?.setOnClickListener {view:View ->
            Navigation.findNavController(view).navigate(TodoFragmentDirections.actionTodoFragmentToAddFragment())
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}