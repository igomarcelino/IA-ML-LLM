import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvHelper {

    public List<String> words(Path filePath) {
        List<String> words_reads = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(new File(filePath.toUri())))) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {

                words_reads.add(Arrays.asList(line).toString());
            }
        } catch (Exception e) {
        }
        return words_reads;
    }
}
