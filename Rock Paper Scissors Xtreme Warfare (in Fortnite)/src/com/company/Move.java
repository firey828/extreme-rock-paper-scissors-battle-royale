package com.company;

public class Move {
    // ======== INSTANCE VARIABLES ========
    private String myKind;

    // ======== CONSTRUCTORS ========
    public Move(String kind) {
        myKind = kind;
    }

    // ======== GETTERS ========
    public String getKind() {
        return myKind;
    }

    // ======== SETTERS ========
    public void setKind(String newKind) {
        myKind = newKind;
    }

    /*
     * Returns true if the current Move object is weak to otherMove; false otherwise
     *   |----------|-----------|--------|
     *   |   this   | otherMove | result |
     *   |----------|-----------|--------|
     *   | rock     | rock      | false  |
     *   | rock     | paper     | true   |
     *   | rock     | scissors  | false  |
     *   | paper    | rock      | false  |
     *   | paper    | paper     | false  |
     *   | paper    | scissors  | true   |
     *   | scissors | rock      | true   |
     *   | scissors | paper     | false  |
     *   | scissors | scissors  | false  |
     *   |----------|-----------|--------|
     */
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

    /*
     * Returns true if otherMove is weak to the current Move object; false otherwise
     *   |----------|-----------|--------|
     *   |   this   | otherMove | result |
     *   |----------|-----------|--------|
     *   | rock     | rock      | false  |
     *   | rock     | paper     | false  |
     *   | rock     | scissors  | true   |
     *   | paper    | rock      | true   |
     *   | paper    | paper     | false  |
     *   | paper    | scissors  | false  |
     *   | scissors | rock      | false  |
     *   | scissors | paper     | true   |
     *   | scissors | scissors  | false  |
     *   |----------|-----------|--------|
     */
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

    /*
     * Returns true if the current Move object is the same as otherMove; false otherwise
     *   |----------|-----------|--------|
     *   |   this   | otherMove | result |
     *   |----------|-----------|--------|
     *   | rock     | rock      | true   |
     *   | rock     | paper     | false  |
     *   | rock     | scissors  | false  |
     *   | paper    | rock      | false  |
     *   | paper    | paper     | true   |
     *   | paper    | scissors  | false  |
     *   | scissors | rock      | false  |
     *   | scissors | paper     | false  |
     *   | scissors | scissors  | true   |
     *   |----------|-----------|--------|
     */
    public boolean amITiedTo(Move otherMove) {
        return this.getKind().equalsIgnoreCase(otherMove.getKind());
    }

    /*
     * Returns an all-uppercase String containing the kind of move this is.
     */
    public String toString() {
        return myKind.toUpperCase();
    }
}
