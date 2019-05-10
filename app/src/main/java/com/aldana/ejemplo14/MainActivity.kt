package com.aldana.ejemplo14

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.aldana.ejemplo14.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = DataBindingUtil.setContentView(this, R.layout.activity_main) as ActivityMainBinding







        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)


        binding.scoreTeam = scoreViewModel

        val puntosAObserver = Observer<Int> { newInt ->

            tv_score_team_a.text = newInt.toString()
        }
        val puntosBObserver = Observer<Int> { newInt ->

            tv_score_team_b.text = newInt.toString()
        }

        scoreViewModel.currentScoreA.observe(this, puntosAObserver)
        scoreViewModel.currentScoreB.observe(this,puntosBObserver)



        // TODO: El ViewModel es restaurado si ya existía, si no, se crea uno nuevo.
        // TODO: Recuerde que el ViewModel solo sobrevive a cambios de configuración y no a la destrucción de la aplicación

    }


    // TODO: Accediendo y modificando datos almacenados en el ViewModel según el método utilizado

    fun addOneTeamA(v: View) {
        scoreViewModel.scoreTeamA += 1
        scoreViewModel.currentScoreA.value = scoreViewModel.scoreTeamA

    }

    fun addOneTeamB(v: View) {
        scoreViewModel.scoreTeamB += 1
        scoreViewModel.currentScoreB.value = scoreViewModel.scoreTeamB

    }

    fun addTwoTeamA(v: View) {
        scoreViewModel.scoreTeamA += 2
        scoreViewModel.currentScoreA.value = scoreViewModel.scoreTeamA

    }

    fun addTwoTeamB(v: View) {
        scoreViewModel.scoreTeamB += 2
        scoreViewModel.currentScoreB.value = scoreViewModel.scoreTeamB


    }

    fun addThreeTeamA(v: View) {
        scoreViewModel.scoreTeamA += 3
        scoreViewModel.currentScoreA.value = scoreViewModel.scoreTeamA

    }

    fun addThreeTeamB(v: View) {
        scoreViewModel.scoreTeamB += 3
        scoreViewModel.currentScoreB.value = scoreViewModel.scoreTeamB

    }

    fun resetScores(v: View) {
        scoreViewModel.scoreTeamB = 0
        scoreViewModel.currentScoreB.value = scoreViewModel.scoreTeamB

        scoreViewModel.scoreTeamA = 0
        scoreViewModel.currentScoreA.value = scoreViewModel.scoreTeamA

    } // TODO: Limpiando datos



}
