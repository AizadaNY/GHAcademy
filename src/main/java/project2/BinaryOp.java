package project2;

public class BinaryOp extends ASTNode {

    ASTNode leftNode;
    ASTNode rightNode;
    Token operationToken;

    public BinaryOp(ASTNode leftNode, ASTNode rightNode, Token operationToken) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.operationToken = operationToken;
    }

    public void print(String indent){
        System.out.println(indent+ "Op{"+ operationToken.value + "}");
//        left.print(indent+ indent);
//        right.print(indent+ indent);
    }
}
