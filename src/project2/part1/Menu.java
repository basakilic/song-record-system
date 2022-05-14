package project2.part1;

import java.util.Scanner;
import project2.part1.BST.GenericArray;
import project2.part1.BST.SongSearchDS;
import project2.part1.Song.Artist;
import project2.part1.Song.Genre;
import project2.part1.Song.IdInterval;
import project2.part1.Song.Song;

public class Menu {
    
    public Menu() {
    }
    
    public void intro(){
        System.out.print("-------------------------------------\n"
                + "Welcome to Music Song Record System !\n"
                + "-------------------------------------\n"
                + "In our Record System, users can search, insert and remove songs.\n"
                + "Also there are some special features for searching songs.\n"
                + "   ->User can search songs according to artist name, song name or song id.\n"
                + "   ->User can list the songs with same genres .\n"
                + "   ->User can listt the songs by choosing the interval of song id's.\n");
        menu();
    }
        SongSearchDS songSearch = new SongSearchDS("songs.txt");
        GenericArray<Song> songsFromFile = new GenericArray<Song>();
        
        public void menu() {
        Scanner input = new Scanner(System.in);
        System.out.print("-------------------------------------\n"
                + "1. Search a song \n"
                + "2. Insert a song \n"
                + "3. Remove a song \n"
                + "4. List songs with interval \n"
                + "5. List songs with genres \n"
                + "6. Quit \n"
                + "Choose the option that you want:");
        
        int option = input.nextInt();
        while (true) {
            if (option == 6) {
                System.out.println("You choose to quit, GOODBYE.");
                break;
            }
            if (option == 1) {
                System.out.println("You choose to search option, avaliable options are: ");
                System.out.println("-------------------------------------\n"
                + "1. ARTIST NAME SEARCH \n"
                + "2. SONG NAME SEARCH \n"
                + "3. SONG ID SEARCH \n");
                System.out.print("Enter your choice: ");
                int choice=input.nextInt();
                switch(choice){
                    case 1:
                            System.out.print("Enter artist name: ");
                            String artistName = input.next();
                            Artist artistObje = new Artist(artistName);
                            System.out.println(songSearch.search(artistObje));
                            menu();
                        return ;
                    case 2:
                            System.out.print("Enter song name: ");
                            String songName = input.next();
                            System.out.println(songSearch.search(songName));
                            menu();
                        return ;
                    case 3:
                            System.out.print("Enter song id: ");
                            int songId = input.nextInt();
                            songSearch.search(songId);
                            System.out.println(songSearch.search(songId));
                            menu();
                    return ;
                default:
                    System.out.println("Input is not valid, sending back to the main menu !!!");
                    break ;   
                }
                
            } else if (option == 2) {
                System.out.println("You choose to insert a song !");
                System.out.print("Enter song name: ");
                String songName=input.next();
                System.out.print("Enter artist name: ");
                String artistName= input.next();
                System.out.print("Enter song id: ");
                int songId=input.nextInt();
                System.out.print("Enter genre of song: ");
                String genre=input.next();
                System.out.print("Enter year of song: ");
                int year=input.nextInt();
                Song newSong = new Song(songName,artistName,songId,genre,year);
                songSearch.insert(newSong);
                System.out.println("-------------------------------------");
                System.out.println("New song is created successfully ! ");
                
            } else if (option==3){
                System.out.print("You choose to remove song, please enter id:  ");
                int indexId = input.nextInt();
                //songSearch.remove(indexId);
                System.out.println("-------------------------------------");
                System.out.println("Chosen song is removed successfully ! ");
                
            }else if(option==4){
                System.out.println("You choose to list songs with id interval.");
                System.out.print("Enter starting id: ");
                int startingId = input.nextInt();
                System.out.print("Enter ending id: ");
                int endingId = input.nextInt();
                IdInterval interval = new IdInterval(startingId, endingId);
                songSearch.search(interval);
                
            } else if(option==5){
                System.out.println("You choose to list songs with genre.");
                System.out.print("Enter genre of song: ");
                String genre = input.next();
                Genre genreObje = new Genre(genre);
                songSearch.search(genreObje);
               
            }else{
                System.out.println("Invalid option! Please enter a valid option :(");
            }
            menu();
            break;
        }
    } 
}
