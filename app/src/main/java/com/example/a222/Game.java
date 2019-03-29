package com.example.a222;



public class Game {
     Players[] players;
     Cards[] cards;
    private Players selectedPlayer;
    private Boolean startGame;



    public Game(Players[] players, Cards[] cards){

        this.players = players;
        this.cards = cards;
        this.startGame = true;
    }


    public int numberOfPlayers(){
        return  this.players.length;
    }

    public void setSelectedPlayer(Players player){
        this.selectedPlayer = player;
    }

    public Players getSelectedPlayer(){
        return selectedPlayer;
    }

    public void minusOneCard(String pack){
        for (Cards c: cards) {
            if (c.getName().equals(pack) == true){
               c.getCards().remove(c.sizeCards()-1);
               c.setLeftCards();
            } else {
                String a = "a";
            }
        }
    }

    public String leftCardsText(String pack){
        String text = "";
        for (Cards c: cards) {
            if (c.getName().equals(pack) == true){
                text = c.leftCardsText();
            } else {
                String a = "a";
            }
        }
        return text;
    }

    public String getNamePack(String pack){
        String text = "";
        for (Cards c: cards) {
            if (c.getName().equals(pack) == true){
                text = c.getName();
            } else {
                String a = "a";
            }
        }
        return text;
    }

   public String getRandomQuestion(String pack){
       String text = "";
       for (Cards c: cards) {
           if (c.getName().equals(pack) == true){
               text = c.getRandomQuestion();
           } else {
               String a = "a";
           }
       }
       return text;
   }


    public String getFirstPlayer(){
        return this.selectedPlayer.getFullName();
    }

    public Boolean isStartGame(){
        return this.startGame;
    }

    public String whoStartGame(){
        StringBuilder str = new StringBuilder();
        str.append("Игру начинает ");
        str.append(getFirstPlayer());
        return str.toString();
    }

    public void setNotStartGame(){
        this.startGame = false;
    }

    public String whoContinueGame(){
        StringBuilder str = new StringBuilder();
        str.append("Теперь очередь игрока ");
        str.append(getFirstPlayer());
        return str.toString();
    }

}
