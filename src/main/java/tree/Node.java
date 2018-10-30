/**
 * FileName: Node
 * Author:   Administrator
 * Date:     2018/10/27 10:08
 * Description:
 */
package tree;

import java.util.ArrayList;
import java.util.List;

// 节点Bean
public class Node {
    private String id;
    private String name;
    private String parentId;
    private int order;
    private List<Node> children = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public Node(String id, String name, String parentId, int order) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.order = order;
    }
}
