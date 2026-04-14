import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NaiveBayes {

    private final Set<String> vocabulario;
    private final Map<String, Map<String, Integer>> baseConhecimento;
    private final List<String> palavras;
    Set<String> stopwords = Set.of(
            "o","a","os","as","um","uma",
            "de","do","da","em","no","na",
            "para","por","com",
            "e","ou","mas","porque","que",
            "como","quando","se",
            "isso","aquilo","muito","pouco"
    );

    public NaiveBayes(Set<String> vocabulario, Map<String, Map<String, Integer>> baseConhecimento, List<String> palavras) {
        this.vocabulario = vocabulario;
        this.baseConhecimento = baseConhecimento;
        this.palavras = palavras;
    }

   // private void treinar()



}
