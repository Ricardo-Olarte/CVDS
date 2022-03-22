package hangman.model;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class GameScoreTest {

    GameScore prueba;

    /**
     * Clases de Equivalencia de OriginalScore
     * 1. incorrectCount < 11 -> Score - 10 * incorrectCount
     * 2. incorrectCount >= 11 -> Score = 0
     * Frontera: 0 <= OriginalScore <= 100
     */
    @Test
    public void validateOriginalScore1(){
        prueba = new OriginalScore();
        int result = prueba.CalculatedScore(0,0);
        Assert.assertEquals(result, 100);
    }

    @Test
    public void validateOriginalScore2(){
        prueba = new OriginalScore();
        int result = prueba.CalculatedScore(0,10);
        Assert.assertEquals(result, 0);
    }

    @Test
    public void validateOriginalScore3(){
        prueba = new OriginalScore();
        int result = prueba.CalculatedScore(0,11);
        Assert.assertEquals(result, 0);
    }

    @Test
    public void validateOriginalScore4(){
        prueba = new OriginalScore();
        int result = prueba.CalculatedScore(0,5);
        Assert.assertEquals(result, 50);
    }

    /**
     * Clases de Equivalencia de BonusScore
     * 1. incorrectCount < 2 * (correctCount) -> Score + 10 * correctCount - 5 * incorrectCount
     * 2. incorrectCount >= 2 * (correctCount) -> Score = 0
     * Frontera: BonusScore >= 0
     */
    @Test
    public void validateBonusScore1(){
        prueba = new BonusScore();
        int result = prueba.CalculatedScore(0,0 );
        Assert.assertEquals(result, 0);
    }

    @Test
    public void validateBonusScore2(){
        prueba = new BonusScore();
        int result = prueba.CalculatedScore(5,11 );
        Assert.assertEquals(result, 0);
    }

    @Test
    public void validateBonusScore3(){
        prueba = new BonusScore();
        int result = prueba.CalculatedScore(10,5 );
        Assert.assertEquals(result, 75);
    }


    /**
     * Clases de Equivalencia de PowerScore
     * 1. (incorrectCount * 8) < 5^correctCount -> Score + 5^correctCount - incorrectCount * 8
     * 2. (incorrectCount * 8) >= 5^correctCount -> Score = 0
     * 3. (Score + 5^correctCount - incorrectCount * 8) > 500 -> Score = 500
     * Frontera: 0<=PowerScore<=500
     */
    @Test
    public void validatePowerBonusScore1(){
        prueba = new PowerBonusScore();
        int result = prueba.CalculatedScore(0,0);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void validatePowerBonusScore2(){
        prueba = new PowerBonusScore();
        int result = prueba.CalculatedScore(10032032,10);
        Assert.assertEquals(result, 500);
    }

    @Test
    public void validatePowerBonusScore3(){
        prueba = new PowerBonusScore();
        int result = prueba.CalculatedScore(2,8);
        Assert.assertEquals(result, 0);
    }

    @Test
    public void validatePowerBonusScore4(){
        prueba = new PowerBonusScore();
        int result = prueba.CalculatedScore(3,8);
        Assert.assertEquals(result, 61);
    }
}
