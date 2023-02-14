package com.JavaParser.csv;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


//class for csv parser
public class CsvParser implements IParser{
    private final String fileName;
    private Map<String,Integer> map;
    private final int columnIndex;

    public CsvParser(String fileName, int columnIndex) {
        this.fileName = fileName;
        this.columnIndex = columnIndex;
        initMap();
    }

    public TreeSet<Integer> getIndexesForSearchInMap(String req){
        TreeSet<Integer> indexes = new TreeSet<>();
        for(Map.Entry<String, Integer> el : map.entrySet()){
            if((el.getKey().toLowerCase().substring(1).startsWith(req.toLowerCase())
                    && el.getKey().toLowerCase().startsWith("\"")) ||
                    (el.getKey().toLowerCase().startsWith(req.toLowerCase()))){
                indexes.add(el.getValue());
            }
        }
        return indexes;
    }

    @Override
    public String[] search(TreeSet<Integer> indexes) {
        int rowIndex = 0;
        StringBuilder builder = new StringBuilder("");
        if(!indexes.isEmpty()){
            try(BufferedReader rd = new BufferedReader(new FileReader(fileName))){
                String line = "";
                while((line = rd.readLine()) != null && rowIndex <= indexes.last()){
                    if(indexes.contains(rowIndex)){
                        builder.append(line + "    ");
                    }
                    rowIndex++;
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String[] response = builder.toString().split("   ");
        return response;
    }


    @Override
    public void convertToNormalViewAndPrint(String[] data){
        TreeMap <String,String> res = new TreeMap<>();
        if(data.length != 0){
            for(int y = 0; y < data.length - 1;y++){
                String mainParam = data[y].split(",")[columnIndex - 1];
                res.put(mainParam,data[y]);
            }
        }else{
            System.out.println("Поиск не дал результатов!");
        }
        if(res.isEmpty()){
            System.out.println("Поиск не дал результатов!");
        }
        else{
            TreeMap<Double,String> resWithDoubleValues = null;
            Double val = 0.0;
            try{
                val = Double.parseDouble(res.lastKey());
            }catch (NumberFormatException e){
                val = null;
            }
            if(val != null){
                resWithDoubleValues = new TreeMap<>();
                for(Map.Entry<String, String> info : res.entrySet()){
                    resWithDoubleValues.put(Double.parseDouble(info.getKey()),info.getValue());
                }
                for(Map.Entry<Double, String> info : resWithDoubleValues.entrySet()){
                    System.out.println(info.getKey() + "[" + info.getValue() + "]");
                }
            }
            else{
                for(Map.Entry<String, String> info : res.entrySet()){
                    System.out.println(info.getKey() + "[" + info.getValue() + "]");
                }
            }
        }
        System.out.println("Количество найденных строк: " + res.size());
    }
    @Override
    public void initMap() {
        map = new HashMap<>();
        try(BufferedReader rd = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            int lineIndex = 0;
            while((line = rd.readLine()) != null){
                String row[] = line.split(",");
                map.put(row[columnIndex - 1],lineIndex);
                lineIndex++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //printing map
    public void printMap(){
        for(Map.Entry<String, Integer> el : map.entrySet()){
            System.out.println(el);
        }
    }
}
