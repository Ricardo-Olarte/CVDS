package hangman.model;

public class OriginalScore implements GameScore{

    private  int Score;

    /**
     *
     * @param correctCount cantidad de letras correctas de la palabra
     * @param incorrectCount cantidad de letras incorrectas de la palabra
     * @pre  cada parametro deben ser mayor o igual a  0
     * @pos Si incorrectCount menor o igual a 10 [Score = 100 - (incorrectCount * 10)] si No Score = 0
     * @return Score
     */
    @Override
    public int CalculatedScore(int correctCount, int incorrectCount) {
        int Score = 100;
        if(incorrectCount >= 11){
            Score = 0;
        }else{
            Score -= incorrectCount * 10;
        }
        return Score;
    }

    @Override
    public int getScore() {
        return Score;
    }
}
