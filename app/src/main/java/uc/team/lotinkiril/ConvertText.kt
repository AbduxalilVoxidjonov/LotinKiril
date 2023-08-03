package uc.team.lotinkiril

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import uc.team.lotinkiril.databinding.FragmentConvertTextBinding

class ConvertText : Fragment() {
  private val binding by lazy { FragmentConvertTextBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        var key = arguments?.getInt("uzbekkiril")
        when(key) {
            0 -> {
                binding.changeText.setOnClickListener{
                    val str = binding.editTextConvert.text.toString()
                    binding.textViewConvert.text=(convetRussian(str))
                }
            }
            1->{
                binding.changeText.setOnClickListener{
                    val str = binding.editTextConvert.text.toString()
                    binding.textViewConvert.text=convertLotin(str)
                }
            }
        }
        return binding.root
    }

    private fun convertLotin(str:String): String {

        val cyrillicToLatinMap = mapOf(
            "а" to "a", "б" to "b", "в" to "v", "г" to "g", "д" to "d", "е" to "e",
            "ё" to "yo", "ж" to "zh", "з" to "z", "и" to "i", "й" to "y", "к" to "k",
            "л" to "l", "м" to "m", "н" to "n", "о" to "o", "п" to "p", "р" to "r",
            "с" to "s", "т" to "t", "у" to "u", "ф" to "f", "х" to "kh", "ц" to "ts",
            "ч" to "ch", "ш" to "sh", "щ" to "sch", "ъ" to "", "ы" to "y", "ь" to "",
            "э" to "e", "ю" to "yu", "я" to "ya",
            "А" to "A", "Б" to "B", "В" to "V", "Г" to "G", "Д" to "D", "Е" to "E",
            "Ё" to "Yo", "Ж" to "Zh", "З" to "Z", "И" to "I", "Й" to "Y", "К" to "K",
            "Л" to "L", "М" to "M", "Н" to "N", "О" to "O", "П" to "P", "Р" to "R",
            "С" to "S", "Т" to "T", "У" to "U", "Ф" to "F", "Х" to "Kh", "Ц" to "Ts",
            "Ч" to "Ch", "Ш" to "Sh", "Щ" to "Sch", "Ъ" to "", "Ы" to "Y", "Ь" to "",
            "Э" to "E", "Ю" to "Yu", "Я" to "Ya"
        )

        val latinString = str.replace(Regex("[а-яА-ЯёЁ]")) {
            cyrillicToLatinMap[it.value] ?: it.value
        }
        return latinString
    }
    private fun convetRussian(str:String): String {
        val latinToCyrillicMap = mapOf(
            "a" to "а", "b" to "б", "c" to "ц", "d" to "д", "e" to "е", "f" to "ф",
            "g" to "г", "h" to "х", "i" to "и", "j" to "й", "k" to "к", "l" to "л",
            "m" to "м", "n" to "н", "o" to "о", "p" to "п", "q" to "к", "r" to "р",
            "s" to "с", "t" to "т", "u" to "у", "v" to "в", "w" to "в", "x" to "кс",
            "y" to "й", "z" to "з",
            "A" to "А", "B" to "Б", "C" to "Ц", "D" to "Д", "E" to "Е", "F" to "Ф",
            "G" to "Г", "H" to "Х", "I" to "И", "J" to "Й", "K" to "К", "L" to "Л",
            "M" to "М", "N" to "Н", "O" to "О", "P" to "П", "Q" to "К", "R" to "Р",
            "S" to "С", "T" to "Т", "U" to "У", "V" to "В", "W" to "В", "X" to "КС",
            "Y" to "Й", "Z" to "З"
        )

        val cyrillicString = str.replace(Regex("[a-zA-Z]")) {
            latinToCyrillicMap[it.value] ?: it.value
        }
        return cyrillicString
    }
}