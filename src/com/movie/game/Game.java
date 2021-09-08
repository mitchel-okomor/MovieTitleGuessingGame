package com.movie.game;


import java.util.Scanner;

public class Game {

private  String movieToGuess;
private int pointsLost;
private String wrongLetters;
private String rightLetters;
private boolean gameWon;


public Game (String pathname){
    MovieList movieList = new MovieList(pathname);
    movieToGuess = movieList.getRandomMovie();
    pointsLost = 0;
    rightLetters = "";
    wrongLetters = "";
    gameWon = false;
}

public String getMovieTitle(){
    return movieToGuess;
}

    public String getWrongLetters (){
        return wrongLetters;
    }
    public boolean WonGame(){
        return gameWon;
    }


    /**
     * mask and and also unmask characters here when user guess a character right
     * @return
     */
    public String getHiddenMovieTitle (){
    if(rightLetters.equals("")){
        return  movieToGuess.replaceAll("[a-zA-Z]", "_");
    }else {
        return movieToGuess.replaceAll("[a-zA-Z&&[^"+ rightLetters + "]]", "_");
    }
}

    /**
     * Count number of tries to end the game
     * or check if there are no more masked characters to declare win
     * @return
     */
    public boolean gameEnded(){
    if(pointsLost >= 10){
        return true;
    }
    if (!getHiddenMovieTitle().contains("_")){
        gameWon = true;
        return true;
    }
    return  false;
}

    /**
     * Collect user character input
     * @return letter
     */
    private String  inputLetter(){
    System.out.println("Guess a letter");
    Scanner scanner = new Scanner(System.in);
    String letter = scanner.nextLine().toLowerCase();

    if(!letter.matches("[a-z]")){
        System.out.println("That is not a letter");
        return inputLetter();
    }else {
        return letter;
    }

}

    /**
     * Handle user guesses
     * if it's in the movie add it to the rightLetters variable
     * but if it's wrong add it to the wrongLetters variable
     * keep counts of the point lost
     * and also call gameEnded method to keep track of the game
     *
     */
    public void  guessLetter(){
    String guessedLetter = inputLetter();
    if(movieToGuess.toLowerCase().contains(guessedLetter)){
        rightLetters += guessedLetter + guessedLetter.toUpperCase();
    }else {
        pointsLost++;
        wrongLetters += " " + guessedLetter;
    }
    gameEnded();

}

}
