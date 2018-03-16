package google.badparcelableexception

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife

class RootActivity : AppCompatActivity() {

    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar
    @BindView(R.id.view_pager)
    lateinit var viewPager: ViewPager
    @BindView(R.id.tab_layout)
    lateinit var tabLayout: TabLayout

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)
        ButterKnife.bind(this)
        setSupportActionBar(toolbar)

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        viewPagerAdapter.addFragment(FragmentOne(), "One")
        viewPagerAdapter.addFragment(FragmentTwo(), "Two")
        viewPagerAdapter.addFragment(FragmentThree(), "Three")
        viewPagerAdapter.addFragment(FragmentFour(), "Four")


        viewPager.adapter = viewPagerAdapter
        viewPager.offscreenPageLimit = 1
        tabLayout.setupWithViewPager(viewPager)
    }
}
