package project2;

public class NumberNode extends ASTNode {

    Token tokenNumber;
    final int value;

    public NumberNode(Token tokenNumber) {
        this.tokenNumber = tokenNumber;
        this.value=Integer.parseInt(tokenNumber.value);
    }

    @Override
    public String toString() {
        return "NumberNode{" +
                + value +
                '}';
    }

    @Override
    public void print(String indent) {
        System.out.println(indent+ "N{" + value + '}');
    }
}
