package com.example.whatsapplikegavin.Repository

import com.example.whatsapplikegavin.Core.Database
import java.sql.PreparedStatement


class UserRepository : Database() {

    private var database: Database
    init {
        database = Database.getInstance()
    }

    fun findAll(): PreparedStatement {
        val query = "SELECT * FROM tiw_users"
        val params = emptyList<Any>()
        return database.query(query, params)

    }

}