package com.resultset.listmm;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
 
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
 
/**
 * This class converts ResultSet into ListMultiMap
 * 
 * @author Nitesh Apte
 * @license GPL
 */
public class ResultSetToListMultiMap {
 
        /**
         * Converts ResultSet to ListMultiMap
         * 
         * @param resultSet
         * @return
         */
        public ListMultimap<String, String> resultSetToListMultiMap(ResultSet resultSet) {
                ListMultimap<String, String> multimap = null;
                try{
                        multimap = ArrayListMultimap.create();
 
                        ResultSetMetaData rsmd = resultSet.getMetaData();
 
                        int columnCount = rsmd.getColumnCount();
                        List<String> s1 = new ArrayList<String>();
                        for (int i = 1; i < columnCount+1; i++ ) {
                                s1.add(rsmd.getColumnName(i));
                        }
                        while (resultSet.next()) {      
                                for(int i=0;i<s1.size();i++) {
                                        multimap.put(s1.get(i), resultSet.getString(s1.get(i)));
                                }
                        }
                } catch (Exception e) { 
                        e.printStackTrace();  
                }  
                return multimap;
        }
}