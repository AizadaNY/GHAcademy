package project2;

import sun.util.logging.PlatformLogger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Lexer implements Iterable<Lexer.Token> {


    private final String input;
    private final List<Token> tokens;
    private int current;

    public Lexer(String input){
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
                   tokens.add(new Token(TokenType.ASSIGNMENT, "="));
                   current++;
                   break;
               case '*':
               case '/':
               case '-':
               case '+':
                   tokens.add(new Token(TokenType.OPERATOR, Character.toString(ch)));
                   current++;
                   break;
               case '"':
                   tokens.add(new Token(TokenType.STRING, readString()));
                   current++;
                   break;
               case '%':
                   tokens.add(new Token(TokenType.REFERENCES, readReference()));
                   current++;
                   break;
               default:
                   if(isDigit(input.charAt(current))){
                       tokens.add(new Token(TokenType.NUMBERS, readNumber()));
                   } else if(isAlpha(input.charAt(current))){
                       String identifier=readIdentifier();
                       tokens.add(new Token(deriveTokenType(identifier),identifier));
                   }else{
                       throw new LexerError("Unsupported character"+ ch);
                   }


           }
       }
    }

    private TokenType deriveTokenType(String identifier) {
        switch (identifier){
            case "config":
                return ;
            case "update":
                return TokenType.UPDATE;
            default:
                return TokenType.IDENTIFIER;

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
    public Iterator<Token> iterator() {
        return tokens.iterator();
    }


    static class  Token{
        final TokenType type;
        final String value;

        public Token(TokenType type, String value) {
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
