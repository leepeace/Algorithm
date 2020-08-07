package queue;

import java.util.NoSuchElementException;

class Queue<T>{
	private Node<T> first;
	private Node<T> last;
	
	class Node<T>{
		private T data;
		private Node<T> next;//다음 데이터의 주소
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	public void add(T item) {//큐에 데이터 삽입
		Node<T> node1 = new Node<T>(item); 
		
		if(last != null) {
			last.next = node1;
		}
		last = node1;
		if(first == null) {
			first = last;
		}
	}
	
	public T remove() {//큐에서 데이터 꺼내기
		if(first == null) {
			throw new NoSuchElementException();
		}
		T data = first.data;//큐의 맨 앞에 위치한 데이터를 꺼냄
		first = first.next;
		
		if(first == null) {
			last = null;
		}
		return data;
	}
	
	public T peek() {//큐의 맨 앞에 위치한 데이터 확인
		if(first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}
	
	public boolean isEmpty() {//큐가 비어있는지 확인
		return first == null;
	}
	
}
public class Queue_Program {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		
		//데이터 삽입
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.isEmpty());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.isEmpty());
	}

}
