/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testingmaven;

import com.mycompany.testingmaven.Tuple;
import java.io.InputStream;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author mhenry
 */
public class AnalyzingTextMCH {

    private static final boolean DEBUG = false;

    /**
     * @param args the command line arguments
     */

    //This used to be in beowulf sort, returned string[]. i adapted and now returns arrayList
    public static ArrayList<String> fileReader(String fileName) {

        InputStream is = AnalyzingTextMCH.class.getResourceAsStream(fileName);

        //saying hello to file
        if (is == null) {
            System.out.println("beowulf.txt not found");
            System.exit(-1);
        }

        //introducing the scanner
        Scanner sc = new Scanner(is);
        //int i = 0;
        //Full text is 27,562,is min value array must hold

        //this is my word holder 
        //saving ALL THE WORDS to wordHolder, not just printing, in order occur from input file
        //ArrayList<Location> lal = new ArrayList<>();
        //cities
        //lal.add(new City(85000, 59, "King", 47.66, 122.16, "Kirkland"));
        ArrayList<String> wal = new ArrayList<>();
        while (sc.hasNext()) {

            //scan next is nextWord var
            String nextWord = sc.next();

            if (DEBUG) {
                //print next word          
                System.out.println(nextWord);
                //increment counter and print
                //System.out.println(i);
            }

            //scanning next word and assigning to incremented wordHolder
            wal.add(nextWord);

        }

        //System.out.println("got to return");
        return wal;

    }

    //starting with sorted list of words
    //Go through the ArrayList of words in a for loop with list.get(i), and create a new Tuple object for every new word you see. Count the equal words and reflect that in the tuple. This is the actually tricky part of the assignment.
    //dictFromWords reads sorted list of words and returns tuple dictionary of unique words in doc
    private static ArrayList<Tuple> dictFromWords(ArrayList<String> words) {

        String last = null;

        ArrayList<Tuple> dictionary = new ArrayList<>(); //dictionary of unique words in the doc

        Tuple lastWordTuple = new Tuple("i am unhappy");
        for (String current : words) { //this is my version of list.get

            //tuple y used to be here
            //use sentinel value null (if current and last value is null, skip or don't return)
            if (current.equals(last)) {

                //use .equals to compare to the last word i saw
                //if same, increment word count
                lastWordTuple.incrementCount();

            } else {

                //goals
                //if different, keep word count same
                //set value in tuple y
                //debug sout    
                //System.out.println("i found a new word, it's " + current);
                //remember what last word is for next time thru loop
                //add y to dictionary
                if (last == null) {
                    ;
                } else {
                    dictionary.add(lastWordTuple);

                }
                lastWordTuple = new Tuple(current);

            }
            //update word
            last = current;
        }
        dictionary.add(lastWordTuple);
        return dictionary;

    }

    //working minusUseless, with useless words included
    //private static ArrayList<Tuple> minusUseless(ArrayList<Tuple>dict){
    //initialize useless list
    //  ArrayList<String> uselessList = new ArrayList<>();
    //TODO should be reading from file of uselessWords not handjammed
    //    uselessList.add("The");
    //    uselessList.add("the");
    //    uselessList.add("Of");
    //    uselessList.add("of");
    //    uselessList.add("And");
    //    uselessList.add("and");
    //   uselessList.add("to");
    //  uselessList.add("a");
    //uselessList.add("To");
    //   uselessList.add("A");
    //   ArrayList<Tuple> usefulList = new ArrayList<>();
    //   for (Tuple word:dict){
    //TODO skip this if it's in uselessList
    //        if (uselessList.contains(word.toStringJustWord())){
    //           continue;
    //      }
    //       usefulList.add(word);
    //  }
    //  return usefulList;
    //}
    private static ArrayList<Tuple> minusUseless(ArrayList<Tuple> dict, ArrayList<String> uselessList) {

        ArrayList<Tuple> usefulList = new ArrayList<>();
        for (Tuple word : dict) {
            //TODO skip this if it's in uselessList
            if (uselessList.contains(word.toStringJustWord())) {
                continue;
            }
            usefulList.add(word);
        }
        return usefulList;
    }

    //expected beowulf 2, dad 1, is 1, my 1
//TODO-->
//Sort the ArrayList of words with list.sort(null); now all equal words are next to each other. You can also use Collections.sort(list);
//Make a second, empty ArrayList<Tuple> "tuples".
//Go through the ArrayList of words in a for loop with list.get(i), and create a new Tuple object for every new word you see. Count the equal words and reflect that in the tuple. This is the actually tricky part of the assignment. There are multiple ways to do this efficiently. Think about how you would do it if you had to do it by hand. 
//Implement the Comparable<Tuple> interface for your Tuple class: add "implements Comparable<Tuple>" after the class name. When Java tries to sort a list of items, it needs to know which of two is “greater” and which is “smaller”, to know which one should go to the front/back. By implementing the Comparable interface, you are giving your tuple a way to tell Java.
//Click on the red/yellow light bulb on the left and select "implement all abstract methods"
//You will now need to implement the single method on this interface - a method that compares Tuple "this" to Tuple "arg0" or whatever the argument to your comparator is named (NetBeans might have named it "o"). Return an integer that reflects which tuple has the higher count: a positive int for this, 0 for equal, a negative in for arg0. Hint: There is a simple mathematical expression involving the counts that will give you that. 
//sort tuples with tuples.sort(null). the sorting algorithm will use the comparable interface to sort the ArrayList by count.
//now you should have an ArrayList<Tuple> which contains all the tuples in order of word frequency, allowing you to identify the top 10. Sorted in reverse? change your compareTo() method!
//<--END TODO
    public static void main(String[] args) {
        ArrayList<String> words;
        ArrayList<String> stopWords;
        int count = 0;
        words = fileReader("resources/beowulf.txt");
        //stopwords file reader
        //stopWords=fileReader("resources/useless.txt");//it works
        stopWords = fileReader("resources/canonicalUseless.txt");
        //dictFromWords(words, stopWords);
        words.sort(null);
        ArrayList<Tuple> dict = dictFromWords(words);
        dict.sort(null);
        //for every word in the dict (minus the uselessWords) print if not garbage
        //working for
        //for (Tuple t : minusUseless(dict)) {
        for (Tuple t : minusUseless(dict, stopWords)) {
            if (t.toString().startsWith("'") || t.toString().startsWith("(")) {
                continue;
            }

            System.out.println(t); //this is the tuples
            if (count++ == 9) {
                break;
            }
        }
        System.out.println("the file has been read (" + words.size() + " words)");
    }

    // this is nearly a clone of former main()
    // only this time, we are just printing the word count for the words the user specifies
    // there's no need for stop words because the user presumably won't specify stupid words
    public static void gimmeWords(String fname, ArrayList<String> userListOfWords) {
        ArrayList<String> words;
        ArrayList<String> stopWords;
        int count = 0;
        words = fileReader( // TODO USE THE RIGHT VARIABLE HERE );

        words.sort(null);
        ArrayList<Tuple> dict = dictFromWords(words);
        dict.sort(null);

        // TODO at this point you have a dictionary of words
        // it's up to you to iterate the userListOfWords and Do The Necessary
        // it's almost too easy if you just look at how the iteration worked in former main()
        ... pseudocode
        iterate(something)
          print (something);
    }
}
