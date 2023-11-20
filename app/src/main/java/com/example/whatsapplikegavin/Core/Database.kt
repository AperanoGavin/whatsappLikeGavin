package com.example.whatsapplikegavin.Core

import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.SQLException

open class Database {

    private val jdbcUrl = "jdbc:postgresql://46.226.107.16:5432/database_tiw_2023"

    companion object {
        private var instance: Database? = null

        fun getInstance(): Database {
            if (instance == null) {
                instance = Database()
            }
            return instance!!
        }
    }

    fun query(query: String, params: List<Any> = emptyList()): PreparedStatement {
        try {
            // Open a new connection within a shorter scope
            DriverManager.getConnection(jdbcUrl, "postgres", "postgres").use { connection ->
                val statement: PreparedStatement = connection.prepareStatement(query)

                // Set parameters to the prepared statement
                for ((index, param) in params.withIndex()) {
                    statement.setObject(index + 1, param)
                }

                // Execute the query
                statement.execute()

                // Close the statement (it's also closed when the connection is closed)
                statement.close()

                return statement
            }
        } catch (e: SQLException) {
            // Handle SQL exceptions more specifically
            throw SQLException("Database query error: ${e.message}", e)
        }
    }

}
