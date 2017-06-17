package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinaryTreeNode;
import com.interview.utils.ArrayUtil;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-26
 * Time: 下午12:14
 */
public class C5_8A_RebuildTreeTest extends TestCase {
    String preOrder = "/+a*b-cd:ef";
    String inOrder = "a+b*c-d/e:f";
    String postOrder = "abcd-*+ef:/";
    /**
     *       /
     *      / \
     *     +   :
     *    / \ / \
     *   a  * e f
     *      /\
     *     b  -
     *       / \
     *      c   d
     */
    public void testBuildTreeFromPREIN() throws Exception {
        final StringBuilder builder = new StringBuilder();
        C5_8A_RebuildTree treeBuilder = new C5_8A_RebuildTree<Character>();
        BinaryTreeNode<Character> root = treeBuilder.rebuild(
                ArrayUtil.getCharArray(preOrder),
                ArrayUtil.getCharArray(inOrder),
                C5_8A_RebuildTree.PRE_IN);
        C5_1_TreeTraverse.traverseByPostOrder(root, new Processor<Character>() {
            @Override
            public void process(Character element) {
                builder.append(element);
            }
        });
        String postOrder = builder.toString();
        assertEquals(this.postOrder, postOrder);
    }

    public void testBuildTreeFromPOSTIN() throws Exception {
        final StringBuilder builder = new StringBuilder();
        C5_8A_RebuildTree treeBuilder = new C5_8A_RebuildTree<Character>();
        BinaryTreeNode<Character> root = treeBuilder.rebuild(
                ArrayUtil.getCharArray(postOrder),
                ArrayUtil.getCharArray(inOrder),
                C5_8A_RebuildTree.POST_IN);
        C5_1_TreeTraverse.traverseByPreOrder(root, new Processor<Character>() {
            @Override
            public void process(Character element) {
                builder.append(element);
            }
        });
        String preOrder = builder.toString();
        assertEquals(this.preOrder, preOrder);
    }
}
