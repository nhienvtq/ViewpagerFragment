package com.morningrod.viewpagerfragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(private var fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> CommonFragment().newInstance(position, "this")
            1 -> CommonFragment().newInstance(position, "that")
            2 -> CommonFragment().newInstance(position, "those")
            else -> CommonFragment().newInstance(0, "this")
        }
    }




}
