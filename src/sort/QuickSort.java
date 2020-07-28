package sort;

public class QuickSort {
	private static void quickSort(int[] array, int start, int end) {
		int p = partition(array, start, end);//�ǹ�
		
		if(start < p - 1) {
			quickSort(array, start, p-1);
		}
		if(p < end) {
			quickSort(array, p, end);
		}
	}
	private static int partition(int[] array, int start, int end) {
		int pivot = array[(start + end) / 2];//�迭�� �߰� ���� �ǹ����� ��
		
		while(start <= end) {
			while(array[start] < pivot) {//���� ����Ʈ���� �ǹ����� ū ���� ã�´�
				start++;
			}
			while(array[end] > pivot) {//������ ����Ʈ���� �ǹ����� ���� ���� ã�´�
				end--;
			}
			if(start <= end) {
				swap(array,start,end);//ã�� ������ ���� ��ȯ
				start++;
				end--;
			}
		}
		
		return start;
	}
	private static void swap(int[] array, int start, int end) {
		int temp;
		temp = array[start];
		array[start] = array[end];
		array[end] = temp;
	}
	private static void PrintSort(int[] array) {
		for(int data : array) {
			System.out.print(data + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {2,9,5,3,4,7,1,8};
		
		System.out.print("���� �� : ");
		PrintSort(array);//���� �� �迭 ���
		
		quickSort(array, 0, array.length - 1);
		
		System.out.print("���� �� : ");
		PrintSort(array);//���� �� �迭 ���
	}

}