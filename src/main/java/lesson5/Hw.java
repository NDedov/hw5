package lesson5;

import java.util.Arrays;

public class Hw {

    public static int[][] steps = {{1,2}, {-1,2}, {-2,1}, {-2,1}, {-1,-2}, {1,-2}, {2,-1}, {2, 1}};//вспомогательный
    // массив вариантов ходов

    public static void main(String[] args) {

        System.out.println(degree(10, 3));
        horseStep(new int[4][6],0,0,0);

    }

    /**
     * Возводит x в степень n рекурсивно
     * @param x - основание
     * @param n - степень
     * @return результат
     */
    public static int degree(int x, int n){
        if (n == 0) return 1;
        return x*degree(x, n-1);
    }

    /**
     * Объод конем шахматной доски
     * @param chessBoard двумерный массив - шахматная доска
     * @param posX - позиция хода по X
     * @param posY - позиция хода по Y
     * @param step - текущий шаг
     * @return возвращает null, если достиг финиша, если шаг неудачный возвращает неизмененный
     */
    public static int[][] horseStep(int[][] chessBoard, int posX, int posY, int step){

        chessBoard[posY][posX] = ++step;//добавляем шаг
        int dx,dy, newX, newY;
        int i;
        if (chessBoard.length * chessBoard[0].length == step){//проверка на удачный финиш
            for (int j = 0; j < chessBoard.length; j++)
                System.out.println(Arrays.toString(chessBoard[j]));
            return null;
        }

        for (i = 0; i < 8; i++) {//перебираем в цикле варианты шагов и ходим
            dx = steps[i][0];
            dy = steps[i][1];
            newX = posX + dx;
            newY = posY + dy;
            if (newX >= 0 && newY >= 0 && newX < chessBoard[0].length && newY < chessBoard.length)
                if (chessBoard[newY][newX] == 0)
                    chessBoard = horseStep(chessBoard, newX, newY, step);
            if (chessBoard == null)//выходим изо всех методов при удачном результате
                return null;
        }

        chessBoard[posY][posX] = 0;

        return chessBoard;
    }
}


