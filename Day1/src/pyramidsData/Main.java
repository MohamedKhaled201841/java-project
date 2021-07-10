package pyramidsData;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        String file;
        file = "E:\\SELF LEARNING\\AI ITI\\Java & UML_Amr_Elshafey\\pyramids.csv";
        PyramidDAO pDAO1 = new PyramidCSVDAO();
        List<Pyramid> pyramids = pDAO1.readPyramidFromcsv(file);
//        int i=0;
//        for (Pyramid p:pyramids){
//            System.out.println("#"+(i++)+p);
//    }
//         IntStream.of(pyramids)
        List<Double> pyramidsHieght = new ArrayList<>();
        for (Pyramid p : pyramids) {
            pyramidsHieght.add(p.getHeight());
        }
        System.out.println(pyramidsHieght.stream().sorted().collect(Collectors.toList()));
        Map<String, Integer> pyramidsSites = new HashMap();
        String site=new String();
        for (Pyramid p : pyramids){
            site=p.getSite();
            pyramidsSites.putIfAbsent(site,1);
            if(pyramidsSites.containsKey(site)){
                pyramidsSites.put(site,pyramidsSites.get(site)+1);
            }
        }
        System.out.println(pyramidsSites);
        }
    }




















