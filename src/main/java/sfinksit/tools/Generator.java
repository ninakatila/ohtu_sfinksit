package sfinksit.tools;

import sfinksit.domain.Reference;
import sfinksit.repository.ReferenceRepository;

public class Generator {

    private static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm'};

    public Generator() {

    }

    public String generate(ReferenceRepository rep, Reference ref) {
        String key = ref.bibtexKey = ref.author.substring(0, 1) + ref.year;

        if (rep.findExistingBibtexKey(key)
                .size() > 0) {
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

}
