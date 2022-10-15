package id.piusanggoro.belajarfragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import id.piusanggoro.belajarfragment.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _fragmentMainBinding: FragmentMainBinding? = null
    private val fragmentMainBinding get() = _fragmentMainBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.title = "Dompet DigitalKU"

        _fragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false)
        val view = fragmentMainBinding.root

        fragmentMainBinding.btnLihatTransaksi.setOnClickListener{
            view.findNavController().navigate(MainFragmentDirections.actionMainFragmentToViewTransactionFragment2())
        }
        fragmentMainBinding.btnCekSaldo.setOnClickListener{
            view.findNavController().navigate(MainFragmentDirections.actionMainFragmentToViewBalanceFragment())
        }

        setHasOptionsMenu(true);
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, findNavController())
                || return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        _fragmentMainBinding = null
        super.onDestroyView()
    }
}