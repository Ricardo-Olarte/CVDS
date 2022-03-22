package hangman.model;

public interface GameScore {

    public int CalculatedScore(int correctCount, int incorrectCount);
    int getScore();
}
