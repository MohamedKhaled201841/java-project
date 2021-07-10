package pyramidsData;

import java.io.IOException;
import java.util.List;


public interface PyramidDAO {
    public List readPyramidFromcsv(String fileName) throws IOException;
    public Pyramid createPyramid(String[] metadata);
}
