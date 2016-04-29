package sfinksit.tools;

import java.util.ArrayList;
import sfinksit.domain.Reference;
import sfinksit.repository.ReferenceRepository;

public class Generator {

    private static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm'};


    public String generate(ReferenceRepository rep, Reference ref) {

        String key = split(ref);

        if (rep.findExistingBibtexKey(key).size() > 0) {
            key = generateLoop(key, rep);
        }

        return key;
    }

    public String generateLoop(String key, ReferenceRepository rep) {
        String keyToReturn = key;
        for (int i = 0; i < 6; i++) {
                keyToReturn = keyToReturn + alphabet[i];
                if (rep.findExistingBibtexKey(keyToReturn).size() > 0) {
                    keyToReturn = keyToReturn.substring(0, keyToReturn.length() - 1);
                } else {
                    break;
                }
            }
        return keyToReturn;  
    }
    
    public String split(Reference ref) {

        String[] names = ref.author.split(";");
        String name = "";
        for (int i = 0; i < names.length; i++) {
            int j = 0;
            while (names[i].substring(j, j+1).equalsIgnoreCase(" ")) {
                j++;
            }
            name = name + names[i].substring(j, j + 1);

        }
        return name + ref.year;
    }
}
