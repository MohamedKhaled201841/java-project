package countriesData;

import pyramidsData.Pyramid;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReaderCountry implements DataReaderCountryDAO {
    @Override
    public List readcountryFromcsv(String fileName) throws IOException {

        List<country> list=new ArrayList<>();
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
                list.add(createCountry(attributes));
            }
        }while (line !=null);
//        System.out.println(list);
        return list;
    }



    @Override
    public country createCountry(String[] metadata) {
        country country_object= new country(metadata[0],metadata[1],metadata[2],Double.parseDouble(metadata[3]),Double.parseDouble(metadata[4]),Double.parseDouble(metadata[5]),Integer.parseInt(metadata[6]));
        return country_object;
    }


}

