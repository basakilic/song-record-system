package project2.part1.BST;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import project2.part1.Song.Artist;
import project2.part1.Song.Genre;
import project2.part1.Song.IdInterval;
import project2.part1.Song.Song;

public class SongSearchDS {

    GenericArray<Song> songs = new GenericArray<Song>();
    BinarySearchTree nameTree = new BinarySearchTree(songs,0);
    BinarySearchTree idTree = new BinarySearchTree(songs,1);
    BinarySearchTree artistTree = new BinarySearchTree(songs,2);
    
     public SongSearchDS(String fileName){
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String tempLine;
        while((tempLine = br.readLine()) != null){ // end of the file
            int[] column = new int[4];
            int j = 0;
            for (int i = 0; i < tempLine.length(); i++) {
                if(tempLine.charAt(i) == ';')
                    column[j++] = i;
            }
            
             this.insert(new Song(tempLine.substring(0,column[0]),
                    tempLine.substring(column[0]+1,column[1]),
                    Integer.parseInt(tempLine.substring(column[1]+1,column[2])),
                    tempLine.substring(column[2]+1,column[3]),
                    Integer.parseInt(tempLine.substring(column[3]+1))));
         
        }
                     System.out.println("song: " + songs.toString());

        } catch (IOException ex) {
        }    
    }
     
    public Song search(String name){
        return songs.get(nameTree.search(new Song(name,null,0,null,0)));
    }
    
    public Song search(Artist artist){
        return songs.get(artistTree.search(new Song(null,artist.name,0,null,0))); 
    } 
    
    public Song search(int id){
        return songs.get(idTree.search(new Song(null,null,id,null,0))); 
    }
    
    public void search(Genre genre){
        idTree.searchAll(new Song(null,null,0,genre.genre,0),3); 
    }
    
    public void search(IdInterval idInt){
        idTree.searchAll(new Song(idInt),4); 
    }
            
    public void insert(Song song){ // to insert to tree 
        int currentIndex = songs.insert(song);
        nameTree.insertToTree(currentIndex);
        idTree.insertToTree(currentIndex);
        artistTree.insertToTree(currentIndex);
    }
    
    public void remove(int id){ // to remove 
        Song tempSong = new Song(null,null,id,null,0);
        nameTree.remove(tempSong);
        idTree.remove(tempSong);
        artistTree.remove(tempSong);
        songs.remove(idTree.search(tempSong));
    }
}
