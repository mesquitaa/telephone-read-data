package br.rpm.call.list.main.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import br.rpm.call.list.R
import br.rpm.call.list.main.MainView
import br.rpm.call.list.main.adapter.CallDetailAdapter
import br.rpm.call.list.model.CallDetail
import br.rpm.call.list.presenter.MainPresenter
import br.rpm.call.list.presenter.impl.MainPresenterImpl
import kotlinx.android.synthetic.main.act_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), MainView {

    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)
        setSupportActionBar(toolbar)

        presenter = MainPresenterImpl(this)

        recycleView?.itemAnimator = DefaultItemAnimator()
        recycleView?.layoutManager = LinearLayoutManager(this)
        recycleView?.adapter = CallDetailAdapter()

        fab.setOnClickListener { _ ->
            presenter.onFabClick(this)
        }
    }

    override fun fillData(list: List<CallDetail>) {
        (recycleView?.adapter as CallDetailAdapter).addAll(list)
    }
}
