package project2;

public class Token {
    public enum Type{
        CONFIG,UPDATE,COMPUTE,SHOW,CONFIGS,STRING,NUMBERS,IDENTIFIER,REFERENCES,ASSIGNMENT,OPERATOR,
        CONDITION,OPENPARANTHESIS,CLOSEPARANTHESIS,OPENBRACKET,CLOSERACKET,CODESEPERATOR,COMPARISONSIGN,
        MULTIPLY,DIVISION
    }
    public final Type type;
    public final String value;

    public Token(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}
