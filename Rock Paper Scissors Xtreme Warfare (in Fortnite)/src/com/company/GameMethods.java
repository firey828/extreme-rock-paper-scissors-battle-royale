package com.company;

import javax.swing.*;

public class GameMethods {

    // instance variables
    private int roundWins;
    private int roundLosses;
    private int roundTies;
    private int totalRounds;
    private int points;
    private String luckyMove;

    // constructor
    public GameMethods() {
        roundWins = 0;
        roundLosses = 0;
        roundTies = 0;
        totalRounds = 0;
        points = 0;
        luckyMove = "PLACEHOLDER";
    }

    public void pvp() {
        int oneWins = 0;
        int oneLosses = 0;
        int twoWins = 0;
        int twoLosses = 0;
        String oneMove = "";
        String twoMove = "";
        msg("PLAYER ONE HAS " + oneWins + " WINS AND " + oneLosses + " LOSSES.\n" +
                "PLAYER TWO HAS " + twoWins + " WINS AND " + twoLosses + " LOSSES.\n" +
                        "\n" +
                        "Welcome to PvP Mode.");
        String response = "";
        while (!response.equalsIgnoreCase("QUIT")) {
            response = "";
            while (isInvalidKind(response)) {
                response = in("PLAYER ONE HAS " + oneWins + " WINS AND " + oneLosses + " LOSSES.\n" +
                        "PLAYER TWO HAS " + twoWins + " WINS AND " + twoLosses + " LOSSES.\n" +
                                "\n" +
                                "Player One, choose your move.");
            }
            oneMove = response;
            response = "";
            while (isInvalidKind(response)) {
                response = in("PLAYER ONE HAS " + oneWins + " WINS AND " + oneLosses + " LOSSES.\n" +
                        "PLAYER TWO HAS " + twoWins + " WINS AND " + twoLosses + " LOSSES.\n" +
                                "\n" +
                                "Player Two, choose your move.");
            }
            twoMove = response;
            Move oneFullMove = new Move(oneMove);
            Move twoFullMove = new Move(twoMove);
            String msg = "PLAYER ONE HAS " + oneWins + " WINS AND " + oneLosses + " LOSSES.\nPLAYER TWO HAS " + twoWins + " WINS AND " + twoLosses + " LOSSES.\nPLAYER ONE: " + oneFullMove.toString() + "\nPLAYER TWO: " + twoFullMove.toString() + "\nTHE WINNER IS ";
            if (oneFullMove.amIStrongerThan(twoFullMove)) {
                msg += "PLAYER ONE.";
                oneWins++;
                twoLosses++;
            } else if (oneFullMove.amIWeakTo(twoFullMove)) {
                msg += "PLAYER TWO.";
                twoWins++;
                oneLosses++;
            } else if (oneFullMove.amITiedTo(twoFullMove)) {
                msg += "NEITHER.";
            } else {
                System.out.println("bluh error: this should never happen.");
                return;
            }
            msg(msg);
            if (oneWins >= 3) {
                msg("PLAYER ONE WINS THE GAME!");
                return;
            } else if (twoWins >= 3) {
                msg("PLAYER TWO WINS THE GAME!");
                return;
            }
        }
    }

