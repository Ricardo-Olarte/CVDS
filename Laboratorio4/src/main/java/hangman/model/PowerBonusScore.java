package hangman.model;
import java.lang.Math.*;

public class PowerBonusScore implements GameScore{

    private  int Score;

    /**
     *
     * @param correctCount cantidad de letras correctas de la palabra
     * @param incorrectCount cantidad de letras incorrectas de la palabra
     * @pre  cada parametro deben ser mayor o igual a  0
     * @pos Si (incorrectCount * 8) > 5^correctCount Score = 0 si No Si (5^correctCount) - (incorrectCount * 8) > 500 Score = 500 si No Score = (5^correctCount) - (incorrectCount * 8)
     * @return Score
     */
    @Override
    public int CalculatedScore(int correctCount, int incorrectCount) {
        int Score = 0;

        if((incorrectCount * 8) > Math.pow(5, correctCount)){
            Score = 0;
        }else if((Math.pow(5,correctCount) - (incorrectCount * 8))>500){
            Score = 500;
        }else{
            Score = (int) (Math.pow(5,correctCount) - (incorrectCount * 8));
        }
        return Score;
    }

    @Override
    public int getScore() {
        return Score;
    }
}
