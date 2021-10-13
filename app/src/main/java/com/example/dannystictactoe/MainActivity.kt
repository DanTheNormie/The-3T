package com.example.dannystictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var p1_score:Int = 0
    var p2_score:Int = 0
    var is_p1_turn:Boolean = true
    var p1_score_arr = arrayOf(0,0,0,0,0,0,0,0,0)
    var p2_score_arr = arrayOf(0,0,0,0,0,0,0,0,0)
    var totalcounter = 0
    var is_match_over = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup_board()
    }

    fun reset(view: View) {
        setup_board()
    }

    fun new_game(view:View){


        p1_score = 0
        p2_score = 0
        setup_board()
    }

    private fun setup_board() {

        btn_1.text = ""
        btn_2.text = ""
        btn_3.text = ""
        btn_4.text = ""
        btn_5.text = ""
        btn_6.text = ""
        btn_7.text = ""
        btn_8.text = ""
        btn_9.text = ""

        header_txtvw.text = "Player 1's Turn"
        p1_score_txtvw.text = "P1 : $p1_score"
        p2_score_txtvw.text = "P2 : $p2_score"

        totalcounter = 0
        p1_score_arr = arrayOf(0,0,0,0,0,0,0,0,0)
        p2_score_arr = arrayOf(0,0,0,0,0,0,0,0,0)
        btn_1.isEnabled = true
        btn_2.isEnabled = true
        btn_3.isEnabled = true
        btn_4.isEnabled = true
        btn_5.isEnabled = true
        btn_6.isEnabled = true
        btn_7.isEnabled = true
        btn_8.isEnabled = true
        btn_9.isEnabled = true

        is_match_over = false
    }

    fun on_press(view:View) {

        if (!is_match_over) {

            when (view){

                btn_1 -> {
                    if(is_p1_turn){
                        p1_score_arr[0] = 1
                        btn_1.text = "X"
                    }
                    else{
                        p2_score_arr[0] = 1
                        btn_1.text = "O"
                    }

                }

                btn_2 -> {
                    if(is_p1_turn){
                        p1_score_arr[1] = 1
                        btn_2.text = "X"
                    }
                    else{
                        p2_score_arr[1] = 1
                        btn_2.text = "O"
                    }
                }

                btn_3 -> {
                    if(is_p1_turn){
                        p1_score_arr[2] = 1
                        btn_3.text = "X"
                    }
                    else{
                        p2_score_arr[2] = 1
                        btn_3.text = "O"
                    }
                }

                btn_4 -> {
                    if(is_p1_turn){
                        p1_score_arr[3] = 1
                        btn_4.text = "X"
                    }
                    else{
                        p2_score_arr[3] = 1
                        btn_4.text = "O"
                    }
                }

                btn_5 -> {
                    if(is_p1_turn){
                        p1_score_arr[4] = 1
                        btn_5.text = "X"
                    }
                    else{
                        p2_score_arr[4] = 1
                        btn_5.text = "O"
                    }
                }

                btn_6 -> {
                    if(is_p1_turn){
                        p1_score_arr[5] = 1
                        btn_6.text = "X"
                    }
                    else{
                        p2_score_arr[5] = 1
                        btn_6.text = "O"
                    }
                }

                btn_7 -> {
                    if(is_p1_turn){
                        p1_score_arr[6] = 1
                        btn_7.text = "X"
                    }
                    else{
                        p2_score_arr[6] = 1
                        btn_7.text = "O"
                    }
                }

                btn_8 -> {
                    if(is_p1_turn){
                        p1_score_arr[7] = 1
                        btn_8.text = "X"
                    }
                    else{
                        p2_score_arr[7] = 1
                        btn_8.text = "O"
                    }
                }

                btn_9 -> {
                    if(is_p1_turn){
                        p1_score_arr[8] = 1
                        btn_9.text = "X"
                    }
                    else{
                        p2_score_arr[8] = 1
                        btn_9.text = "O"
                    }
                }
            }

            view.isEnabled = false

            if(is_p1_turn){
                if(Won(p1_score_arr)){
                    header_txtvw.text = "Player 1 WON !!!"
                    p1_score_txtvw.text = "P1 : ${++p1_score}"
                    is_match_over = true
                }
                else{
                    header_txtvw.text = "Player 2's Turn"
                }
            }
            else{
                if(Won(p2_score_arr)){
                    header_txtvw.text = "Player 2 WON !!!"
                    p2_score_txtvw.text = "P2 : ${++p2_score}"
                    is_match_over = true
                }
                else{
                    header_txtvw.text = "Player 1's Turn"

                }
            }

            if (totalcounter == 8 && !is_match_over){
                header_txtvw.text = "Match Draw !!!"
                is_match_over = true
            }

            totalcounter++
            is_p1_turn = !is_p1_turn
        }
    }

    private fun Won(arr: Array<Int>) :Boolean {

        return (arr[0]==1 && arr[1]==1 && arr[2]==1) || //row 1
                (arr[3]==1 && arr[4]==1 && arr[5]==1) || //row 2
                (arr[6]==1 && arr[7]==1 && arr[8]==1) || //row 3
                (arr[0]==1 && arr[3]==1 && arr[6]==1) || //column 1
                (arr[1]==1 && arr[4]==1 && arr[7]==1) || //column 2
                (arr[2]==1 && arr[5]==1 && arr[8]==1) || //column 3
                (arr[0]==1 && arr[4]==1 && arr[8]==1) || //diagonal 1
                (arr[2]==1 && arr[4]==1 && arr[6]==1)
    }
}

