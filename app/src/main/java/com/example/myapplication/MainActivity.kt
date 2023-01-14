package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.Timer
import kotlin.concurrent.schedule
import kotlin.experimental.xor

class MainActivity : AppCompatActivity() {
    private var playerTurn: Byte = 0b0
    private var player0 = byteArrayOf(
        0b0, 0b0, 0b0,
        0b0, 0b0, 0b0,
        0b0, 0b0, 0b0,
    )
    private var player1 = byteArrayOf(
        0b0, 0b0, 0b0,
        0b0, 0b0, 0b0,
        0b0, 0b0, 0b0,
    )

    private val wins = byteArrayOf(
        0b111000000.toByte(),
        0b000111000.toByte(),
        0b000000111.toByte(),
        0b100100100.toByte(),
        0b010010010.toByte(),
        0b001001001.toByte(),
        0b100010001.toByte(),
        0b001010100.toByte()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val display = findViewById<TextView>(R.id.display)
        display.text = "Tapped 0"
        resetCells()
    }

    private fun resetCells () {
        findViewById<TextView>(R.id.button0).text = ""
        findViewById<TextView>(R.id.button1).text = ""
        findViewById<TextView>(R.id.button2).text = ""
        findViewById<TextView>(R.id.button3).text = ""
        findViewById<TextView>(R.id.button4).text = ""
        findViewById<TextView>(R.id.button5).text = ""
        findViewById<TextView>(R.id.button6).text = ""
        findViewById<TextView>(R.id.button7).text = ""
        findViewById<TextView>(R.id.button8).text = ""
    }

    private fun setPlayerTurn() {
        playerTurn = playerTurn.xor(0b1)
    }

    private fun getPlayerMarker(turn: Byte): String {
        return if (turn == 0b0.toByte()) "O" else "X"
    }

    private fun setCell(index: Int) {
        if (playerTurn == 0b0.toByte())
            player0[index] = 0b1
        else
            player1[index] = 0b1
    }

    private fun checkWinnerOrFinish() {
        var win = false
        val joined0 = player0.reduce{ acc, curr -> ((acc.toInt() shl 1) or curr.toInt()).toByte() }
        val joined1 = player1.reduce{ acc, curr -> ((acc.toInt() shl 1) or curr.toInt()).toByte() }
        val joined = if (playerTurn == 0b0.toByte()) joined0 else joined1


        for (check in wins) {
            if (check == joined) {
                win = true
                break
            }
        }

        if (win) {
            val display = findViewById<TextView>(R.id.display)
            display.text = "${getPlayerMarker(playerTurn)} won"
            Timer().schedule(3000) {
                resetCells()
            }
        } else if ((joined1.toInt() or joined0.toInt()) == -1) {
            val display = findViewById<TextView>(R.id.display)
            display.text = "Deu velha"
            Timer().schedule(3000) {
                resetCells()
            }
        } else setPlayerTurn()
    }

    fun onClick0(view: View) {
        val button = view as Button
        if (button.text != "") return

        setCell(0)
        button.text = getPlayerMarker(playerTurn)
        checkWinnerOrFinish()
    }

    fun onClick1(view: View) {
        val button = view as Button
        if (button.text != "") return

        setCell(1)
        button.text = getPlayerMarker(playerTurn)
        checkWinnerOrFinish()
    }

    fun onClick2(view: View) {
        val button = view as Button
        if (button.text != "") return

        setCell(2)
        button.text = getPlayerMarker(playerTurn)
        checkWinnerOrFinish()
    }

    fun onClick3(view: View) {
        val button = view as Button
        if (button.text != "") return

        setCell(3)
        button.text = getPlayerMarker(playerTurn)
        checkWinnerOrFinish()
    }

    fun onClick4(view: View) {
        val button = view as Button
        if (button.text != "") return

        setCell(4)
        button.text = getPlayerMarker(playerTurn)
        checkWinnerOrFinish()
    }

    fun onClick5(view: View) {
        val button = view as Button
        if (button.text != "") return

        setCell(5)
        button.text = getPlayerMarker(playerTurn)
        checkWinnerOrFinish()
    }

    fun onClick6(view: View) {
        val button = view as Button
        if (button.text != "") return

        setCell(6)
        button.text = getPlayerMarker(playerTurn)
        checkWinnerOrFinish()
    }

    fun onClick7(view: View) {
        val button = view as Button
        if (button.text != "") return

        setCell(7)
        button.text = getPlayerMarker(playerTurn)
        checkWinnerOrFinish()
    }

    fun onClick8(view: View) {
        val button = view as Button
        if (button.text != "") return

        setCell(8)
        button.text = getPlayerMarker(playerTurn)
        checkWinnerOrFinish()
    }
}


