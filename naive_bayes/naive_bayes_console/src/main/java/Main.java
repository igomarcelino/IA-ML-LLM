import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        CsvHelper helper = new CsvHelper();

        var palavra = helper.vocabulario(Path.of("src/main/resources/golden_base.csv"));




        System.out.println(palavra);




    }
}
