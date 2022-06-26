package rich.igop.dongthapp.fragments

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import rich.igop.dongthapp.R
import rich.igop.dongthapp.base.BaseFragment
import rich.igop.dongthapp.binding.viewBinding
import rich.igop.dongthapp.databinding.FragmentMainBinding

class MainFragment(
    private val listener: NavigationListener
): BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    override val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    private val bottomAdapter by lazy { BottomAdapter(listener) }

    private val mainAdapter by lazy { MainAdapter(listener) }

    override fun setupViews() {
        with(binding){
            with(mainRecycler){
                adapter = mainAdapter
                layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
            }

            with(bottomRecycler){
                adapter = bottomAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }

    override fun viewModelObservers() {
    }
}