package com.movie.game;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieList {

    //initialize a list to hold  movies tiltes
    private ArrayList <String> movies;


    /**
     * get each movie title and add to the movies list
     * @param pathName
     */
    public MovieList(String pathName) {
        movies =new ArrayList();
        File file = new File("movies.txt");

        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
               movies.add(scanner.nextLine());
            }
        }catch(FileNotFoundException exception){
            System.out.println("File not fount");
        }
    }

    /**
     * get a random movie title from the list
     * @return
     */
    public String getRandomMovie(){

        int index = (int) (Math.random() * movies.size() +1);
        System.out.println(index
        );
        return  movies.get(index);
    }
}
