package Tries;


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int test = input.nextInt();
        while(test-- >0){
            int N = input.nextInt();
            Trie t = new Trie();
            while(N-- >0){
                String str = input.next();
                t.insert(str);
            }
            String key = input.next();
            System.out.println(t.search(key));
        }
    }

}

class TrieNode {

    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode(){
        children = new TrieNode[26];
        isEndOfWord = false;
        for(int i=0; i<26; i++){
            children[i] = null;
        }
    }

}

class Trie {
    TrieNode root = null;

    Trie (){
        root = new TrieNode();
    }
    public void insert(String key){
        int level;
        int index;
        TrieNode temp = root;
        int length = key.length();
        for(level =0; level<length; level++){
            index = key.charAt(level) - 'a';
            if(temp.children[index]==null)
                temp.children[index] = new TrieNode();
            temp = temp.children[index];
        }
        temp.isEndOfWord=true;
    }

    public int search(String key){
        int level;
        int length = key.length();
        int index;
        TrieNode temp = root;
        for(level=0; level<length; level++){
            index = key.charAt(level)-'a';
            if(temp.children[index]==null)
                return 0;
            temp = temp.children[index];
        }

        return (temp!=null && temp.isEndOfWord==true)?1:0;
    }

    public int countWords(String key){
        //int count=0;
        int level;
        int length = key.length();
        int index;
        TrieNode temp = root;
        for(level=0; level<length; level++){
            index = key.charAt(level)-'a';
            if(temp.children[index]==null)
                return 0;
            temp = temp.children[index];
        }

        if(temp!=null && temp.isEndOfWord==true)
            return 1;
        else{
            return 1+ countPartial(temp);
        }
    }

    public int countPartial(TrieNode node){
        return 1;
    }

}