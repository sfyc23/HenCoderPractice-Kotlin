package com.github.sfyc23.hencoderpractice.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.github.sfyc23.hencoderpractice.R
import com.github.sfyc23.hencoderpractice.dialog.MessageDialog
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity() {

    private var mFragment: Fragment? = null
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = find<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)


        drawerLayout = find<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = find<NavigationView>(R.id.nav_view)
        setupDrawerContent(navigationView)
//        navigationView.setCheckedItem(R.id.nav_main)
//        selectFragment(R.id.nav_main)
        navigationView.setCheckedItem(R.id.nav_draw_basal)
        selectFragment(R.id.nav_draw_basal)

    }



    override fun onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setupDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawers()
            selectFragment(it.itemId)
            true
        }
    }

    var tabFragment: TabFragment? = null

    private fun selectFragment(fragmentId: Int) {
        when (fragmentId) {
            R.id.nav_github -> {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://github.com/sfyc23/HenCoderPractice-Kotlin")
                startActivity(Intent.createChooser(intent, getString(R.string.intent_chooser)))
                return
            }
            R.id.nav_about -> {
                MessageDialog.newInstance(
                        R.drawable.ic_info_grey600_24dp,
                        getString(R.string.about_title),
                        getString(R.string.about_body),
                        null
                ).show(fragmentManager, MessageDialog.TAG)
                return
            }
            else ->{
                mFragment = TabFragment.newInstance(fragmentId)
                supportFragmentManager.beginTransaction().replace(R.id.contentFrame, mFragment).commit()
            }
        }

    }

}
