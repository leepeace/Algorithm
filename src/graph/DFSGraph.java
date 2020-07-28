package graph;

import java.util.LinkedList;
import java.util.Stack;

class Graph{
	
	class Node{
		int data;
		LinkedList<Node> adjacent;//������ ������ ���踦 ǥ��
		boolean visited;//��� �湮�ߴ��� üũ
		Node(int data){
			this.data = data;
			this.visited = false;
			adjacent = new LinkedList<Node>();
		}
	}
	
	Node[] nodes;
	
	Graph(int size){
		nodes = new Node[size];
		for(int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	void addEdge(int i,int j) {//�� ����� ���踦 ����
		Node node1 = nodes[i];
		Node node2 = nodes[j];
		//������ ����Ʈ�� ��尡 �ִ��� Ȯ���ϰ� ������ �߰�
		if(!node1.adjacent.contains(node2)) {
			node1.adjacent.add(node2);
		}
		if(!node2.adjacent.contains(node1)) {
			node2.adjacent.add(node1);
		}
	}
	
	void dfs() {//���� �ε����� ���� ���� ���
		dfs(0);//0�� ������ ����
	}
	
	void dfs(int index) {//���� �ε����� ���� ���
		Node root = nodes[index];
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);//���� ��带 ���ÿ� �߰�
		root.visited = true;//�湮������ ǥ��
		
		while(!stack.isEmpty()) {
			Node r = stack.pop();
			for(Node n : r.adjacent) {//���ÿ��� pop�� ����� ������ ���� �߿���
				if(n.visited == false) {//�湮���� ���� ������ ���ÿ� �߰�
					n.visited = true;//�湮������ ǥ��
					stack.push(n);//�湮�� ��� �߰�
				}
			}
			PrintVisit(r);//��� ���
		}
	}
	
	void PrintVisit(Node node1) {
		System.out.print(node1.data + " ");
	}
	
}
public class DFSGraph {

	public static void main(String[] args) {
		/*
			0
		   /
		  1 -- 3    7
		  |  / | \ /
		  | /  |  5
		  2 -- 4   \
		   			6 -- 8
		*/
		Graph graphs = new Graph(9);
		graphs.addEdge(0, 1);
		graphs.addEdge(1, 2);
		graphs.addEdge(1, 3);
		graphs.addEdge(2, 4);
		graphs.addEdge(2, 3);
		graphs.addEdge(3, 4);
		graphs.addEdge(3, 5);
		graphs.addEdge(5, 6);
		graphs.addEdge(5, 7);
		graphs.addEdge(6, 8);
		
		graphs.dfs();
	}

}
