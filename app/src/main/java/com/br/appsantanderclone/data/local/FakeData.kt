package com.br.appsantanderclone.data.local

import com.br.appsantanderclone.data.Cartao
import com.br.appsantanderclone.data.Cliente
import com.br.appsantanderclone.data.Conta

class FakeData {
    fun getLocalData(): Conta {
        val cliente = Cliente("Bruno")
        val cartao = Cartao("0033")
        return Conta(
            7777,
            "01097954-9",
            1324.64,
            1000.0,
            cliente,
            cartao)
    }
}