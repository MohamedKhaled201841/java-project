package countriesData;

import countriesData.country;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface DataReaderCountryDAO {
    public List readcountryFromcsv(String fileName) throws IOException;
    public country createCountry(String[] metadata);
}