    public void msg(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public String in(String message) {
        String response = JOptionPane.showInputDialog(message);
        if (response.equalsIgnoreCase("EXIT")) {
            msg("Goodbye.");
            System.exit(0);
            return "this string should never be used";
        } else if (response.equalsIgnoreCase("STATS")) {
            msg("==== YOUR STATS ====\n" +
                    "\n" +
                    "roundWins: " + roundWins + "\n" +
                    "roundLosses: " + roundLosses + "\n" +
                    "roundTies: " + roundTies + "\n" +
                    "Rounds Played: " + totalRounds + "\n" +
                    "Specialty: " + luckyMove);
            response = in(message);
        }
        return response;
    }

    /*
    Returns a randomly-generated move of type ROCK, PAPER, or SCISSORS
     */
    public Move randomComputerMove() {
        int randomChoice = (int) (Math.random() * 3);
        if (randomChoice == 0) {
            return new Move("ROCK");
        } else if (randomChoice == 1) {
            return new Move("PAPER");
        } else if (randomChoice == 2) {
            return new Move("SCISSORS");
        } else {
            System.out.println("bluh error this should never happen");
            return new Move("ERROR");
        }
    }

    /*
    Returns false if the kind of move specified is not one of the three valid
    kinds (ROCK, PAPER, or SCISSORS), true otherwise.
     */
    public boolean isInvalidKind(String kind) {
        if (kind.equalsIgnoreCase("ROCK")) {
            return false;
        } else if (kind.equalsIgnoreCase("PAPER")) {
            return false;
        } else if (kind.equalsIgnoreCase("SCISSORS")) {
            return false;
        } else {
            return true;
        }
    }

    /*
    This method starts a Story Mode game.
    Minimum Points: 0
    Maximum Points: 75
     */
    public void playGame() {
        String name = in("Before we begin, please tell me what your name is.");
        luckyMove = in("You sit down at a table, ready to throw hands.\n" +
                "Which move would you consider to be your \"lucky move\"?\n" +
                "\n" +
                "Please choose from the following:\n" +
                "ROCK\n" +
                "PAPER\n" +
                "SCISSORS");
        msg("A young child walks up to the table.\n" +
                    "    \"Wanna play a game?\" he asks. \"I'm really, really, REALLY good at it!\"\n" +
                    "Shrugging, you decide to accept the child's offer.");
        msg("PRO TIP: Your specialty is " + luckyMove.toLowerCase() + ". You earn points for winning a round with your\n" +
                "specialty, but you lose points for losing a round with it.");
        for (int i = 0; i < 3; i++) {
            doRound(name.toUpperCase(), "TIM", i);
        }
        msg("PRO TIP: You can view your stats at any time by typing \"STATS\" into any text input box.");
        msg("A teenage girl you recognize from math class walks up to the table.\n" +
                "    \"Hey, loser.\" she says. \"You missed the bus too, huh?\"\n" +
                "\n" +
                "You nod your head gloomily.\n\n" +
                "    \"Eh, don't sweat it.\" she responds. \"Happens to the best of us. You must be pretty bored,\n" +
                "    though. How about a game of Rock, Paper, Scissors to kill time?\"");
        for (int i = 0; i < 3; i++) {
            doRound(name.toUpperCase(), "VALENTINA", i);
        }
        msg("PRO TIP: Your choice of move should reflect your desired outcome. For example, if you wish to have a quick\n" +
                "game, you should choose ROCK, as it is shorter, and, therefore, can be typed quicker.");
        msg("You feel a warm spittle drip onto your arm. You turn around to find a small dog. It barks expectantly at you." +
                "\n\n" +
                "    \"Err....hey there, buddy. You wanna play, too?\" you ask.\n\n" +
                "It barks again. It is unclear whether this is a yes or a no.\n\n" +
                "    \"I'm....gonna assume that's a yes.\"");
        for (int i = 0; i < 3; i++) {
            doRound(name.toUpperCase(), "DOG", i);
        }
        msg("Suddenly, a flying saucer appears. You black out as a green light envelops you.");
        msg("....");
        msg("...." + Character.toString(name.charAt(0)).toLowerCase() + "...." + Character.toString(name.charAt(0)).toLowerCase() + "...." + Character.toString(name.charAt(name.length() - 1)) + "....");
        msg("...." + Character.toString(name.charAt(0)).toLowerCase() + "...." + name.toLowerCase() + "? Are you awake?");
        msg("Rubbing your head, you try to sit up, and are promptly made aware of the fact that this is neither the bus " +
                "stop nor your bedroom. Taking a moment to get your bearings, you look yourself over to find that you\n" +
                "are lying on a table, held down by metallic braces that cover all your limbs and joints.\n\n" +
                "Looking to the left, you spot Valentina and the little kid, both strapped down in the same way you are.\n\n" +
                "    \"What happened!?\" you demand.\n\n" +
                "The little kid smiles.\n\n" +
                "    \"Aliens are real!\" he exclaims.");
        msg("Suddenly, you feel a sharp prick on your forehead. An image of a rock, a sheet of paper, and a pair of\n" +
                "scissors fills your mind. You find yourself unable to resist thrusting your wrist against the restraints,\n" +
                "throwing your first hand....");
        for (int i = 0; i < 3; i++) {
            doRound(name.toUpperCase(), "????", i);
        }
        msg("Your mind clears at last.\n\n" +
                "    \"So,\" comes an unfamiliar voice, \"It looks like our experts were right. This species, resistant\n" +
                "    though they may be to more traditional forms of control, can be rendered completely useless by the\n" +
                "    RPS serum.");
        msg("The voice's owner comes into view. A long, snakelike neck connects his gargoyle-like body to his grotesquely\n" +
                "misshapen head. He hovers over you menacingly. \"Hello, Earthling.\"");
        msg("You struggle, in vain, against the restraints. \"Now, now, E-001. No need for that sort of behavior. How about\n" +
                "a nice game of Rock, Paper, Scissors to calm you down?\"\n\n" +
                "And the image fills your head once again....");
        for (int i = 0; i < 3; i++) {
            doRound(name.toUpperCase(), "????", i);
        }
        if (points >= 20) {
            msg("    \"I see that you are quite skilled with your specialty. More so than your friends over there.\" He\n" +
                    "gestures to the other children. \"Being clever as you are, would you be interested in a deal?\"");
        } else if (roundWins >= 9) {
            msg("    \"I see that you are quite a lucky fellow. More so than your friends over there.\" He gestures to the\n" +
                    "other children. \"Being fortunate as you are, would you be interested in a deal?\"");
        } else if (roundLosses >= 9) {
            msg("    \"I see that you are quite an unlucky fellow. More so than your friends over there.\" He gestures to the\n" +
                    "other children. \"Being unfortunate as you are, would you be interested in a deal?\"");
        } else if (roundTies >= 9) {
            msg("    \"I see that you are quite a predictable fellow. More so than your friends over there.\" He gestures to\n" +
                    "the other children. \"Being simple as you are, would you be interested in a deal?\"");
        } else if (roundWins > roundLosses) {
            msg("    \"I see that you are quite a lucky fellow. More so than your friends over there.\" He gestures to the\n" +
                    "other children. \"Being fortunate as you are, would you be interested in a deal?\"");
        } else if (roundLosses > roundWins) {
            msg("    \"I see that you are quite an unlucky fellow. More so than your friends over there.\" He gestures to the\n" +
                    "other children. \"Being unfortunate as you are, would you be interested in a deal?\"");
        } else {
            msg("    \"Your mind is....difficult to analyze. More so than your friends over there.\" He gestures to the other\n" +
                    "children. \"Being strong of will as you are, would you be interested in a deal?\"");
        }
        msg("You nod cautiously.\n\n" +
                "    \"Very good, E-001. Now then, here's the deal. You can choose to live, but spend a week writing a\n" +
                "    story into a program we have created through use of your primitive human technology. Inevitably,\n" +
                "    said story will create a paradoxical form of procrastination which causes the primitive human brain\n" +
                "    to temporarily shut down from perceiving its actions as both productive and counterproductive. In\n" +
                "    this way, you will dismiss any and all thoughts of the original project's goal until the very last\n" +
                "    day.\"" +
                "    \n" +
                "    \n" +
                "    \"....and the alternative?\"" +
                "    \"There is none. We already made the deal.\"");
        msg("==== THE END ====\n" +
                "\n" +
                "Final stats: \n" +
                "roundWins: " + roundWins + "\n" +
                "roundLosses: " + roundLosses + "\n" +
                "roundTies: " + roundTies + "\n" +
                "Rounds Played: " + totalRounds + "\n" +
                "Specialty: " + luckyMove);
    }

    /*
    Completes a round of the game.
     */
    public void doRound(String yourName, String theirName, int roundNumber) {
        String yourMoveKind = "PLACEHOLDER";
        while (isInvalidKind(yourMoveKind)) {
            yourMoveKind = in("Rock, Paper, or Scissors?");
        }
        Move yourMove = new Move(yourMoveKind);
        Move theirMove = randomComputerMove();
        String msg = "==== ROUND " + (roundNumber + 1) + " ====\n" + yourName + ": " + yourMove.toString() + "\n" + theirName + ": " + theirMove.toString() + "\nYou ";
        if (yourMove.amIStrongerThan(theirMove)) {
            msg += "won the round.\n";
            roundWins++;
            if (luckyMove.equalsIgnoreCase(yourMove.getKind())) {
                msg += "You earned five points for using your specialty to win the round.";
                points += 5;
            } else {
                msg += "You didn't use your specialty this round, so you didn't get any points.";
            }
        } else if (yourMove.amIWeakTo(theirMove)) {
            msg += "lost the round.\n";
            roundLosses++;
            if (luckyMove.equalsIgnoreCase(yourMove.getKind())) {
                msg += "You used your specialty this round, so you lost points.";
                points -= 5;
                if (points < 0) {
                    points = 0;
                }
            }
        } else if (yourMove.amITiedTo(theirMove)) {
            msg += "and " + theirName + " tied.";
            roundTies++;
        }
        totalRounds++;
        msg(msg);
    }
}
