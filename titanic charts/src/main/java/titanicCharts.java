import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class titanicCharts {
    public static void main(String[] args) throws IOException {
        titanicCharts titanicCharts=new titanicCharts();
        List<TitanicPassenger> allPassengers= titanicCharts.getPassengersFromJsonFile();
        titanicCharts.graphPassengerAges(allPassengers);
        titanicCharts.graphPassengerClass(allPassengers);
        titanicCharts.graphPassengersSurvived(allPassengers);
        titanicCharts.graphPassengersSurvivedGender(allPassengers);

    }

    // Read json file and return a list containing TitanicPassenger Objects
    public List<TitanicPassenger> getPassengersFromJsonFile() throws IOException {
        List<TitanicPassenger> allPassengers = new ArrayList<TitanicPassenger>();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure (DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        InputStream input = new FileInputStream("E:\\SELF LEARNING\\AI ITI\\titanic_csv.json");
        //Read JSON file
        allPassengers = objectMapper.readValue(input, new TypeReference<List<TitanicPassenger>>(){});
        return allPassengers;
    }

    public void graphPassengerAges(List<TitanicPassenger> passengerList) {
        //filter to get an array of passenger ages
        List<Float> pAges = passengerList.stream().map(TitanicPassenger::getAge).limit(8).collect(Collectors.toList());
        List<String> pNames = passengerList.stream().map(TitanicPassenger::getName).limit(8).collect(Collectors.toList());
        //Using Cart to graph the Ages 1. Create Chart
        CategoryChart chart = new CategoryChartBuilder().width(1024).height (768).title ("Age Histogram").xAxisTitle ("Names").yAxisTitle
                ("Age").build ();
        // 2. Customize Chart
        chart.getStyler ().setLegendPosition (Styler.LegendPosition.InsideNW);
        chart.getStyler ().setHasAnnotations (true);
        // 3. Series
        chart.addSeries ("Passenger's Ages", pNames, pAges);
        // 4. Show it
        new SwingWrapper(chart).displayChart ();
    }

    public void graphPassengerClass(List<TitanicPassenger> passengerList) {
        Map<String, Long> result = passengerList.stream ()
                .collect (Collectors.groupingBy (TitanicPassenger::getPclass, Collectors.counting ()));
        PieChart  chart = new PieChartBuilder().width (800).height (600).title ("Class Pie Chart").build ();
        Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color(80, 143, 160)};
        chart.getStyler ().setSeriesColors (sliceColors);
        chart.addSeries ("First Class", result.get ("1"));
        chart.addSeries ("Second Class", result.get ("2"));
        chart.addSeries ("Third Class", result.get ("3"));
        new SwingWrapper (chart).displayChart ();
    }
    public void graphPassengersSurvived(List<TitanicPassenger> passengerList){
        Map<String, Long> result = passengerList.stream ()
                .collect (Collectors.groupingBy (TitanicPassenger::getSurvived, Collectors.counting ()));
        System.out.println(result);
        PieChart  chart = new PieChartBuilder().width (800).height (600).title ("Class Pie Chart").build ();
        Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120)};
        chart.getStyler ().setSeriesColors (sliceColors);
        chart.addSeries ("Survived", result.get ("1"));
        chart.addSeries ("Didn't survive", result.get ("0"));
        new SwingWrapper (chart).displayChart ();
    }
    public void graphPassengersSurvivedGender(List<TitanicPassenger > passengerList) {
        List<TitanicPassenger> survivors = passengerList.stream().filter(titanicPassenger -> titanicPassenger.getSurvived().equals("1")).collect(Collectors.toList());
        Map<String, Long> result = survivors.stream ()
                .collect (Collectors.groupingBy (TitanicPassenger::getSex, Collectors.counting ()));
        System.out.println(result);
        PieChart chart = new PieChartBuilder ().width (800).height (600).title ("Survivors' Gender Pie Chart").build ();
        Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120)};
        chart.getStyler ().setSeriesColors (sliceColors);
        chart.addSeries ("Male", result.get ("male"));
        chart.addSeries ("Female", result.get ("female"));
        new SwingWrapper (chart).displayChart ();
    }



}
