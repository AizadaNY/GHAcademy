package project2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String input="";


        ArrayList<Lexer.Token> tokens=new ArrayList<>();
        tokens.add(new Lexer.Token(Lexer.TokenType.CONFIG,"Config"));
        tokens.add(new Lexer.Token(Lexer.TokenType.STRING,"num_users"));
        tokens.add(new Lexer.Token(Lexer.TokenType.ASSIGNMENT,"z"));
        tokens.add(new Lexer.Token(Lexer.TokenType.NUMBERS ,"100"));

        for (Lexer.Token token:tokens) {
            System.out.println(token);
        }
    }

}
