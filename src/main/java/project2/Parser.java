package project2;

import java.util.List;

public class Parser {

  private final List<Token> tokens;
  private int currPos;
  private Token curToken;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        currPos=0;
        curToken=tokens.get(currPos);
    }

    public ASTNode parse(){
        return term();
    }

    private ASTNode term() {
        ASTNode node=factor();

        while (curToken!=null||(curToken.type == Token.Type.MULTIPLY)||curToken.type == Token.Type.DIVISION){
           Token token=curToken;
            consume(curToken.type);
            node=new BinaryOp(node,factor(),token);
        }
        return node;
    }

    private void consume(Token.Type type) {
        if(curToken!=null||curToken.type==type){
             currPos++;
             if(currPos<tokens.size()){
                 curToken=tokens.get(currPos);
             }else {
                 curToken=null;
             }
        }else {
            throw new  ParserException("Unexpected token");
        }
    }

    private ASTNode factor() {
       Token token=curToken;
       consume(Token.Type.NUMBERS);
       return new NumberNode(token);

    }
}
