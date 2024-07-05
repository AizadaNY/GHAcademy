package project2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        String input = "config \"num_users\" = 100\n" +
//                "config \"num_requests\" = 100\n" +
//                "update \"num_users\" = 12\n" +
//                "compute \"result\" = %num_users + %num_requests";

        String input = "x = 5;\n" +
                "if (x > 3) {\n" +
                "  y = x + 2;\n" +
                "} else {\n" +
                "  y = x * (2 + 3);\n" +
                "}\n" +
                "print y;\n";

//if else statement

//        ArrayList<Lexer.Token> tokens=new ArrayList<>();
//        tokens.add(new Lexer.Token(Lexer.TokenType.CONFIG,"Config"));
//        tokens.add(new Lexer.Token(Lexer.TokenType.STRING,"num_users"));
//        tokens.add(new Lexer.Token(Lexer.TokenType.ASSIGNMENT,"z"));
//        tokens.add(new Lexer.Token(Lexer.TokenType.NUMBERS ,"100"));
        Lexer lexer = new Lexer(input);
        lexer.tokenize();
        List<Token> tokens=lexer.tokens;
        for (Token token:tokens) {
           System.out.println("Token Type: "+token.type + ",   Value: "+ token.value);
        }

        Parser parser=new Parser(tokens);
       ASTNode root =parser.parse();

    }




}
