import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CsvHelper {

    boolean firstLine = true;

    /**
     * @param filePath   Aprender o vocabulario a partir do CSV informado
     * */
    public List<String> vocabulario(Path filePath) {
        List<String>  volcabulario = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(new File(filePath.toUri())))) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                if (firstLine){ // pular o cabecalho
                    firstLine = false;
                    continue;
                }
                for (String s: line){
                    String cleaned = s.replaceAll("[^\\p{L} ]", " ");
                    String[] palavras = cleaned.split("\\s+");
                    for (String palavra: palavras){
                        String palavraNormalizada = palavra.toLowerCase().trim();
                        if (!stopWords.contains(palavraNormalizada)){
                            volcabulario.add(palavra);
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return volcabulario;
    }

    /**
     * @implNote Palavras para serem ignoradas para evitar acumulo de notas neutrras
     * */
    private final Set<String> stopWords = Set.of(
            "a","à","às","ao","aos",
            "o","os","as",
            "um","uma","uns","umas",
            "de","da","das","do","dos",
            "em","no","na","nos","nas",
            "por","para","com","sem","sob","sobre","entre","até","após","antes","desde",
            "e","ou","mas","porque","porquê","por que","se","como","quando","onde","que",
            "eu","tu","ele","ela","nós","vós","eles","elas",
            "me","te","lhe","lhes","vos",
            "meu","minha","meus","minhas",
            "teu","tua","teus","tuas",
            "seu","sua","seus","suas",
            "este","esta","estes","estas",
            "esse","essa","esses","essas",
            "aquele","aquela","aqueles","aquelas",
            "já","ainda","também","só","apenas","muito","muitos","muita","muitas",
            "pouco","poucos","pouca","poucas",
            "mais","menos","tão","tanto","tanta","tantos","tantas",
            "sim","não","nao",
            "ser","é","são","era","eram","sendo","será","serão",
            "estar","está","estão","estava","estavam","esteve","estiveram",
            "ter","tem","têm","tinha","tinham","teve","tiveram",
            "haver","há","haviam",
            "fazer","faz","fazem","fez","fazendo",
            "dizer","diz","disse","dizem",
            "ir","vai","vão","foi","foram",
            "mesmo","mesma","mesmos","mesmas",
            "outro","outra","outros","outras",
            "algo","alguém","algum","alguma","alguns","algumas",
            "cada","todo","toda","todos","todas",
            "aqui","ali","lá","cá",
            "isso","isto","aquilo",
            "etc","etc."
    );

}
