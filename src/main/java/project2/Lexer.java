package project2;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Lexer implements Iterable<Token> {

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
                   tokens.add(new Token(Token.Type.ASSIGNMENT, "="));
                   current++;
                   break;
               case '*':
                   tokens.add(new Token(Token.Type.MULTIPLY, Character.toString(ch)));
                   current++;
                   break;
               case '/':
                   tokens.add(new Token(Token.Type.DIVISION, Character.toString(ch)));
                   current++;
                   break;
               case '-':
               case '+':
                   tokens.add(new Token(Token.Type.OPERATOR, Character.toString(ch)));
                   current++;
                   break;
               case '"':
                   tokens.add(new Token(Token.Type.STRING, readString()));
                   current++;
                   break;
               case '%':
                   tokens.add(new Token(Token.Type.REFERENCES, readReference()));
                   current++;
                   break;
               case ';':
                   tokens.add(new Token(Token.Type.CODESEPERATOR, Character.toString(ch)));
                   current++;
                   break;
               case '(':
                   tokens.add(new Token(Token.Type.OPENPARANTHESIS, Character.toString(ch)));
                   current++;
                   break;
               case ')':
                   tokens.add(new Token(Token.Type.CLOSEPARANTHESIS, Character.toString(ch)));
                   current++;
                   break;
               case '{':
                   tokens.add(new Token(Token.Type.OPENBRACKET, Character.toString(ch)));
                   current++;
                   break;
               case '}':
                   tokens.add(new Token(Token.Type.CLOSERACKET, Character.toString(ch)));
                   current++;
                   break;
               case '>':
                   tokens.add(new Token(Token.Type.COMPARISONSIGN, Character.toString(ch)));
                   current++;
                   break;
               default:
                   if(isDigit(input.charAt(current))){
                       tokens.add(new Token(Token.Type.NUMBERS, readNumber()));
                   } else if(isAlpha(input.charAt(current))){
                       String identifier=readIdentifier();
                       if(identifier.equalsIgnoreCase("if")||identifier.equalsIgnoreCase("else")) {
                           tokens.add(new Token(Token.Type.CONDITION, identifier));
                       }
                   }else{
                       throw new LexerError("Unsupported character"+ ch);
                   }
                   current++;
           }
       }
    }

    private Token.Type deriveTokenType(String identifier) {
        switch (identifier){
            case "config":
                return Token.Type.CONFIG;
            case "update":
                return Token.Type.UPDATE;
            case "compute":
                return Token.Type.COMPUTE;
            case "show":
                return Token.Type.SHOW;
            case "configs":
                return Token.Type.CONFIGS;
            default:
                return Token.Type.IDENTIFIER;

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
//        current++;
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



}
