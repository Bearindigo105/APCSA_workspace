
/*
 * @author Subhash Muthu
 * 
 * Cool AP String Shtuf
 */

package Submission_ApString;

public class ApString {

    private String _currentString;

    public ApString(String currentString) {
        _currentString = currentString;
    }

    public void setCurrentString(String _currentString) {
        this._currentString = _currentString;
    }

    public String getCurrentString() {
        return _currentString;
    }

    public int wordCount() {
        String trimmedString = _currentString.trim();
        int returnCount = 0;
        if (trimmedString != "") {
            for (int i = 0; i < trimmedString.length(); i++) {
                returnCount += trimmedString.charAt(i) == ' ' ? 1 : 0; // if trimmedString.charAt(i) is space, then add
                                                                       // 1 to return string. Else add 0.
            }

            return returnCount + 1;
        } else {
            return 0;
        }
    }

    public String spacedWord() {
        String returnString = "";

        for (int i = 0; i < _currentString.length(); i++) {
            returnString += _currentString.charAt(i) + (i + 1 == _currentString.length() ? "" : "_"); // if it is not at
                                                                                                      // last index, add
                                                                                                      // underscore
                                                                                                      // otherwise, add
                                                                                                      // an empty
                                                                                                      // string.
        }

        return returnString;
    }

    public String removeDoubleLetters() {
        char prevLetter = Character.MIN_VALUE; // Empty character
                                               // https://stackoverflow.com/questions/8534178/how-to-represent-empty-char-in-java-character-class
        String returnString = "";

        for (int i = 0; i < _currentString.length(); i++) {
            if (!(_currentString.charAt(i) == prevLetter)) {
                returnString += _currentString.charAt(i);
                prevLetter = _currentString.charAt(i);
            } else {
                prevLetter = Character.MIN_VALUE;
            }

        }

        return returnString;
    }

    public int countTargetLetter(char inputChar) {
        int returnCount = 0;
        for (int i = 0; i < _currentString.length(); i++) {
            returnCount += _currentString.charAt(i) == inputChar ? 1 : 0; // if trimmedString.charAt(i) is space, then
                                                                          // add 1 to return string. Else add 0.
        }
        return returnCount;
    }

}
