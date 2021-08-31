package com.act.framework.utilities;

import io.cucumber.datatable.DataTable;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class CucumberUtil {

    private static Dictionary<String, DataCollection> _dataCollection = new Hashtable<>();

    public static Dictionary<String, DataCollection> convertDataTableToDictionary(DataTable dataTable){
        List<List<String>> data = dataTable.asLists();

        int rowNumber = 0;

        for(List<String> col : data){
            for(int colIndex = 0; colIndex < col.size(); colIndex++){
                _dataCollection.put(data.get(0).get(colIndex),
                        new DataCollection(data.get(0).get(colIndex), col.get(colIndex), rowNumber));
            }
            rowNumber++;
        }

        return _dataCollection;
    }

    //Todo: passing the row index to get the column value based on row number
    public static String getCellValue(String columnName){
        return _dataCollection.get(columnName).ColumnValue;
    }

    private static class DataCollection {
        private String ColumnName;
        private String ColumnValue;
        private int rowNumber;

        public DataCollection(String columnName, String columnValue, int rowNumber) {
            ColumnName = columnName;
            ColumnValue = columnValue;
            this.rowNumber = rowNumber;
        }
    }
}

