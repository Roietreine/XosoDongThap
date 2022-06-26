package rich.igop.dongthapp.fragments

import rich.igop.dongthapp.data.DataModel
import rich.igop.dongthapp.R
import rich.igop.dongthapp.base.BaseFragment
import rich.igop.dongthapp.binding.viewBinding
import rich.igop.dongthapp.databinding.FragmentDetailsBinding

class DetailsFragment(
    private val data: DataModel
): BaseFragment<FragmentDetailsBinding>(R.layout.fragment_details) {

    override val binding: FragmentDetailsBinding by viewBinding(FragmentDetailsBinding::bind)

    override fun setupViews() {
        with(binding){
            banner.setBackgroundResource(data.image)
            menuTitle.text = data.title
            textContent.text = data.desc
            backButton.setOnClickListener { requireActivity().onBackPressed() }
        }
    }

    override fun viewModelObservers() {  }
}