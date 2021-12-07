package com.br.appsantanderclone.data

data class Conta(
    val agencia: Int,
    val numero: String,
    val saldo: Double,
    val limite: Double,
    val cliente: Cliente,
    val cartao: Cartao
)
