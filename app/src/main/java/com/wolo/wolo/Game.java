package com.wolo.wolo;


import java.util.Random;

public class Game {
    Players[] players;
    Cards[] cards;
    private Players selectedPlayer;
    private Boolean startGame;
    private float degree;
    private float last_dir = 0f;
    private float new_dir = 0f;
    private int numberOfPlayers;
    private Players choosedPlayer;
    private Players previsiousPlayer;
    private boolean repeatPlayer;
    Players player1;
    Players player2;



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
        String txt = text.replaceAll("Игрок 1", player1.getFullName());
        String txt2 = txt.replaceAll("Игрок 2", player2.getFullName());
        return txt2;
    }


    public Players getFirstPlayer() {
        return this.choosedPlayer;
    }

    public Boolean isStartGame() {
        return this.startGame;
    }

    public String whoStartGame() {
        StringBuilder str = new StringBuilder();
        str.append("Игру начинает ");
        str.append(getFirstPlayer().getFullName());
        setPlayer1(getFirstPlayer());
        return str.toString();
    }

    public void setNotStartGame() {
        this.startGame = false;
    }

    public String whoContinueGame() {
        StringBuilder str = new StringBuilder();
        str.append("Теперь очередь игрока ");
        str.append(getFirstPlayer().getFullName());
        setPlayer1(getFirstPlayer());
        return str.toString();
    }

    public String whoRepeat() {
        StringBuilder str = new StringBuilder();
        str.append("Игрок ");
        str.append(getFirstPlayer().getFullName());
        str.append(" крутит бытылку еще раз ");
        return str.toString();
    }


    public void calculateAngle() {

        float degreeForOnePlayer = 360 / numberOfPlayers;
        for (int i = 0; i < numberOfPlayers; i++) {
            if (i == 0) {
                players[i].setFromDegree(0 + degreeForOnePlayer / 2);
                players[i].setToDegree(360 - degreeForOnePlayer / 2 + 0.1f);
                players[i].setCenterDegree(360f);
            } else if (i == 1) {
                players[i].setFromDegree(players[i - 1].getFromDegreeForPlayer() + 0.1f);
                players[i].setToDegree(players[i - 1].getFromDegreeForPlayer() + degreeForOnePlayer);
                players[i].setCenterDegree(degreeForOnePlayer / 2 * (i + 1));
            } else {
                players[i].setFromDegree(players[i - 1].getToDegreeForPlayer() + 0.1f);
                players[i].setToDegree(players[i - 1].getToDegreeForPlayer() + degreeForOnePlayer);
                players[i].setCenterDegree(degreeForOnePlayer / 2 * (i + 1));
            }

        }
    }

    public float getRandomAngle(float lD) {
        Random random = new Random();
        new_dir = random.nextInt(2160) + 1000 + (int) lD;
        return  new_dir;
    }

    public void startOnePlay() {
        if (previsiousPlayer == null){
            previsiousPlayer = getFirstPlayer();
        }

        new_dir = getRandomAngle(last_dir);
        degree = new_dir % 360;
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
        if ((previsiousPlayer == null)) {
            repeatPlayer = false;
        }

        else {
            if (choosedPlayer.getFullName().equals(previsiousPlayer.getFullName()))
                repeatPlayer = true;
            else{repeatPlayer = false;}
                /*if (choosedPlayer.getNumber() == numberOfPlayers) {
                //new_dir = new_dir + (players[0].getCenterDegree() - degree);
                    if (choosedPlayer.getNumber() == numberOfPlayers ){
                    choosedPlayer = players[0];
                    } else{
                        choosedPlayer = players[choosedPlayer.getNumber()];
                    }
                } else {
               // new_dir = new_dir + (players[choosedPlayer.getNumber()].getCenterDegree() - degree);
                    if (choosedPlayer.getNumber() == numberOfPlayers ){
                        choosedPlayer = players[0];
                    } else{
                        choosedPlayer = players[choosedPlayer.getNumber()];
                    }
                }*/

            //startOnePlay();
        }
        setPlayer2(choosedPlayer);

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

    public void setLast_dir(float f){
        last_dir=f;
    }

    public Players getChoosedPlayer(){
        return  choosedPlayer;
    }

    public void setPrevisiousPlayer(){
        this.previsiousPlayer = choosedPlayer;
    }

    public boolean getRepeatPlayer(){
        return repeatPlayer;
    }

    public void setRepeatPlayer(boolean b){
       this.repeatPlayer = b;
    }

    public float getDegree(){
        return degree;
    }

    public void setPlayer1(Players player){
        this.player1 = player;
    }

    public void setPlayer2(Players player){
        this.player2 = player;
    }
}
