package com.lista1.zad1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RadioGroup
import android.widget.RadioButton
import androidx.cardview.widget.CardView
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val QuestionText: TextView by lazy { findViewById(R.id.QuestionText) }
    private val ProgressBar: ProgressBar by lazy { findViewById(R.id.QuestionProgressBar) }
    private val RG: RadioGroup by lazy { findViewById(R.id.RadioGroup) }
    private val A: RadioButton by lazy { findViewById(R.id.A) }
    private val B: RadioButton by lazy { findViewById(R.id.B) }
    private val C: RadioButton by lazy { findViewById(R.id.C) }
    private val D: RadioButton by lazy { findViewById(R.id.D) }
    private val NextButton: Button by lazy { findViewById(R.id.NextButton)}

    private val TAG = "MyActivity"
    private val QuestionNumber: TextView by lazy { findViewById(R.id.QuestionNumber) }
    private var QuestionCout = 1
    private var points = 0
    private var answer = ""

    var QuestionTable = arrayOf (
        arrayOf("Ostatni litera w greckim alfabecie to...","alfa","gamma","zeta","omega",
            "omega"),
        arrayOf("Witamina C to...","kwas acetylosalicylowy","kwas askorbinowy","kwas azelainowy","kwas alfa-liponowy",
            "kwas askorbinowy"),
        arrayOf("W którym województwie leży Kołobrzeg?","pomorskim","zachodniopomorskim","warmińsko-mazurskim","kujawsko-pomorskim",
            "zachodniopomorskim"),
        arrayOf("Brylant to oszlifowany...","szafir","topaz","diament","akwamaryn",
            "diament"),
        arrayOf("Jak nazywa się piąty znak zodiaku?","Bliźnięta","Rak","Lew","Panna",
            "Lew"),
        arrayOf("Najwyższy szczyt Karkonoszy to...","Tarnica","Rysy","Babia Góra","Śnieżka",
            "Śnieżka"),
        arrayOf("Jaka barwa powstanie z połączenia czerwonego i niebieskiego?","brązowy","fioletowy","różowy","adna z wymienionych",
            "fioletowy"),
        arrayOf("Które z wymienionych z botanicznego punktu widzenia jest owocem?","pomidor", "cukinia","bakłażan","wszystkie wymienione",
            "wszystkie wymienione"),
        arrayOf("Który produkt zawiera najwięcej tłuszczu w 100g?","banan","awokado","jajko","tuńczyk świeży",
            "awokado"),
        arrayOf("Jednostką czego jest amper?","prądu elektrycznego","pracy","światłości","masy",
            "prądu elektrycznego")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        QuestionNumber.text = "Pytanie: " + QuestionCout + "/10"
        QuestionText.text = QuestionTable[QuestionCout-1][0].toString()
        A.text = QuestionTable[QuestionCout-1][1].toString()
        B.text = QuestionTable[QuestionCout-1][2].toString()
        C.text = QuestionTable[QuestionCout-1][3].toString()
        D.text = QuestionTable[QuestionCout-1][4].toString()

        NextButton.setOnClickListener{
            if (answer == QuestionTable[QuestionCout - 1][5]) {
                Log.i(TAG,"+10");
                points += 10
            }
            if(QuestionCout <= 9) {

                Log.i(TAG,answer);
                Log.i(TAG,QuestionTable[QuestionCout - 1][5]);
                QuestionCout++
                QuestionNumber.text = "Pytanie:" + QuestionCout + "/10"
                QuestionText.text = QuestionTable[QuestionCout - 1][0].toString()
                A.text = QuestionTable[QuestionCout - 1][1].toString()
                B.text = QuestionTable[QuestionCout - 1][2].toString()
                C.text = QuestionTable[QuestionCout - 1][3].toString()
                D.text = QuestionTable[QuestionCout - 1][4].toString()


                ProgressBar.progress++
                RG.clearCheck()

            }
            else{
                endQuiz()
            }

        }

        A.setOnClickListener{
            answer = A.text.toString()
        }
        B.setOnClickListener{
            answer = B.text.toString()
        }
        C.setOnClickListener{
            answer = C.text.toString()
        }
        D.setOnClickListener{
            answer = D.text.toString()
        }
    }

    fun endQuiz()
    {
        QuestionNumber.text = "Gratulacje"
        ProgressBar.visibility = View.GONE
        A.visibility = View.GONE
        B.visibility = View.GONE
        C.visibility = View.GONE
        D.visibility = View.GONE
        QuestionText.text = "Twój wynik " + points + " punktów"
        NextButton.visibility = View.GONE
    }

}