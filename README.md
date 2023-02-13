# AirportParser

## Commands

 - mvn install (for install dependencies)
 - mvn clean package (for building project)
 - java -jar target/airports-search-1.1.0.jar * (for execute jar file, where * is column index)
 - java -jar -Xmx7m target/airports-search-1.1.0.jar * (for execute with 7mb for heap)

## Searching
>> Difficult of searching is < O(n) where
>> in is count of rows in file.
>> All column and saved in map with row's indexes.
>> So searching method search for the right row.

## Examples

![](https://github.com/SsDp812/AirportParser/example1.png)
![](https://github.com/SsDp812/AirportParser/example2.png)
