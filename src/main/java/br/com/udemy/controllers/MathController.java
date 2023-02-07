package br.com.udemy.controllers;

import br.com.udemy.exceptions.ResourceNotFoundException;
import br.com.udemy.math.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static br.com.udemy.utils.NumberConverter.covertToDouble;
import static br.com.udemy.utils.NumberConverter.isNumeric;

@RestController
public class MathController {

    private final SimpleMath math = new SimpleMath();

    //O que é PathVariable: ela usada para recuperar dados do URL,
    // permite que nossso controle lido requisicoes personalisadas

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
    method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
            )throws Exception{

        if(!isNumeric(numberOne) || isNumeric(numberTwo)){
            throw new ResourceNotFoundException("Please set a numeric value !");
        }
        return math.sum(covertToDouble(numberOne), covertToDouble(numberTwo));
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double subtraction(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception{

        if(!isNumeric(numberOne) || isNumeric(numberTwo)){
            throw new ResourceNotFoundException("Please set a numeric value !");
        }
        return math.subtraction(covertToDouble(numberOne), covertToDouble(numberTwo));
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double multiplication(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception{

        if(!isNumeric(numberOne) || isNumeric(numberTwo)){
            throw new ResourceNotFoundException("Please set a numeric value !");
        }
        return math.multiplication(covertToDouble(numberOne), covertToDouble(numberTwo));
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double division(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception{

        if(!isNumeric(numberOne) || isNumeric(numberTwo)){
            throw new ResourceNotFoundException("Please set a numeric value !");
        }
        return math.division(covertToDouble(numberOne), covertToDouble(numberTwo));
    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double mean(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception{

        if(!isNumeric(numberOne) || isNumeric(numberTwo)){
            throw new ResourceNotFoundException("Please set a numeric value !");
        }
        return math.mean(covertToDouble(numberOne), covertToDouble(numberTwo));
    }

    @RequestMapping(value = "/squareRoot/{number}",
            method = RequestMethod.GET)
    public Double squareRoot(
            @PathVariable(value = "number") String number
    )throws Exception{

        if(!isNumeric(number)){
            throw new ResourceNotFoundException("Please set a numeric value !");
        }
        return math.squareRoot(covertToDouble(number));
    }


}
