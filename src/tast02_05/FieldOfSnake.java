package tast02_05;

public class FieldOfSnake {
    char[][] field;
    int size;
    int length;
    int[] xSnake;
    int[] ySnake;
    Snake snake;
    boolean gameOver;
    int[] xFruit;
    int[] yFruit;
    boolean[] isFruitEaten;
    boolean addWalls;
    FieldOfSnake(int size, int length, boolean addWalls) {
        this.gameOver = false;
        this.size = size;
        this.length = length;
        this.field = new char[size][size];
        this.xSnake = new int[length];
        this.ySnake = new int[length];
        this.addWalls = addWalls;
        giveUpFruits();
        refreshField();
        int k = 0;
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                if((row == size/2) && (col > size/2-length) && (col <= size/2)){
                    xSnake[length - 1 - k] = col;
                    ySnake[length - 1 - k] = row;
                    k++;
                }
            }
        }
        snake = new Snake(length, xSnake, ySnake);
        System.out.println("Field initialized");
        this.printField();
    }
    public void refreshField(){
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                if((row == 0) || (row == size-1) || (col == 0) || (col == size-1)){
                    field[row][col] = 'X';
                } else {
                    field[row][col] = ' ';
                }
            }
        }
        if(this.addWalls){
            addWalls();
        }
        for(int k=0; k<this.size;k++){
            if(!this.isFruitEaten[k]) {
                field[this.yFruit[k]][this.xFruit[k]] = (char)10086;
            }
        }
    }
    public void addWalls(){
        for(int i=1; i<size-1; i++){
            if((i%4 == 0) && (i != size/2)) {
                for (int j = 0; j < size - 4; j++) {
                    if (i % 8 == 0) {
                        this.field[i][j + 1] = 'X';
                    } else {
                        this.field[i][size - j - 2] = 'X';
                    }
                }
            }
        }
    }
    public void giveUpFruits(){
        this.xFruit = new int[this.size];
        this.yFruit = new int[this.size];
        this.isFruitEaten = new boolean[this.size];
        int k = 0;
        while(k<this.size){
            int xf = (char)((size - 2) * Math.random()) + 1;
            int yf = (char)((size - 2) * Math.random()) + 1;
            if(((yf != size/2) || (xf <= size/2-length) || (xf > size/2)) && (yf%4 != 0)){
                this.xFruit[k] = xf;
                this.yFruit[k] = yf;
                this.isFruitEaten[k] = false;
                k++;
            }
        }
    }
    public boolean isWall(int row, int col){
        return false;
    }
    public void printField() {
        if(field[snake.yCoord.get(0)][snake.xCoord.get(0)] == 'X'){
            gameOver = true;
        }
        refreshField();
        if(field[snake.yCoord.get(0)][snake.xCoord.get(0)] == (char)10086){
            for(int k=0; k<this.size; k++){
                if((snake.xCoord.get(0) == this.xFruit[k]) && (snake.yCoord.get(0) == this.yFruit[k])){
                    this.isFruitEaten[k] = true;
                }
            }
        }
        //field[snake.yCoord.get(0)][snake.xCoord.get(0)] = (char)8855;
        for(int k=1; k<length; k++){
            field[snake.yCoord.get(k)][snake.xCoord.get(k)] = (char)8718;
        }
        field[snake.yCoord.get(0)][snake.xCoord.get(0)] = (char)8855;
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                System.out.print(" " + this.field[row][col] + " ");
            }
            System.out.println();
        }
    }
}
