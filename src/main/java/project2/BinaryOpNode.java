package project2;

public class BinaryOpNode extends ASTNode {

    ASTNode leftNode;
    ASTNode rightNode;
    Token operationToken;

    public BinaryOpNode(ASTNode leftNode, ASTNode rightNode, Token operationToken) {
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
