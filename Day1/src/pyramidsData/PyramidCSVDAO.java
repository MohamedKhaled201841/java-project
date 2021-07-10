package pyramidsData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class PyramidCSVDAO implements PyramidDAO{




    @Override
    public List<Pyramid> readPyramidFromcsv(String fileName) throws IOException {
        List<Pyramid> list=new ArrayList<>();
        BufferedReader br = null;
        try {
            br=new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line=br.readLine();


        do{
            line=br.readLine();
            if (line !=null) {
                String[] attributes = line.split(",");
                list.add(createPyramid(attributes));
            }
        }while (line !=null);
        System.out.println(list);
        return list;
    }

    @Override
    public Pyramid createPyramid(String[] metadata) {
        Double d ;
        if(metadata[7].isEmpty())d=0.0;
        else d=Double.parseDouble(metadata[7]);
        Pyramid pyramid_object= new Pyramid(metadata[0],metadata[2],metadata[4],d);
        return pyramid_object;
    }
}
