package project2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String input = """
                config "num_users" = 100
                config "num_requests" = 100
                update "num_users" = 12
                compute "result" = %num_users + %num_requests
                """;


//        ArrayList<Lexer.Token> tokens=new ArrayList<>();
//        tokens.add(new Lexer.Token(Lexer.TokenType.CONFIG,"Config"));
//        tokens.add(new Lexer.Token(Lexer.TokenType.STRING,"num_users"));
//        tokens.add(new Lexer.Token(Lexer.TokenType.ASSIGNMENT,"z"));
//        tokens.add(new Lexer.Token(Lexer.TokenType.NUMBERS ,"100"));
        Lexer lexer=new Lexer(input);
        for (Lexer.Token token:lexer) {
            System.out.println(token);
        }
    }

}
