/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testingmaven;

import java.util.ArrayList;

/**
 *
 * @author mhenry
 */
public class Tuple implements Comparable<Tuple> {

    private String word;
    private int count;

    //Constructor
    Tuple(String word, int count) {
        this.word = word;
        this.count = count;
    }

    //countless constructor
    Tuple(String word) {
        this.word = word;
        count = 1;
    }

    //Increment yourself, starting from 1
    public int incrementCount() {

        return count++;

    }

    //tostring
    public String toString() {

        return (this.word + " " +this.count);

    }

    //goals (finished)
    //Implement the Comparable<Tuple> interface for your Tuple class
    //You will *now* (previously read: "not") need to implement the single method on this interface - a method that compares Tuple "this" to Tuple "arg0" or 
    //whatever the argument to your comparator is named (NetBeans might have named it "o"). Return an integer that reflects which tuple has the higher count: a positive int for this,
    //0 for equal, a negative in for arg0. Hint: There is a simple mathematical expression involving the counts that will give you that. 
    public int compareTo(Tuple other) {
        int biggerness;
        //this.count
        //other.count
        biggerness = other.count-this.count;
        //returning list in descending order
        return (biggerness);

    }
    
    public String toStringJustWord() {
        return (this.word);
    }
}
