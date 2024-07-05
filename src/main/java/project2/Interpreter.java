package project2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Interpreter {

    private final Map<String, Integer> valueTable = new HashMap<>();

    int visit(ASTNode node) {
        if (node instanceof BinaryOpNode) {
            int left = visit(((BinaryOpNode) node).leftNode);
            int right = visit(((BinaryOpNode) node).rightNode);
            switch (((BinaryOpNode) node).operationToken.type) {
                case ADDITION: {
                    return left - right;
                }
                case PLUS: {
                    return left + right;
                }
                case DIVISION: {
                    return left / right;
                }
                case MULTIPLY: {
                    return left * right;
                }
                default:
                    throw new ParserException("Unexpected token ");
            }
        } else if (node instanceof NumberNode) {
            return ((NumberNode) node).value;
        } else if (node instanceof VarDecl) {
            int rightExpressionResult = visit(((VarDecl) node).expression);
            valueTable.put(((VarDecl) node).varNode.name, rightExpressionResult);
            return rightExpressionResult;
        } else if (node instanceof Var) {
            String varName = ((Var) node).name;
            if (!valueTable.containsKey(varName)) {
                throw new ParserException("Variable not found " + varName);
            }
            return valueTable.get(varName);
        } else if (node instanceof Assign) {
            int rightExpression = visit(((Assign) node).right);
            valueTable.put(((Assign) node).left.name, rightExpression);
            return rightExpression;
        } else if (node instanceof Block) {
            int result = 0;
            for (ASTNode statement : ((Block) node).statements) {
                result = visit(statement);
            }
            return result;
        }else{
            return 0;
        }

    }
}
