package br.com.mateusgomes

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

@RestController
class MathController {

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String,
    ): Double {
        if(isNumeric(numberOne) && isNumeric(numberTwo)){
            return numberOne.toDouble() + numberTwo.toDouble()
        } else {
            throw UnsupportedMathOperationException("Not a number")
        }
    }

    @RequestMapping(value = ["/subtraction/{numberOne}/{numberTwo}"])
    fun subtraction(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String,
    ): Double {
        if(isNumeric(numberOne) && isNumeric(numberTwo)){
            return numberOne.toDouble() - numberTwo.toDouble()
        } else {
            throw UnsupportedMathOperationException("Not a number")
        }
    }

    @RequestMapping(value = ["/multiplication/{numberOne}/{numberTwo}"])
    fun multiplication(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String,
    ): Double {
        if(isNumeric(numberOne) && isNumeric(numberTwo)){
            return numberOne.toDouble() * numberTwo.toDouble()
        } else {
            throw UnsupportedMathOperationException("Not a number")
        }
    }

    @RequestMapping(value = ["/division/{numberOne}/{numberTwo}"])
    fun division(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String,
    ): Double {
        if(isNumeric(numberOne) && isNumeric(numberTwo)){
            return numberOne.toDouble() / numberTwo.toDouble()
        } else {
            throw UnsupportedMathOperationException("Not a number")
        }
    }

    @RequestMapping(value = ["/power/{numberOne}/{numberTwo}"])
    fun power(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String,
    ): Double {
        if(isNumeric(numberOne) && isNumeric(numberTwo)){
            return Math.pow(numberOne.toDouble(), numberTwo.toDouble())
        } else {
            throw UnsupportedMathOperationException("Not a number")
        }
    }

    @RequestMapping(value = ["/squareRoot/{number}"])
    fun squareRoot(
        @PathVariable(value = "number") number: String
    ): Double {
        if(isNumeric(number)){
            return Math.sqrt(number.toDouble())
        } else {
            throw UnsupportedMathOperationException("Not a number")
        }
    }

    @RequestMapping(value = ["/mean/{numberOne}/{numberTwo}"])
    fun mean(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String,
    ): Double {
        if(isNumeric(numberOne) && isNumeric(numberTwo)){
            return (numberOne.toDouble() + numberTwo.toDouble())/2
        } else {
            throw UnsupportedMathOperationException("Not a number")
        }
    }

    private fun isNumeric(strNumber: String): Boolean {
        val number = strNumber.replace(",", ".")
        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
}