package com.example.whatsapplikegavin.Core

import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.SQLException

open class Database {

    private val jdbcUrl = "jdbc:postgresql://46.226.105.92:5442/database_tiw_2023"

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
        println("Connecting to database with URL: $jdbcUrl, user: postgres, password: postgres")

        try {
            // Open a new connection
            DriverManager.getConnection(jdbcUrl, "postgres", "postgres").use { connection ->
                // Prepare the query
                val preparedStatement = connection.prepareStatement(query)

                // Bind the parameters
                params.forEachIndexed { index, param ->
                    preparedStatement.setObject(index + 1, param)
                }

                // Execute the query
                preparedStatement.execute()

                // Return the result
                return preparedStatement
            }
        } catch (e: SQLException) {
            // Handle SQL exceptions more specifically
            e.printStackTrace()
            throw SQLException("Database query error: ${e.message}", e)
        }
    }

}
