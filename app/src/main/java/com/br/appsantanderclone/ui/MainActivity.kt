package com.br.appsantanderclone.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.appsantanderclone.R
import com.br.appsantanderclone.data.Conta
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import com.br.appsantanderclone.data.Pix


class MainActivity : AppCompatActivity() {

    /*
      val pessoaList: MutableList<Pessoa> = mutableListOf(
            Pessoa("Adérito Tibiriçá", "atibirica@email.com", "1111-1111"),
            Pessoa("Cleiton Siqueira ", "csiqueira@email.com", "2222-2222"),
            Pessoa("Carlos Proença", "cproenca@email.com", "3333-3333"),
            Pessoa("Filipe Valadão", "fvaladao@email.om", "4444-4444"),
            Pessoa("Flávio Noite", "fnoite@email.com", "5555-5555"),
            Pessoa("Gisela Siebra", "gsiebra@email.com", "6666-6666"),
            Pessoa("Marco Lousã", "mlousa@email.com", "7777-7777"),
            Pessoa("Miriam Tabosa", "mtabosa@email.com", "8888-8888"),
            Pessoa("Rufus Ramírez", "rramirez@email.com", "9999-9999"),
            Pessoa("Socorro Cabreira", "scabreira@email.com", "1010-1010")
    )

    lateinit var pessoaAdapter: PessoaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        pessoaAdapter = PessoaAdapter(this, pessoaList)
        recyclerViewPessoas.adapter = pessoaAdapter
        recyclerViewPessoas.layoutManager = LinearLayoutManager(this)
        recyclerViewPessoas.smoothScrollToPosition(pessoaList.size)
    }
     */

    //val imagePix = findViewById<ImageView>(R.id.iv_pix)
   // val imagePagar = findViewById<ImageView>(R.id.iv_pagar)
   // val imageTransferir = findViewById<ImageView>(R.id.iv_transferir)
   // val imageRecarga = findViewById<ImageView>(R.id.iv_recarga)
   // val imageCobrar = findViewById<ImageView>(R.id.iv_cobrar)

    val pixList = mutableListOf(
        Pix("Pix", R.drawable.ic_pix),
        Pix("Pagar", R.drawable.ic_payment),
        Pix("Transferir", R.drawable.ic_transfer),
        Pix("Recarga", R.drawable.ic_mobile),
        Pix("Cobrar", R.drawable.ic_payment)
    )

    lateinit var pixAdapter: PixAdapter


    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()
        toolbarActions()

        pixAdapter = PixAdapter(this, pixList)
        recyclercardview.adapter = pixAdapter
        //recyclercardview.layoutManager = LinearLayoutManager(this)
        //recyclercardview.smoothScrollToPosition(pixList.size)
        recyclercardview.hasFixedSize()

    }

    private fun buscarContaCliente() {
        mainViewModel.buscarContaCliente().observe(this, Observer { result ->
            bindOnView(result)
            //Log.d("Agencia ->", result.agencia.toString())
        })
    }

    private fun bindOnView(conta: Conta) {

        val dec =
            DecimalFormat("RS #,###.00") //2 casas decimais no final separado milhar "." e decimais ","

        findViewById<TextView>(R.id.tv_usuario).text = "Olá, ${conta.cliente.nome}"
        findViewById<TextView>(R.id.tv_agencia).text = "Ag ${conta.agencia.toString()}"
        findViewById<TextView>(R.id.tv_conta_corrente).text = "Cc ${conta.numero}"
        findViewById<TextView>(R.id.tv_saldo).text = dec.format(conta.saldo).toString()
        findViewById<TextView>(R.id.tv_saldo_limite_value).text =
            dec.format((conta.saldo + conta.limite)).toString()
        findViewById<TextView>(R.id.btn_cartao_final).text =
            "Cartão final ${conta.cartao.numeroCartao}"
    }

    private fun showToast(message: String) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.notifications_menu, menu)
        return true
    }

    private fun toolbarActions() {
        val toolbar: MaterialToolbar = findViewById(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            showToast("Menu")
        }

        toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.notifications -> {
                    val intent: Intent = Intent(this, NotificationActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

    }


/*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.notifications -> {
                showToast("Notificações")
                true
            }else -> super.onOptionsItemSelected(item)
        }
    }

 */

}