
package sfinksit.tools;

public class SearchCheck {
    String searchWord;
    
    public SearchCheck(String searchWord) {
        this.searchWord = searchWord;
    }
    
    public boolean validateStringLength() {
        return searchWord.length() < 21;
    }
    
    public boolean validateNoDots() {
        return !searchWord.contains(".");
    }
    
    public boolean notEmptySearchWord(){
        return !searchWord.isEmpty() && !searchWord.equals("");
    }
    
    public boolean wordContainsOnlyInteger() {
        return searchWord.matches("[0-9]+");
    }
    
    public boolean checkWordValidation() {
        return validateStringLength() && notEmptySearchWord() && validateNoDots();
    }
    
    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }
}
