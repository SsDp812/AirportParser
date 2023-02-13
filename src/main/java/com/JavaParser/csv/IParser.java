package JavaParser;

import java.util.Map;
import java.util.TreeMap;

//interface for parser with standart methods

public interface IParser {
    //method for searching
    public TreeMap<String,String> search(String req);
    //method for searching and printing info in sorting view
    public void searchAndPrint(String req);
    //method for init map with information in searching column and row indexes
    public void initMap();
}
