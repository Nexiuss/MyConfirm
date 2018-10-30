/**
 * FileName: NodeOrderComparator
 * Author:   Administrator
 * Date:     2018/10/27 10:09
 * Description:
 */
package tree;

import java.util.Comparator;

// 节点排序Comparator
public class NodeOrderComparator implements Comparator<Node> {
    // 按照节点排序值进行排序
    public int compare(Node n1, Node n2) {
        return (n1.getOrder() < n2.getOrder() ? -1 : (n1.getOrder() == n2.getOrder() ? 0 : 1));
    }
}