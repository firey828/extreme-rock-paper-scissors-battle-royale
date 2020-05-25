package com.company;

public class Main {

    public static void main(String[] args) {
        GameMethods _gm = new GameMethods();
        String multiplayerOrStoryMode = "";
        multiplayerOrStoryMode = _gm.in("Would you like to play in PVP MODE or STORY MODE?");
        if (multiplayerOrStoryMode.equalsIgnoreCase("PVP") || multiplayerOrStoryMode.equalsIgnoreCase("PVP MODE")) {
            String choice = "PLAY AGAIN";
            while (choice.equalsIgnoreCase("PLAY AGAIN")) {
                _gm.pvp();
                choice = _gm.in("Would you like to play again? Say \"PLAY AGAIN\" to play again, or \"EXIT\" to exit.");
            }
            _gm.msg("Thanks for playing! Goodbye.");
        } else if (multiplayerOrStoryMode.equalsIgnoreCase("STORY") || multiplayerOrStoryMode.equalsIgnoreCase("STORY MODE")) {
            String choice = "PLAY AGAIN";
            while (choice.equalsIgnoreCase("PLAY AGAIN")) {
                _gm.playGame();
                choice = _gm.in("Would you like to play again? Say \"PLAY AGAIN\" to play again, or \"EXIT\" to exit.");
            }
            _gm.msg("Thanks for playing! Goodbye.");
        }
    }
}
