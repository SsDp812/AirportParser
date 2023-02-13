package JavaParser;
import java.io.File;  
import java.io.IOException;
import java.util.Scanner;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        try{
            int indexColumn = Integer.parseInt(args[0]);
            if(indexColumn >= 1 && indexColumn <= 14){
                CsvParser parser = new CsvParser("airports.csv",indexColumn);
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
                        parser.searchAndPrint(req);
                    }
                }
            }
            else{
                System.out.println("В файле 14 колонок, введите значение от 1 до 14!");
            }
        }catch(Exception ex){
            System.out.println("Неверный аргумент!");

        }
        
        
    }
}