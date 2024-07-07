package project1;

import java.io.Serializable;
import java.util.Map;

public class CompressionInfoHolder implements Serializable {
    private final Map<Short, String> codeToWord;
    private final byte[] codeText;

    public Map<Short, String> getCodeToWord() {
        return codeToWord;
    }

    public byte[] getCodeText() {
        return codeText;
    }

    public CompressionInfoHolder(Map<Short, String> codeToWord, byte[] codeText) {
        this.codeToWord=codeToWord;
        this.codeText=codeText;
    }
}
