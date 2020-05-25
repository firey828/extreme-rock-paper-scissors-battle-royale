package com.company;

public class Move {
    // instance variables
    private String myKind;

    // constructor
    public Move(String kind) {
        myKind = kind;
    }

    // getters
    public String getKind() {
        return myKind;
    }

    // setters
    public void setKind(String newKind) {
        myKind = newKind;
    }

    public boolean amIWeakTo(Move otherMove) {
        String x = this.getKind();
        String y = otherMove.getKind();
        if (x.equalsIgnoreCase("ROCK") && y.equalsIgnoreCase("PAPER")) {
            return true;
        } else if (x.equalsIgnoreCase("PAPER") && y.equalsIgnoreCase("SCISSORS")) {
            return true;
        } else if (x.equalsIgnoreCase("SCISSORS") && y.equalsIgnoreCase("ROCK")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean amIStrongerThan(Move otherMove) {
        String x = this.getKind();
        String y = otherMove.getKind();
        if (x.equalsIgnoreCase("ROCK") && y.equalsIgnoreCase("SCISSORS")) {
            return true;
        } else if (x.equalsIgnoreCase("PAPER") && y.equalsIgnoreCase("ROCK")) {
            return true;
        } else if (x.equalsIgnoreCase("SCISSORS") && y.equalsIgnoreCase("PAPER")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean amITiedTo(Move otherMove) {
        return this.getKind().equalsIgnoreCase(otherMove.getKind());
    }

    public String toString() {
        return myKind.toUpperCase();
    }
}
