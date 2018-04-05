package br.rpm.call.list.main.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.rpm.call.list.R
import br.rpm.call.list.main.MainView
import br.rpm.call.list.presenter.MainPresenter
import br.rpm.call.list.presenter.impl.MainPresenterImpl
import kotlinx.android.synthetic.main.act_main.*

class MainActivity : AppCompatActivity(), MainView {

    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)
        setSupportActionBar(toolbar)

        presenter = MainPresenterImpl(this)

        fab.setOnClickListener { _ ->
            presenter.onFabClick(this)
        }
    }
}
