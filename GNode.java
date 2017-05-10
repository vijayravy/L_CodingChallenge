package lancopeGraph;

import java.util.List;

public interface GNode {
	public List<GNode> getChildren();

	public GNode getParent();

	public String getId();

	public String getName();
}