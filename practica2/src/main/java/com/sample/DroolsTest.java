package com.sample;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
            // go !
            Node a = new Node();
            a.setValue("A");
            a.setStatus(Node.NOT_VISITED);
            Node b = new Node();
            b.setValue("B");
            b.setStatus(Node.NOT_VISITED);
            Node c = new Node();
            c.setValue("C");
            c.setStatus(Node.NOT_VISITED);
            Node d = new Node();
            d.setValue("D");
            d.setStatus(Node.NOT_VISITED);
            Node e = new Node();
            e.setValue("E");
            e.setStatus(Node.NOT_VISITED);
            Node f = new Node();
            f.setValue("F");
            f.setStatus(Node.NOT_VISITED);
            Node g = new Node();
            g.setValue("G");
            g.setStatus(Node.NOT_VISITED);
            Node h = new Node();
            h.setValue("H");
            h.setStatus(Node.NOT_VISITED);
            
            Edge ab = new Edge();
            ab.setInitialNode(a);
            ab.setEndNode(b);
            
            Edge bc = new Edge();
            bc.setInitialNode(b);
            bc.setEndNode(c);
            
            Edge cd = new Edge();
            cd.setInitialNode(c);
            cd.setEndNode(d);
            
            Edge dg = new Edge();
            dg.setInitialNode(d);
            dg.setEndNode(g);

            Edge gh = new Edge();
            gh.setInitialNode(g);
            gh.setEndNode(h);

            Edge de = new Edge();
            de.setInitialNode(d);
            de.setEndNode(e);

            Edge ef = new Edge();
            ef.setInitialNode(e);
            ef.setEndNode(f);

            Edge fa = new Edge();
            fa.setInitialNode(f);
            fa.setEndNode(a);
            
            Path p = new Path();
            p.setIni(h);
            p.setFin(a);
            
            kSession.insert(p);
            kSession.insert(a);
            kSession.insert(b);
            kSession.insert(c);
            kSession.insert(d);
            kSession.insert(e);
            kSession.insert(f);
            kSession.insert(g);
            kSession.insert(h);
            kSession.insert(ab);
            kSession.insert(bc);
            kSession.insert(cd);
            kSession.insert(de);
            kSession.insert(ef);
            kSession.insert(fa);
            kSession.insert(dg);
            kSession.insert(gh);
            
            kSession.fireAllRules();
            
            if (true) {
            	
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    public static class Node {
    	
    	public static final int NOT_VISITED = 0;
    	public static final int VISITED = 1;
    	
    	private String value;
    	
    	private int status;
    	
    	public String getValue() {
			return value;
		}
    	
    	public void setValue(String value) {
			this.value = value;
		}
    	
    	public int getStatus() {
			return status;
		}
    	
    	public void setStatus(int status) {
			this.status = status;
		}
    	
    	@Override
    	public boolean equals(Object o) {
    		if (this == o) { return true; }
            if (o == null || getClass() != o.getClass()) { return false; }
            Node node1 = (Node) o;
            
            if (value != null ? !value.equals(node1.value) : node1.value != null) { return false; }
    		
            return true;
    	}
    	
    	@Override
    	public String toString() {
    		String str = "VALUE: " + this.value + " ; " + "Status: " + this.status;
    		return str;
    	}
    	
    }
    
    public static class Edge {
    	private Node initialNode;
    	private Node finalNode;
    	
    	public Node getInitialNode() {
			return initialNode;
		}
    	
    	public void setInitialNode(Node initialNode) {
			this.initialNode = initialNode;
		}
    	
    	public Node getFinalNode() {
			return finalNode;
		}
    	
    	public void setEndNode(Node finalNode) {
			this.finalNode = finalNode;
		}
    	
    	@Override
    	public String toString() {
    		String str = "Node INIT: " + this.getInitialNode().toString() +
    				 	"\n" + "Node FIN: " + this.getFinalNode();
    		return str;
    	}
    	
    }
    
    
    public static class Path {
    	
    	private Node ini;
    	private Node fin;
    	private List <Edge> path;
    	
    	public Path() {
			this.path = new ArrayList<Edge>();
		}
    	
    	public Node getIni() {
			return ini;
		}
    	
    	public void setIni(Node ini) {
			this.ini = ini;
		}
    	
    	public Node getFin() {
			return fin;
		}
    	
    	public void setFin(Node fin) {
			this.fin = fin;
		}
    	
    	public List<Edge> getPath() {
			return path;
		}
    	
    	public void setPath(List<Edge> path) {
			this.path = path;
		}
    	
    	@Override
    	public String toString() {
    		String str = "PATH:\n ";
    		for (Edge e : this.path) {
    			str += "\n" + e.toString() + "\n ";
    		}
    		return str;
    	}
    }
}
