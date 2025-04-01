package week2;

import project2.Token;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    String input = "config \"num_users\" = 100\n" +
            "      config \"request_rate\" = 5.5\n" +
            "      config \"timeout\" = 30\n" +
            "   \n" +
            "      update \"num_users\" = 200;\n" +
            "      update \"request_rate\" = 7.5\n" +
            "   \n" +
            "      compute \"total_requests\" = %num_users * %request_rate\n" +
            "      compute \"total_timeout\" = %num_users * %timeout";
    List<Token> tokens = new ArrayList<>();
    private int current = 0;


    public void tokens(String input) {
        while (current < input.length()) {
            String[] s = input.split(" ");
            switch (s[current]) {
                case "config":
                    tokens.add(new Token(Token.Type.CONFIG, s[current]));
                    break;
                case "*":
                case "/":
                case "+":
                case "-":
                    tokens.add(new Token(Token.Type.OPERATOR, s[current]));
                    break;
                case "=":
                    tokens.add(new Token(Token.Type.ASSIGNMENT, s[current]));
                    break;
                case "update":
                    tokens.add(new Token(Token.Type.UPDATE, s[current]));
                    break;
                case "compute":
                    tokens.add(new Token(Token.Type.COMPUTE, s[current]));
                    break;
                case "%":
                    tokens.add(new Token(Token.Type.REFERENCES, s[current]));
                    break;
                case ";":
                    tokens.add(new Token(Token.Type.CODESEPERATOR, s[current]));
                    break;
                default:
                    if (isDigit(s[current])) {
                        tokens.add(new Token(Token.Type.NUMBERS, s[current]));
                    } else if (s[current].startsWith("%")) {
                        tokens.add(new Token(Token.Type.VAR, s[current]));
                    } else {
                        tokens.add(new Token(Token.Type.IDENTIFIER, s[current]));

                    }
                    break;
            }
            current++;
        }
    }

    public boolean isDigit(char ch) {
        if (ch >= 0 && ch <= 9) {
            return true;
        }
        return false;
    }

    public boolean isAlpha(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch == '_')) {
            return true;
        }
        return false;
    }

    public boolean isAlphaNumeric(char ch) {
        if (isDigit(ch) || isAlpha(ch)) {
            return true;
        }
        return false;
    }


}

