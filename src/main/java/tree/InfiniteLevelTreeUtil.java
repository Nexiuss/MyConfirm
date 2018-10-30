/**
 * FileName: InfiniteLevelTreeUtil
 * Author:   Administrator
 * Date:     2018/10/27 10:08
 * Description:
 */
package tree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class InfiniteLevelTreeUtil {
    // 入口方法
    public static List<Node> getInfiniteLevelTree(List<Node> nodeList) {
        List<Node> list = new ArrayList<>();
        // 遍历节点列表
        for (Node node : nodeList) {
            if (node.getParentId().equals("-1")) {
                // parentID为-1（根节点）作为入口
                node.setChildren(getChildrenNode(node.getId(), nodeList));
                list.add(node);
            }
        }
        // 排序
        list.sort(new NodeOrderComparator());
        return list;
    }

    // 获取子节点的递归方法
    public static List<Node> getChildrenNode(String id, List<Node> nodeList) {
        List<Node> lists = new ArrayList<>();
        for (Node node : nodeList) {
            if (node.getParentId().equals(id)) {
                // 递归获取子节点
                node.setChildren(getChildrenNode(node.getId(), nodeList));
                lists.add(node);
            }
        }
        // 排序
        lists.sort(new NodeOrderComparator());
        return lists;
    }


    public static void main(String[] args) {
        Node n1 = new Node("0", "根节点", "-1", 0);
        Node n2 = new Node("01", "一级子节点", "0", 0);
        Node n3 = new Node("011", "二级子节点1", "01", 3);
        Node n4 = new Node("012", "二级子节点2", "01", 2);
        Node n5 = new Node("013", "二级子节点3", "01", 1);
        Node n6 = new Node("0131", "三级子节点1", "013", 1);
        Node n7 = new Node("0132", "三级子节点2", "013", 1);
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(n1);
        nodeList.add(n2);
        nodeList.add(n3);
        nodeList.add(n4);
        nodeList.add(n5);
        nodeList.add(n6);
        nodeList.add(n7);
        List<Node> infiniteLevelTree = InfiniteLevelTreeUtil.getInfiniteLevelTree(nodeList);

        String string = JSON.toJSONString(infiniteLevelTree);
        System.out.println(string);

        List<Node> childrenNode = getChildrenNode("01", nodeList);
        string = JSON.toJSONString(childrenNode);
        System.out.println(string);

    }

}
