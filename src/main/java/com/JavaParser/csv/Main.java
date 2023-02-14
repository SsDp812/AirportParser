package com.JavaParser.csv;
import java.io.File;  
import java.io.IOException;
import java.util.Scanner;
import java.util.Objects;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        if(args.length != 0){
            try{
                int indexColumn = Integer.parseInt(args[0]);
                if(indexColumn >= 1 && indexColumn <= 14){
                    CsvParser parser = new CsvParser("airports.csv",2);
                    String req = "";
                    Scanner scanner = new Scanner(System.in);
                    Boolean condExit = false;
                    while(!condExit){
                        System.out.println("Введите строку запроса: ");
                        req = scanner.nextLine();
                        if(Objects.equals(req,"!quit")){
                            condExit = true;
                        }
                        else{
                            TreeSet<Integer> set = parser.getIndexesForSearchInMap(req);
                            long time = System.currentTimeMillis();
                            String[] list = parser.search(set);
                            long time2 = (System.currentTimeMillis() - time);
                            parser.convertToNormalViewAndPrint(list);
                            System.out.println("Время затраченное на поиск: " + time2 + "мс");
                        }
                    }
                }
                else{
                    System.out.println("В файле 14 колонок, введите значение от 1 до 14!");
                }
            }catch(Exception ex){
                System.out.println("Неверный аргумент!");

            }
        }else{
            System.out.println("Не был передан аргумент!(номер столбца)");
        }
        
        
        
    }
}