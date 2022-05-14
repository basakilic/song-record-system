package project2.part1.Song;

public class Song{
private String name;
private String artist;
private int id;
private String genre;
private int year;
private IdInterval idInt = null;

    public Song(String name, String artist,int id, String genre, int year) {
        this.name = name;
        this.artist = artist;
        this.id = id;
        this.genre = genre;
        this.year = year;
    }
    
    public Song(IdInterval idInt){
        this.idInt = idInt;
    }

    public int compareTo(Song song, int mode){
        switch(mode){
            case 0:
                return compareTo(new SongName(song.getSongname()));
            case 1:
                return compareTo(song.getId());
            case 2:
                return compareTo(new Artist(song.getArtist()));
            case 3:
                return compareTo(new Genre(song.getGenre()));
            case 4:
                return compareTo(song.idInt);
            default: 
                return -1;
            }
    }

    private int compareTo(Genre genre){
        return this.genre.compareTo(genre.genre);
    }
    
    private int compareTo(IdInterval idInt){ //boolean
        if(idInt.startId<=id && idInt.endId>=id)
            return 0;
        return -1;
    }
    
    private int compareTo(SongName name) {
       return this.name.compareTo(name.songName);
    }
  
    private int compareTo(int id){
        return this.id-id;
    }
    
    private int compareTo(Artist artist) {
        return this.artist.compareTo(artist.name);
       
    }
    
    public String getSongname() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public int getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Song{" + "songname=" + name + ", artist=" + artist + ", id=" + id + ", genre=" + genre + ", year=" + year + '}';
    }
}
