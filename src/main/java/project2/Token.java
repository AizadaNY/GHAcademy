package project2;

public class Token {
    public enum Type{
        CONFIG,UPDATE,COMPUTE,SHOW,CONFIGS,STRING,NUMBERS,IDENTIFIER,REFERENCES,ASSIGNMENT,OPERATOR,
        IFCONDITION,ELSECONDITION,OPPAREN,CLPARAN,OPBRACKET,CLBRACKET,CODESEPERATOR,COMPARISONSIGN,
        MULTIPLY,DIVISION,PLUS,ADDITION,VAR
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
