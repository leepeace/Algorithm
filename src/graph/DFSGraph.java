package graph;

import java.util.LinkedList;
import java.util.Stack;

class Graph{
	
	class Node{
		int data;
		LinkedList<Node> adjacent;//인접한 노드들의 관계를 표시
		boolean visited;//노드 방문했는지 체크
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
	
	void addEdge(int i,int j) {//두 노드의 관계를 저장
		Node node1 = nodes[i];
		Node node2 = nodes[j];
		//인접한 리스트에 노드가 있는지 확인하고 없으면 추가
		if(!node1.adjacent.contains(node2)) {
			node1.adjacent.add(node2);
		}
		if(!node2.adjacent.contains(node1)) {
			node2.adjacent.add(node1);
		}
	}
	
	void dfs() {//시작 인덱스를 받지 않은 경우
		dfs(0);//0번 노드부터 시작
	}
	
	void dfs(int index) {//시작 인덱스를 받은 경우
		Node root = nodes[index];
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);//현재 노드를 스택에 추가
		root.visited = true;//방문했음을 표시
		
		while(!stack.isEmpty()) {
			Node r = stack.pop();
			for(Node n : r.adjacent) {//스택에서 pop한 노드의 인접한 노드들 중에서
				if(n.visited == false) {//방문하지 않은 노드들을 스택에 추가
					n.visited = true;//방문했음을 표시
					stack.push(n);//방문한 노드 추가
				}
			}
			PrintVisit(r);//노드 출력
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
