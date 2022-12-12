package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import loader.PluginLoader;
import src.ConcreteGraph;
import src.Directed;
import src.Edge;
import src.IGraph;
import src.Node;
import interfaces.IAttribute;
import interfaces.IGraphAlgo;
import interfaces.ITraverseGraph;

public class Main {

	public static void main(String[] args) {
		
		List<ITraverseGraph> traverseAlgo = PluginLoader.load(ITraverseGraph.class);
		List<IGraphAlgo> graphAlfo = PluginLoader.load(IGraphAlgo.class);
		List<IAttribute> attributes = PluginLoader.load(IAttribute.class);
		Object data = null;
		
		for (ITraverseGraph tG:traverseAlgo) {
			tG.traverse();
		}
		for (IGraphAlgo gA:graphAlfo) {
			gA.getAdjacencyMatrix();
			gA.mst();
			gA.isDirected();
		}
		for (IAttribute as:attributes) {
			as.getData(data);
		}

	}
}
