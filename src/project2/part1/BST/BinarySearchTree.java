package project2.part1.BST;

import java.util.NoSuchElementException;
import project2.part1.Song.Song;

public class BinarySearchTree {

    GenericArray<Song> songs = new GenericArray<Song>();
    public Node root;
    int searchMode;

    public BinarySearchTree(GenericArray<Song> songs, int searchMode) {
        this.songs=songs;
        this.searchMode = searchMode;
        if(searchMode != 1 || searchMode != 2 )
            searchMode = 0;
        root = null;
    }

    public void insertToTree(int data){
        root = insertToTree(root,data);
    }

    private Node insertToTree(Node current, int data) {
        if(current == null){
            return new Node(data);
        }else{
            if(songs.get(current.key).compareTo(songs.get(data), searchMode ) > 0){
                current.left = insertToTree(current.left,data);
            } else if(songs.get(current.key).compareTo(songs.get(data), searchMode ) < 0){
                current.right = insertToTree(current.right,data);
            }else{
                return current;
            }
        }
        return current;
    }

    public int search(Song data){
        return search(data,root);
    }

    private int search(Song data, Node current){
        if(current == null){
            return -1;
        }else{
            if(songs.get(current.key).compareTo(data, searchMode ) > 0){
                return search(data,current.left);
            }
            else if(songs.get(current.key).compareTo(data, searchMode ) < 0){
                return search(data,current.right);
            }
            else{
                return current.key;
            }
        }
    }
    
    public void searchAll(Song data, int searchMode){
        searchAll(data,root,searchMode);
    }
    
    private void searchAll(Song data, Node current, int searchMode){
        if(current == null){
            return ; //
        }else{
                searchAll(data,current.left,searchMode); 
                if(songs.get(current.key).compareTo(data, searchMode ) == 0){
                System.out.println(songs.get(current.key).toString());
            }
                searchAll(data,current.right,searchMode);
        }
    }
 
    public Node deleteMin(Node x) {
        if (root==null){
            throw new NoSuchElementException("BST is empty!");
        }
        if (x.left == null){
            return x.right;
        }
        x.left = deleteMin(x.left);
        return x;
    }
     
    public Node min(Node x) {
        if(root==null) {
            throw new NoSuchElementException("BST is empty!");
        }
        if (x.left == null){
            return x;
        } else {
            return min(x.left);
        }
    }

    public void remove(Song data){
        Node result = remove(data,root);
        if(result == null)
            System.out.println("Song could not be found !");
        else
            root = result;
    }
    
    public Node remove(Song data, Node current) {
         if(current == null){
            return null;
        }else{
            if(songs.get(current.key).compareTo(data, searchMode ) > 0){
                return remove(data,current.left);
            }
            else if(songs.get(current.key).compareTo(data, searchMode ) < 0){
                return remove(data,current.right);
            }else{
                if(songs.get(current.right.key) == null){
                return current.left;
                }
                 if(songs.get(current.left.key) == null){
                return current.right;
            }
        }
            Node t = current;
            current = min(t.right); 
            current.right = deleteMin(t.right); 
            current.left = t.left;
        }
        return current;
    }

    /*
    @Override
    public String toString() {
        return toString(root,0);
    }
    
    private String toString(Node current, int level) {
        String returnValue = new String();
        if(current == null){
        return "";
        }else{
            for (int i = 0; i < level; i++) 
                returnValue+="\t";
        returnValue += songs.get(current.key)+"\n";
        returnValue += toString(current.left,level+1);
        returnValue += toString(current.right,level+1);
        }
       
        return returnValue;
    }*/
}