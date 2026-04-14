import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CsvHelper helper = new CsvHelper();

        var palavra = helper.words(Path.of("src/main/resources/golden_base.csv"));


        for(String s: palavra){
            List<String> newList = List.of(s.split(","));


        }




    }
}
