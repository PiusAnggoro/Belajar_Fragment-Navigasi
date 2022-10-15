package id.piusanggoro.belajarfragment

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.title = "Dompet DigitalKU"

        val root: View = inflater.inflate(R.layout.fragment_main, container, false)
        root.findViewById<Button>(R.id.btnLihatTransaksi).setOnClickListener {
            it.findNavController()
                .navigate(MainFragmentDirections.actionMainFragmentToViewTransactionFragment2())
        }
        root.findViewById<Button>(R.id.btnCekSaldo).setOnClickListener {
            it.findNavController()
                .navigate(MainFragmentDirections.actionMainFragmentToViewBalanceFragment())
        }

        setHasOptionsMenu(true);
        return root;
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, findNavController())
                || return super.onOptionsItemSelected(item)
    }
}
