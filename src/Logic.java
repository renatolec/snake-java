public class Logic {
    
    Player player;
    Fruits fruits;

    Logic(Player player, Fruits fruits){
        this.player = player;
        this.fruits = fruits;
    }

    public void update(int command){
        player.movementPlayer(command);
        consumeFruits();
    }

    public void consumeFruits(){
        if(player.x[0] == fruits.x && player.y[0] == fruits.y){
            player.piecesBody++;
            fruits.fruitUp = false;
            fruits.generateFruit(Ambient.GAME_UNIT);
        }
    }


}
