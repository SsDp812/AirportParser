package com.JavaParser.csv;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

//interface for parser with standart methods

public interface IParser {
    //method for searching
    public String[] search(TreeSet<Integer> indexes);
    //method for convert result after searching in normal view and print
    public void convertToNormalViewAndPrint(String[] data);
    //method for init map with information in searching column and row indexes
    public void initMap();
    //method for preparind indexes set for search
    public TreeSet<Integer> getIndexesForSearchInMap(String req);
}
