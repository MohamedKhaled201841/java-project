package countriesData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReaderCity implements DataReaderCityDAO {

    @Override
    public List<city> readcityFromcsv(String fileName) throws IOException {
        List<city> list=new ArrayList<>();
        BufferedReader br = null;
        try {
            br=new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line=null;


        do{
            line=br.readLine();
            if (line !=null) {
                String[] attributes = line.split(",");
                list.add(createCity(attributes));
            }
        }while (line !=null);
//        System.out.println(list);
        return list;
    }

    @Override
    public city createCity(String[] metadata) {
        city city_object= new city(Integer.parseInt(metadata[0]),metadata[1],Integer.parseInt(metadata[2]),metadata[3]);
        return city_object;
    }
}
