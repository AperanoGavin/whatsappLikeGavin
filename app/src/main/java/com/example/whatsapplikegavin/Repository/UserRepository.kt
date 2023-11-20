package com.example.whatsapplikegavin.Repository

import com.example.whatsapplikegavin.Core.Database
import java.sql.PreparedStatement


class UserRepository : Database() {


    fun findAll(): PreparedStatement {
        val query = "SELECT * FROM tiw_users"
        val params = emptyList<Any>()
        return query(query, params)

    }

}