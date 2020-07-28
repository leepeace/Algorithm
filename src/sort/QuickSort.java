package sort;

public class QuickSort {
	private static void quickSort(int[] array, int start, int end) {
		int p = partition(array, start, end);//피벗
		
		if(start < p - 1) {
			quickSort(array, start, p-1);
		}
		if(p < end) {
			quickSort(array, p, end);
		}
	}
	private static int partition(int[] array, int start, int end) {
		int pivot = array[(start + end) / 2];//배열의 중간 값을 피벗으로 둠
		
		while(start <= end) {
			while(array[start] < pivot) {//왼쪽 리스트에서 피벗보다 큰 값을 찾는다
				start++;
			}
			while(array[end] > pivot) {//오른쪽 리스트에서 피벗보다 작은 값을 찾는다
				end--;
			}
			if(start <= end) {
				swap(array,start,end);//찾은 값들을 서로 교환
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
		
		System.out.print("정렬 전 : ");
		PrintSort(array);//정렬 전 배열 출력
		
		quickSort(array, 0, array.length - 1);
		
		System.out.print("정렬 후 : ");
		PrintSort(array);//정렬 후 배열 출력
	}

}