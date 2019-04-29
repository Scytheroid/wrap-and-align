package cz.alisma.alej.text.wrapping;

import java.util.List;

public class FillAligner implements Aligner {
    @Override
    public String format(List<String> words, int spaceFill) {
        StringBuilder result = new StringBuilder();
        int avgFill = (spaceFill - 1) / words.size();
        int addFill = (spaceFill - 1) % words.size();
        boolean first = true;
        for (String w : words) {
            if (!first) {
                result.append(" ");
                for (int i = 0; i < avgFill; i++) {
                    result.append(" ");
                }

                if (addFill > 0) {
                    addFill -= 1;
                    result.append(" ");
                }
            } else {
                first = false;
            }

            result.append(w);
        }

        return result.toString();
    }

}
