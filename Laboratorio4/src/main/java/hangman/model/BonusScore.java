package hangman.model;

public class BonusScore implements GameScore{

    private  int Score;

    /**
     *
     * @param correctCount cantidad de letras correctas de la palabra
     * @param incorrectCount cantidad de letras incorrectas de la palabra
     * @pre  cada parametro deben ser mayor o igual a  0
     * @pos Si incorrectCount > 2 * (correctCount) Score = 0 si No Score = (correctCount * 10) - (5 * incorrectCount)
     * @return Score
     */
    @Override
    public int CalculatedScore(int correctCount, int incorrectCount) {
        int Score = 0;

        if(incorrectCount > 2 * (correctCount)){
            Score = 0;
        }else{
            Score = (correctCount * 10) - (5 * incorrectCount);
        }
        return Score;
    }

    @Override
    public int getScore() {
        return Score;
    }
}
