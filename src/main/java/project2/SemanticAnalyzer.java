package project2;

import javax.lang.model.element.VariableElement;
import java.util.Set;
import java.util.Stack;

public class SemanticAnalyzer {

    private final Stack<Set<String>> scopes = new Stack();

    void visit(ASTNode node){
        if(node instanceof BinaryOpNode){
            visit(((BinaryOpNode) node).leftNode);
            visit(((BinaryOpNode) node).rightNode);
        }else if(node instanceof NumberNode){
            //Nothing
        }else if(node instanceof VarDecl){

        }else if(node instanceof Var){

        }else if(node instanceof Assign){

        }else if(node instanceof Block){

        }else{
            throw new ParserException("Unexpected AST Node "+ node.getClass().getCanonicalName());
        }
    }
}
