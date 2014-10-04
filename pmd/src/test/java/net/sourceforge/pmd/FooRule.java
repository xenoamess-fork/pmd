/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package net.sourceforge.pmd;

import java.util.List;

import net.sourceforge.pmd.lang.Language;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.rule.AbstractRule;

/**
 * Sample rule that detect any node with an image of "Foo". Used for testing.
 */
public class FooRule extends AbstractRule {
    public FooRule() {
        setLanguage(Language.JAVA);
    }

    public String getMessage() {
        return "blah";
    }

    public String getName() {
        return "Foo";
    }

    public String getRuleSetName() {
        return "RuleSet";
    }

    public String getDescription() {
        return "desc";
    }

    @Override
    public void apply(List<? extends Node> nodes, RuleContext ctx) {
        for (Node node : nodes) {
            apply(node, ctx);
        }
    }

    protected void apply(Node node, RuleContext ctx) {
        for (int i = 0; i < node.jjtGetNumChildren(); i++) {
            apply(node.jjtGetChild(i), ctx);
        }
        if ("Foo".equals(node.getImage())) {
            addViolation(ctx, node);
        }
    }
}
