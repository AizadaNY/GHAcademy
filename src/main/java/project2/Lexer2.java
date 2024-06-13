package project2;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lexer2 implements Iterable<Lexer2.Token>{

    private final String input;
    private final List<Lexer2.Token> tokens;
    private int current;

    public Lexer2(String input){
        this.input=input;
        this.tokens=new ArrayList<>();
        current=0;
        tokenize();
    }

    private void tokenize() {
        while (current<input.length()){
            char ch=input.charAt(current);
            switch (ch){
                case ' ':
                case '\t':
                case '\n':
                case '\r':
                    current++;
                    break;
                case '=':
                    tokens.add(new Lexer.Token(Lexer.TokenType.ASSIGNMENT, "="));
                    current++;
                    break;
                case '*':
                case '/':
                case '-':
                case '+':
                    tokens.add(new Lexer.Token(Lexer.TokenType.OPERATOR, Character.toString(ch)));
                    current++;
                    break;
                case '"':
                    tokens.add(new Lexer.Token(Lexer.TokenType.STRING, readString()));
                    current++;
                    break;
                case '%':
                    tokens.add(new Lexer.Token(Lexer.TokenType.REFERENCES, readReference()));
                    current++;
                    break;
                default:
                    if(isDigit(input.charAt(current))){
                        tokens.add(new Lexer.Token(Lexer.TokenType.NUMBERS, readNumber()));
                    } else if(isAlpha(input.charAt(current))){
                        String identifier=readIdentifier();
                        tokens.add(new Lexer.Token(deriveTokenType(identifier),identifier));
                    }else{
                        throw new LexerError("Unsupported character"+ ch);
                    }


            }
        }
    }

    private Lexer.TokenType deriveTokenType(String identifier) {
        switch (identifier){
            case "config":
                return Lexer.TokenType.CONFIG;
            case "update":
                return Lexer.TokenType.UPDATE;
            default:
                return Lexer.TokenType.IDENTIFIER;

        }
    }

    private String readIdentifier() {
        StringBuilder builder=new StringBuilder();
        current++;
        while (current<input.length()&&isAlphaNumeric(input.charAt(current))){
            builder.append(input.charAt(current));
            current++;
        }
        return builder.toString();
    }

    private String readNumber() {
        StringBuilder builder=new StringBuilder();
        current++;
        while (current<input.length()&&isDigit(input.charAt(current))){
            builder.append(input.charAt(current));
            current++;
        }
        return builder.toString();
    }

    private String readReference() {
        StringBuilder builder=new StringBuilder();
        current++;
        while (current<input.length()&&isAlphaNumeric(input.charAt(current))){
            builder.append(input.charAt(current));
            current++;
        }
        return builder.toString();
    }

    private boolean isAlphaNumeric(char ch){
        return isAlpha(ch)|| isDigit(ch);
    }

    private boolean isAlpha(char ch){
        return ('a'<=ch && ch<= 'z') || ('A'<=ch && ch<= 'Z')|| ch=='_';
    }

    private boolean isDigit(char ch){
        return ('0'<=ch && ch<= '9');
    }

    private String readString() {
        StringBuilder builder=new StringBuilder();
        current++;
        while (current<input.length()&&input.charAt(current)=='"'){
            builder.append(input.charAt(current));
            current++;
        }
        return builder.toString();
    }

    @Override
    public Iterator<Lexer2.Token> iterator() {
        return tokens.iterator();
    }


    static class  Token{
        final Lexer2.TokenType type;
        final String value;

        public Token(Lexer2.TokenType type, String value) {
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
    enum TokenType{
        CONFIG,UPDATE,COMPUTE,SHOW,CONFIGS,STRING,NUMBERS,IDENTIFIER,REFERENCES,ASSIGNMENT,OPERATOR
    }
    }


