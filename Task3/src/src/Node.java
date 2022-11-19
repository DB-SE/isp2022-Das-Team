package src;

import java.util.UUID;

public class Node {

	final UUID id;
	public Node() {
	this.id = UUID.randomUUID();
}
	
	public UUID getId() {
		return this.id;
	}
	
}
