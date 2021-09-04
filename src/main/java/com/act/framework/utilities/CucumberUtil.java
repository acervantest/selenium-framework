package com.act.framework.utilities;

import io.cucumber.datatable.DataTable;
import java.util.ArrayList;
import java.util.List;

public class CucumberUtil {

    private static List<DataCollection> _dataCollection = new ArrayList<>();

    public static List<DataCollection> convertDataTableToDictionary(DataTable dataTable){

        _dataCollection.clear();

        List<List<String>> data = dataTable.asLists();

        int rowNumber = 0;

        for(List<String> col : data){
            for(int colIndex = 0; colIndex < col.size(); colIndex++){
                _dataCollection.add(rowNumber,
                        new DataCollection(data.get(0).get(colIndex), col.get(colIndex), rowNumber));
            }
            rowNumber++;
        }

        return _dataCollection;
    }

    public static String getCellValueWithRowIndex(String columnName, int rowNumber){
        final String[] columnValue = {null};

        for(DataCollection dc: _dataCollection){
            if(dc.columnName.equals(columnName) && dc.rowNumber == rowNumber){
                columnValue[0] = dc.columnValue;
            }
        }
        return columnValue[0];
    }

    private static class DataCollection {
        private String columnName;
        private String columnValue;
        private int rowNumber;

        public DataCollection(String columnName, String columnValue, int rowNumber) {
            this.columnName = columnName;
            this.columnValue = columnValue;
            this.rowNumber = rowNumber;
        }
    }
}

