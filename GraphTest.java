package lancopeGraph;

import java.util.ArrayList;
import java.util.List;

public class GraphTest {

	public static void main(String[] args) {
		List<String> printUniqueList = new ArrayList<>();
		GNodeImpl treeRootGNode = new GNodeImpl(null);
		treeRootGNode.setId("root-A");
		
		// add child to root GNode
		GNodeImpl childBNode = addChild(treeRootGNode, "child-B");
		// add child to the child GNode created above
		addChild(childBNode, "child-E");
		addChild(childBNode, "child-F");

		// add child to root GNode
		GNodeImpl childCNode = addChild(treeRootGNode, "child-C");
		// add child to the child node created above
		addChild(childCNode, "child-G");
		addChild(childCNode, "child-H");
		addChild(childCNode, "child-I");
		// add child to root GNode
		GNodeImpl childDNode = addChild(treeRootGNode, "child-D");
		// add child to the child node created above
		addChild(childDNode, "child-J");
		
		// add child for removing duplicate test
		addChild(childDNode, "child-I");
						
	/*	// test 4th level
				GNodeImpl childFNode = addChild(childBNode, "child-F");
				// add child to the child node created above
				addChild(childFNode, "child-J");*/
				
		System.out.println("All the non-duplicate Nodes in the graph are : ");
		System.out.println();
		walkGraph(treeRootGNode, " ", printUniqueList);
		// printPath(treeRootGNode,root,child);
		System.out.println();
		System.out.println();
		paths(treeRootGNode);
	}

	private static GNodeImpl addChild(GNodeImpl parent, String id) {
		GNodeImpl node = new GNodeImpl(parent);
		node.setId(id);
		// System.out.println("parent.getChildren()
		// :Size:"+parent.getChildren().size());
		parent.getChildren().add(node);
		return node;
	}

	private static List<String> walkGraph(GNode node, String appender, List<String> printUniqueList) {
		if (!printUniqueList.contains(node.getId())) {
			System.out.println(appender + node.getId());
			printUniqueList.add(node.getId());
		}
		for (GNode each : node.getChildren()) {
			walkGraph(each, appender + appender, printUniqueList);
		}
		return printUniqueList;
	}
	
	
	public static ArrayList<ArrayList<GNode>> paths(GNode node) {
		ArrayList<ArrayList<GNode>> allPaths = new ArrayList<ArrayList<GNode>>();
		allPaths.addAll(allPaths(node));
		
		System.out.println("Paths (A) : ");
		System.out.println();
		for (ArrayList<GNode> path: allPaths) {
			
			System.out.print("{");
			for (GNode each: path) {
				System.out.print("  "+each.getId()+"  ");
			}
			System.out.print("}");
			System.out.println();
		}
		
		return allPaths;
	}
	
	private static ArrayList<ArrayList<GNode>> allPaths (GNode node) {
		ArrayList<GNode> children = new ArrayList<GNode>(node.getChildren());
		ArrayList<ArrayList<GNode>> currentPaths = new ArrayList<ArrayList<GNode>>();  
		if (children.size()!=0) {
			for (GNode child : children) {
				currentPaths.addAll(allPaths(child));
			}
			for (ArrayList<GNode> paths: currentPaths) {
				//System.out.println(paths.toString());
				paths.add(0, node);
			}
		}
		else {
			ArrayList<GNode> thisPath = new ArrayList<GNode>();
			thisPath.add(node);
			currentPaths.add(thisPath);
		}
		
		
		return currentPaths;
	
	}
	
}
