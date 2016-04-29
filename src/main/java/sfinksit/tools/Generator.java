package sfinksit.tools;

import java.util.ArrayList;
import sfinksit.domain.Reference;
import sfinksit.repository.ReferenceRepository;

public class Generator {

    private static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm'};


    public String generate(ReferenceRepository rep, Reference ref) {

        String key = split(ref);

        if (rep.findExistingBibtexKey(key).size() > 0) {
            for (int i = 0; i < 6; i++) {
                key = key + alphabet[i];
                if (rep.findExistingBibtexKey(key).size() > 0) {
                    key = key.substring(0, key.length() - 1);
                } else {
                    break;
                }

            }
        }

        return key;
    }

    public String split(Reference ref) {

        String[] names = ref.author.split(";");
        String name = "";
        for (int i = 0; i < names.length; i++) {
            int j = 0;
            // while (names[i].substring(j, j+1).equalsIgnoreCase(" ")) {
            //     j++;
            // }

            String trimed = names[i].trim();            
            name = name + trimed.substring(j, j + 1);

        }
        return name + ref.year;
    }
}
