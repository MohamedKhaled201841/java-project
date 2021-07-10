package countriesData;

import java.io.IOException;
import java.util.List;

public interface DataReaderCityDAO {
    public List readcityFromcsv(String fileName) throws IOException;
    public city createCity(String[] metadata);
}
