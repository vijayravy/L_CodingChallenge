package lancopeGraph;

import java.util.ArrayList;
import java.util.List;

public class GNodeImpl implements GNode {
	private String id;
	private String name;
	private final List<GNode> children = new ArrayList<>();
	private final GNode parent;

	public GNodeImpl(GNodeImpl parent) {
		this.parent = parent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public List<GNode> getChildren() {
		return children;
	}
	
	public GNode getParent() {
		return parent;
	}

	@Override
	public String getName() {
		return name;
	}

}
