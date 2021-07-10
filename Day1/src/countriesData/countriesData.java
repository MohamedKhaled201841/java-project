package countriesData;

import pyramidsData.Pyramid;
import pyramidsData.PyramidCSVDAO;
import pyramidsData.PyramidDAO;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class countriesData {
    public static void main(String[] args) throws IOException {
        String file1,file2;
        file1 = "D:\\Countries.csv";
        file2 = "D:\\cities.csv";
        DataReaderCountryDAO country = new DataReaderCountry();
        List<country> countries = country.readcountryFromcsv(file1);
        DataReaderCityDAO city = new DataReaderCity();
        List<city> cities = city.readcityFromcsv(file2);

//        Map<Integer,List<city>> cityMap=cities.stream().collect(Collectors.groupingBy((c) -> c.getId()));
//        cities.stream().forEach((c)->System.out.println(c.getName()+":"+c.getPopulation()));
//        System.out.println(countries.stream().collect(Collectors.averagingDouble((c)->c.getPopulation())));
          System.out.println(countries.stream().max(Comparator.comparingDouble((c)-> c.getPopulation())));
    }
}
