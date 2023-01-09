package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.experimental.and
import kotlin.experimental.xor

class MainActivity : AppCompatActivity() {
    var tapTimes = 0
    var playerTurn: Byte = 0b0;
    var cells = byteArrayOf(
        0b000000000, 0b000000000, 0b000000000,
        0b000000000, 0b000000000, 0b000000000,
        0b000000000, 0b000000000, 0b000000000,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var display = findViewById<TextView>(R.id.display)
        display.text = "Tapped 0"
    }

    fun setPlayerTurn() {
        playerTurn = playerTurn.xor(0b1);
    }

    fun getPlayerMarker(turn: Byte): String {
        return if (turn === 0b0.toByte()) "O" else "X"
    }

    fun onClick0(view: View) {
        var button = findViewById<TextView>(R.id.button0) as Button
        button.text = getPlayerMarker(playerTurn)
        setPlayerTurn()
    }

    fun onClick1(view: View) {
        var button = findViewById<TextView>(R.id.button1) as Button
        button.text = getPlayerMarker(playerTurn)
        setPlayerTurn()
    }

    fun onClick2(view: View) {
        var button = findViewById<TextView>(R.id.button2) as Button
        button.text = getPlayerMarker(playerTurn)
        setPlayerTurn()
    }

    fun onClick3(view: View) {
        var button = findViewById<TextView>(R.id.button3) as Button
        button.text = getPlayerMarker(playerTurn)
        setPlayerTurn()
    }

    fun onClick4(view: View) {
        var button = findViewById<TextView>(R.id.button4) as Button
        button.text = getPlayerMarker(playerTurn)
        setPlayerTurn()
    }

    fun onClick5(view: View) {
        var button = findViewById<TextView>(R.id.button5) as Button
        button.text = getPlayerMarker(playerTurn)
        setPlayerTurn()
    }

    fun onClick6(view: View) {
        var button = findViewById<TextView>(R.id.button6) as Button
        button.text = getPlayerMarker(playerTurn)
        setPlayerTurn()
    }

    fun onClick7(view: View) {
        var button = findViewById<TextView>(R.id.button7) as Button
        button.text = getPlayerMarker(playerTurn)
        setPlayerTurn()
    }

    fun onClick8(view: View) {
        var button = findViewById<TextView>(R.id.button8) as Button
        button.text = getPlayerMarker(playerTurn)
        setPlayerTurn()
    }
}