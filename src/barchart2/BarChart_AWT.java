/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barchart2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author GIANG
 */
public class BarChart_AWT extends JPanel {

    private static List<BarChartInventoryItem> items = new ArrayList<>();
    private static Map<Integer, List<BarChartInventoryItem>> mapItems = new HashMap<>();

    private void setContentPane(ChartPanel chartPanel) {
        
        this.add(chartPanel);
       }

    

    public BarChart_AWT(String applicationTitle, String chartTitle, Map<Integer, List<BarChartInventoryItem>> mapItem) {
      //  super(applicationTitle);
        mapItems = getMapSortByKeyASC(mapItem);

        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Category",
                "Score",
                createDataset(mapItems),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(600, 367));
        setContentPane(chartPanel);
    }

    private TreeMap getMapSortByKeyASC(Map<Integer, List<BarChartInventoryItem>> mapItem) {
        return new TreeMap(mapItem);
    }

    private CategoryDataset createDataset(Map<Integer, List<BarChartInventoryItem>> mapItem) {

        final DefaultCategoryDataset dataset
                = new DefaultCategoryDataset();

//        for (BarChartInventoryItem item : listBarchar) {
//            System.out.println(listBarchar);
//            double value = item.getValue();
//            String rowkey = item.getRowKey();
//            dataset.addValue(value, rowkey, "a");
//        }
        for (Map.Entry<Integer, List<BarChartInventoryItem>> entrySet : mapItem.entrySet()) {
            String key = entrySet.getKey().toString();
            List<BarChartInventoryItem> value = entrySet.getValue();
            for (BarChartInventoryItem value1 : value) {
                dataset.addValue(value1.getValue(), value1.getRowKey(), key);
            }
        }
        return dataset;
    }
    final String inventory = "Inventory";
    final String amountOfImport = "Amount Import";
    final String amountOfExport = "Amount Export";
    private static String month = "Month";

    // private String 
    public static void main(String[] args) {

        for (int m = 1; m <= 12; m++) {
            List<BarChartInventoryItem> list = new ArrayList<>();
            int valueImport =0;
            int valueExport =0;
            if(m%2==0){
            valueImport =10*50;
            valueExport =5;
            }else{valueImport =5;
            valueExport =10*50;}
            BarChartInventoryItem item1 = new BarChartInventoryItem(valueImport, "Import Amount");
            BarChartInventoryItem item2 = new BarChartInventoryItem(valueExport, "Export Amount");

            list.add(item1);
            list.add(item2);
            mapItems.put(m , list);
        }
        BarChart_AWT chart = new BarChart_AWT("Car Usage Statistics",
                "Which car do you like?", mapItems);

        //chart.pack();
        chart.setVisible(true);
    }
}
