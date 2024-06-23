package project2;

public class VarDecl extends ASTNode {

    Var varNode;
    ASTNode expression;

   public VarDecl(Var varNode,ASTNode expression){
        this.varNode=varNode;
        this.expression=expression;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent+ "VarDecl}" + varNode.name +"}");
        print(indent + indent);
    }


}
