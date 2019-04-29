package cz.alisma.alej.text.wrapping;

import java.util.List;

public class CenterAligner implements Aligner {

    @Override
    public String format(List<String> words, int spaceFill) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < spaceFill / 2; i++) {
            result.append(" ");
        }

        boolean first = true;
        for (String w : words) {
            if (!first) {
                result.append(" ");
            } else {
                first = false;
            }
            result.append(w);
        }

        return result.toString();
    }
}
