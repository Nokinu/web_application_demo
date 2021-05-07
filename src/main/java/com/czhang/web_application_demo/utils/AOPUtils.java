package com.czhang.web_application_demo.utils;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.util.Objects;

public class AOPUtils {
    public static Object parseSpel(String key, Method method, Object[] args) {
        ExpressionParser expressionParser = new SpelExpressionParser();
        LocalVariableTableParameterNameDiscoverer localVariableTableParameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = localVariableTableParameterNameDiscoverer.getParameterNames(method);
        EvaluationContext evaluationContext = new StandardEvaluationContext();
        if(args.length == Objects.requireNonNull(parameterNames).length) {
            for(int i = 0; i < args.length; i++) {
                evaluationContext.setVariable(parameterNames[i], args[i]);
            }
        }
        return expressionParser.parseExpression(key).getValue(evaluationContext);
    }
}
