package com.example.a222;


import java.util.Random;

public class Game {
    Players[] players;
    Cards[] cards;
    private Players selectedPlayer;
    private Boolean startGame;
    private int degree;
    private float last_dir = 0f;
    private float new_dir = 0f;
    private int numberOfPlayers;
    private Players choosedPlayer;


    public Game(Players[] players, Cards[] cards) {

        this.players = players;
        this.cards = cards;
        this.startGame = true;
        this.numberOfPlayers = players.length;
        this.choosedPlayer = players[0];
        calculateAngle();

    }

    public int numberOfPlayers() {
        return this.players.length;
    }

    public void setSelectedPlayer(Players player) {
        this.selectedPlayer = player;
    }

    public Players getSelectedPlayer() {
        return selectedPlayer;
    }

    public void minusOneCard(String pack) {
        for (Cards c : cards) {
            if (c.getName().equals(pack) == true) {
                c.getCards().remove(c.sizeCards() - 1);
                c.setLeftCards();
            } else {
                String a = "a";
            }
        }
    }

    public String leftCardsText(String pack) {
        String text = "";
        for (Cards c : cards) {
            if (c.getName().equals(pack) == true) {
                text = c.leftCardsText();
            } else {
                String a = "a";
            }
        }
        return text;
    }

    public String getNamePack(String pack) {
        String text = "";
        for (Cards c : cards) {
            if (c.getName().equals(pack) == true) {
                text = c.getName();
            } else {
                String a = "a";
            }
        }
        return text;
    }

    public String getRandomQuestion(String pack) {
        String text = "";
        for (Cards c : cards) {
            if (c.getName().equals(pack) == true) {
                text = c.getRandomQuestion();
            } else {
                String a = "a";
            }
        }
        return text;
    }


    public String getFirstPlayer() {
        return this.choosedPlayer.getFullName();
    }

    public Boolean isStartGame() {
        return this.startGame;
    }

    public String whoStartGame() {
        StringBuilder str = new StringBuilder();
        str.append("Игру начинает ");
        str.append(getFirstPlayer());
        return str.toString();
    }

    public void setNotStartGame() {
        this.startGame = false;
    }

    public String whoContinueGame() {
        StringBuilder str = new StringBuilder();
        str.append("Теперь очередь игрока ");
        str.append(getFirstPlayer());
        return str.toString();
    }

    public void calculateAngle() {

        float degreeForOnePlayer = 360 / numberOfPlayers;
        float degree = 0f;
        for (int i = 0; i < numberOfPlayers; i++) {
            if (i == 0) {
                players[i].setFromDegree(0 + degreeForOnePlayer / 2);
                players[i].setToDegree(360 - degreeForOnePlayer / 2 + 0.1f);
            } else if (i == 1) {
                players[i].setFromDegree(players[i - 1].getFromDegreeForPlayer() + 0.1f);
                players[i].setToDegree(players[i - 1].getFromDegreeForPlayer() + degreeForOnePlayer);
            } else {

                players[i].setFromDegree(players[i - 1].getToDegreeForPlayer() + 0.1f);
                players[i].setToDegree(players[i - 1].getToDegreeForPlayer() + degreeForOnePlayer);
            }
        }
    }

    public float getRandomAngle(float lD) {
        Random random = new Random();
        new_dir = random.nextInt(2160) + 1000 + (int) lD;
        return  new_dir;
    }

    public void startOnePlay() {
        new_dir = getRandomAngle(last_dir);
        float degree = new_dir % 360 + 18f;
        for (int i = 0; i < numberOfPlayers; i++) {
            if (i == 0) {
                if (degree <= players[i].getFromDegreeForPlayer() || degree > players[i].getToDegreeForPlayer()) {
                    choosedPlayer = players[i];
                    break;
                }
            } else {
                if (degree > players[i].getFromDegreeForPlayer() && degree <= players[i].getToDegreeForPlayer()) {
                    choosedPlayer = players[i];
                    break;

                }
            }
        }

    }
    public int getNumberChoosedPlayer(){
        return choosedPlayer.getNumber();
    }

    public float getLast_dir() {
        return last_dir;
    }

    public float getNew_dir(){
        return new_dir;
    }

    public void setLast_dir(){
        last_dir=new_dir;
    }

    public Players getChoosedPlayer(){
        return  choosedPlayer;
    }
}
