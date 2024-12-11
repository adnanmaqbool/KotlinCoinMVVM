package com.adnan.kotlincoin.screens.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.adnan.kotlincoin.adapter.CategoryListAdapter
import com.adnan.kotlincoin.databinding.FragmentHomeBinding
import com.adnan.kotlincoin.interfaces.AdapterItemClick
import com.adnan.kotlincoin.model.responseModel.CategoryItem
import com.adnan.kotlincoin.session.SessionManager
import com.adnan.kotlincoin.showErrorMsg
import com.adnan.kotlincoin.showSuccessMsg
import com.adnan.kotlincoin.viewmodel.HomeViewModel
import com.axelliant.hris.event.EventObserver
import org.koin.android.ext.android.inject

class HomeFragment : BaseFragment() {

    private val sessionManager: SessionManager by inject()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by inject()
    private lateinit var categoryListAdapter: CategoryListAdapter

    private var categoryList: ArrayList<CategoryItem> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        homeViewModel.listApi(32) // api call


        homeViewModel.getIsLoading()
            .observe(viewLifecycleOwner, EventObserver { isLoading ->
                if (isLoading) {
                    showDialog()
                } else {
                    hideDialog()
                }
            })


        binding?.rvCategory?.layoutManager = LinearLayoutManager(requireContext())
        categoryListAdapter = CategoryListAdapter(categoryList, object : AdapterItemClick {
            override fun onItemClick(customObject: Any, position: Int) {

                requireContext().showSuccessMsg("Show detail for category = ${(customObject as CategoryItem).EngCategoryNameAdvance}")

            }

        })
        binding?.rvCategory?.adapter = categoryListAdapter



        homeViewModel.categoryListResponse.observe(
            viewLifecycleOwner,
            EventObserver { response ->

                if (response != null && response.categoryList.isNotEmpty()) {

                    categoryList.clear()
                    categoryList.addAll(response.categoryList)
                    categoryListAdapter.notifyDataSetChanged()

                } else {
                    requireContext().showErrorMsg(response?.message)
                }

            })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

