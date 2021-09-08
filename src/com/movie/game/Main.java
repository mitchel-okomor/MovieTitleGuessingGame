package com.movie.game;

public class Main {

    public static void main(String[] args) {
        /**
         * Start a new game here and also check if game has ended
         */
        Game newGame = new Game("movies.txt");
        System.out.println("Welcome to the movie guessing game");
        System.out.println("The rules of the game are simple \n " +
                "The computer randomly picks a movie title for you" +
                "figure out the movie by guessing one letter at a time");
        System.out.println("If a letter you chose is in the title the letter and it's correct position will be revealed, \n" +
                "if not, you loose a point ");
        System.out.println("If you loose 10 points, the game is over");
        System.out.println("Lets get started!");
        System.out.println("The movie title have "+  newGame.getMovieTitle().length() + " characters (Including spaces" +
                "and puntuations).");

      while (!newGame.gameEnded()){
          System.out.println(newGame.WonGame());

          System.out.println("You are guessing: " + newGame.getHiddenMovieTitle());
          System.out.println("You have guessed (" + newGame.getWrongLetters().length()/2 + ") wrong letters: "+ newGame.getWrongLetters());
     newGame.guessLetter();
      }

      if(newGame.WonGame()){
          System.out.println("You win!");
          System.out.println("You have guesed " + newGame.getMovieTitle() + " Correctly!" );
      }
      else {
          System.out.println("You have guessed (" + newGame.getWrongLetters().length()/2 + ") Wrong letters:" + newGame.getWrongLetters());
     System.out.println("You lost!");
     System.out.println("The movie title was: "+ newGame.getMovieTitle());
     System.out.println("Better luck next time.");
      }
    }
}
