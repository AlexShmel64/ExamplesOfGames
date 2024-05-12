package tast02_05;

import java.util.Scanner;

public class SnakeGame {
    FieldOfSnake fSnake;
    int size;
    int length;
    boolean addWalls;
    String addWallsStr;
    void runNewGame(){
        System.out.println("Задайте размер поля: ");
        Scanner scn = new Scanner(System.in);
        this.size = scn.nextInt();
        System.out.println("Добавить дополнительные стены (y/n) ?");
        Scanner scn1 = new Scanner(System.in);
        this.addWallsStr = scn1.nextLine();
        if(this.addWallsStr.equals("y")){
            this.addWalls = true;
        }else{
            this.addWalls = false;
        }
        System.out.println("Задайте длину змейки не более, чем " + (size/2) + ": ");
        this.length = scn.nextInt();
        if(this.length > this.size/2){
            System.out.println("Неверно задана длина змейки");
        }else{
            fSnake = new FieldOfSnake(this.size, this.length, addWalls);
            this.play();
        }
    }
    void play(){
        while(!fSnake.gameOver) {
            Scanner scn = new Scanner(System.in);
            System.out.println("Сделайте ход:");
            char turn = scn.next().charAt(0);
            if(turn == 'l'){
                if(fSnake.field[fSnake.snake.yCoord.get(0)][fSnake.snake.xCoord.get(0) - 1] == (char)10086){
                    fSnake.length++;
                    fSnake.snake.length++;
                    fSnake.snake.xCoord.add(0);
                    fSnake.snake.yCoord.add(0);
                }
                fSnake.snake.goLeft();
                fSnake.printField();
            }else if(turn == 'u'){
                if(fSnake.field[fSnake.snake.yCoord.get(0) - 1][fSnake.snake.xCoord.get(0)] == (char)10086){
                    fSnake.length++;
                    fSnake.snake.length++;
                    fSnake.snake.xCoord.add(0);
                    fSnake.snake.yCoord.add(0);
                }
                fSnake.snake.goUp();
                fSnake.printField();
            }else if(turn == 'r'){
                if(fSnake.field[fSnake.snake.yCoord.get(0)][fSnake.snake.xCoord.get(0) + 1] == (char)10086){
                    fSnake.length++;
                    fSnake.snake.length++;
                    fSnake.snake.xCoord.add(0);
                    fSnake.snake.yCoord.add(0);
                }
                fSnake.snake.goRight();
                fSnake.printField();
            }else if(turn == 'd'){
                if(fSnake.field[fSnake.snake.yCoord.get(0) + 1][fSnake.snake.xCoord.get(0)] == (char)10086){
                    fSnake.length++;
                    fSnake.snake.length++;
                    fSnake.snake.xCoord.add(0);
                    fSnake.snake.yCoord.add(0);
                }
                fSnake.snake.goDown();
                fSnake.printField();
            }else{
                fSnake.printField();
            }
        }
        boolean win = true;
        for(int k=0; k<fSnake.isFruitEaten.length; k++){
            if(!fSnake.isFruitEaten[k]){
                win = false;
            }
        }
        if(win){
            System.out.println("Вы выиграли");
        }else {
            System.out.println("Игра завершена");
        }
    }
}
