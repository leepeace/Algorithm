package queue;

import java.util.NoSuchElementException;

class Queue<T>{
	private Node<T> first;
	private Node<T> last;
	
	class Node<T>{
		private T data;
		private Node<T> next;//���� �������� �ּ�
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	public void add(T item) {//ť�� ������ ����
		Node<T> node1 = new Node<T>(item); 
		
		if(last != null) {
			last.next = node1;
		}
		last = node1;
		if(first == null) {
			first = last;
		}
	}
	
	public T remove() {//ť���� ������ ������
		if(first == null) {
			throw new NoSuchElementException();
		}
		T data = first.data;//ť�� �� �տ� ��ġ�� �����͸� ����
		first = first.next;
		
		if(first == null) {
			last = null;
		}
		return data;
	}
	
	public T peek() {//ť�� �� �տ� ��ġ�� ������ Ȯ��
		if(first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}
	
	public boolean isEmpty() {//ť�� ����ִ��� Ȯ��
		return first == null;
	}
	
}
public class Queue_Program {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		
		//������ ����
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
