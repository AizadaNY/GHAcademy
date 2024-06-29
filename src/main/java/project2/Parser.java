package project2;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private final List<Token> tokens;
    private int currPos;
    private Token curToken;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        currPos = 0;
        curToken = tokens.get(currPos);
    }

    public ASTNode parse() {
        List<ASTNode> statements=new ArrayList<>();
        while (curToken!=null){
            statements.add(statement());
            if(curToken!=null&& curToken.type==Token.Type.CODESEPERATOR){
                consume(curToken.type);
            }
        }

        return new Block(statements);
    }

    private ASTNode statement() {
        if(curToken.type==Token.Type.OPBRACKET){
            return block();
        }
        if(curToken.type==Token.Type.VAR){
            return declaration();
        }
        if(curToken.type== Token.Type.IDENTIFIER){
            return assignment();
        }
        if(curToken.type==Token.Type.IFCONDITION){
            return conditionBlock();
        }
        return  expression();
    }

    /**
     * If Condition::= if(condition) then statement
     * String input = "x = 5;\n" +
     *                 "if (x > 3) {\n" +
     *                 "  y = x + 2;\n" +
     *                 "} else {\n" +
     *                 "  y = x * (2 + 3);\n" +
     *                 "}\n" +
     *                 "print y;\n";
     */
    private ASTNode conditionBlock() {
       if(curToken.type==Token.Type.IFCONDITION) {
           consume(Token.Type.IFCONDITION);
           consume(Token.Type.OPPAREN);

           return block();

       }else{
           while (curToken.type!=Token.Type.ELSECONDITION){
               consume(curToken.type);
           }
           return block();
       }



    }

    private ASTNode condition() {
        ASTNode node = factor();

        while (curToken != null || (curToken.type == Token.Type.COMPARISONSIGN )) {
            Token token = curToken;
            consume(curToken.type);
            node = new BinaryOpNode(node, factor(), token);
        }
        return node;
    }

    private ASTNode assignment() {
        Var varNode=var();
        consume(Token.Type.ASSIGNMENT);
        return new Assign(varNode, expression());
    }

    private ASTNode declaration() {
        consume(Token.Type.VAR);
        Var varNode=var();
        consume(Token.Type.ASSIGNMENT);
        return new VarDecl(varNode, expression());
    }

    private Var var() {
        Token token=curToken;
        consume(Token.Type.IDENTIFIER);
        return new Var(token);

    }

    private ASTNode block() {
        consume(Token.Type.OPBRACKET);
        List<ASTNode> statements=new ArrayList<>();
        while (curToken.type!=Token.Type.CLBRACKET){
            statements.add(statement());
        }
        consume(Token.Type.CLBRACKET);

        return new Block(statements);
    }

    private ASTNode expression() {
        ASTNode node = term();

        while (curToken != null || curToken.type == Token.Type.PLUS || curToken.type == Token.Type.ADDITION) {
            Token token = curToken;
            consume(curToken.type);
            node = new BinaryOpNode(node, term(), token);
        }
        return node;

    }

    private ASTNode term() {
        ASTNode node = factor();

        while (curToken != null || (curToken.type == Token.Type.MULTIPLY) || curToken.type == Token.Type.DIVISION) {
            Token token = curToken;
            consume(curToken.type);
            node = new BinaryOpNode(node, factor(), token);
        }
        return node;
    }

    private ASTNode factor() {
        Token token = curToken;

        if(token.type==Token.Type.NUMBERS){
            consume(Token.Type.NUMBERS);
            return new NumberNode(token);
        }

        if(token.type==Token.Type.OPPAREN){
            consume(Token.Type.OPPAREN);
            ASTNode node=expression();
            consume(Token.Type.CLPARAN);
            return node;
        }

        throw new ParserException("Unexpected token found for parser "+token);
    }

    private void consume(Token.Type type) {
        if (curToken != null || curToken.type == type) {
            currPos++;
            if (currPos < tokens.size()) {
                curToken = tokens.get(currPos);
            } else {
                curToken = null;
            }
        } else {
            throw new ParserException("Unexpected token");
        }
    }


}
