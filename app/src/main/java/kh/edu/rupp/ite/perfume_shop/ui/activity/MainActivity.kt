package kh.edu.rupp.ite.perfume_shop.ui.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kh.edu.rupp.ite.perfume_shop.R
import kh.edu.rupp.ite.perfume_shop.databinding.ActivityMainBinding
import kh.edu.rupp.ite.perfume_shop.ui.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);
        viewFragment(HomeFragment());
    }
    private fun viewFragment(fragment:Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.lytFragment,fragment);
        fragmentTransaction.commit();
    }

}