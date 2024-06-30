package project2;

import javax.lang.model.element.VariableElement;
import java.util.HashSet;
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
        }else if(node instanceof VarDecl ){
            String varName=((VarDecl) node).varNode.name;
            if(isVariableDefined(varName)){
                throw new ParserException("Identifier already defined: "+ varName);
            }
            scopes.peek().add(varName);// declare variable in scope
        }else if(node instanceof Var){
            String varName=((Var) node).name;
            if(!isVariableDefined(varName)){
                throw new ParserException("Unexpected identifier: "+ varName);
            }
        }else if(node instanceof Assign){
            Assign assignNode=(Assign) node;
            String varName=assignNode.left.name;
            if(!isVariableDefined(varName)){
                throw new ParserException("Unexpected identifier: "+ varName);
            }
            visit(assignNode.right);
        }else if(node instanceof Block){
            scopes.push(new HashSet<>()); //enter a new scope
            for (ASTNode statement: ((Block) node).statements) {
                visit(statement);
            }
            scopes.pop(); //exit scope
        }else{
            throw new ParserException("Unexpected AST Node "+ node.getClass().getCanonicalName());
        }
    }

    private boolean isVariableDefined(String varName) {
        for (Set<String> scope:scopes) {
            if(scope.contains(varName)){
                return true;
            }
        }
        return false;
    }
}
