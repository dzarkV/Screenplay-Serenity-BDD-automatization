package com.challenge.questions;

import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.support.Color;

public class CalculateSimilarity {

    private CalculateSimilarity(){
    }

    public static Question<Double> withEuclidianDistance(Color colorCompared, Color validColor){
        return  Question.about("If distance of color is close to " + validColor.asRgb())
                .answeredBy(actor ->
                    Math.sqrt( Math.pow((colorCompared.getColor().getRed() - validColor.getColor().getRed()), 2) +
                    Math.pow((colorCompared.getColor().getGreen() - validColor.getColor().getGreen()), 2) +
                    Math.pow((colorCompared.getColor().getBlue() - validColor.getColor().getBlue()), 2))
        );
    }

}
