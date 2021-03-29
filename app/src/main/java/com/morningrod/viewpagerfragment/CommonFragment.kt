package com.morningrod.viewpagerfragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.morningrod.viewpagerfragment.databinding.FragmentCommonBinding
import kotlin.properties.Delegates

class CommonFragment : Fragment() {
    private lateinit var _binding: FragmentCommonBinding
    private val binding get() = _binding

    private lateinit var fragmentCommon: CommonFragment
    private lateinit var mBundle: Bundle

    private lateinit var title: String
    private var pageNumber by Delegates.notNull<Int>()
    private var oriPageNumber by Delegates.notNull<Int>()
    private lateinit var mText: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_common, container, false)

        fragmentCommon = CommonFragment()
        mBundle = Bundle()
        title = arguments?.getString("titleKey").toString()
        pageNumber = arguments?.getInt("pageKey") ?: 0

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.childFragmentTextview.text = "$title: $pageNumber"
    }

    fun newInstance(pageNumber: Int, title: String?): CommonFragment {
        val createFragment = CommonFragment()
        val createBundle = Bundle()
        createBundle.putInt("pageKey", pageNumber)
        createBundle.putString("titleKey", title)
        createFragment.arguments = createBundle
        return createFragment
    }
}