package Heap;

public class Heap {
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,8};
		int n = arr.length;
		int[] heap = new int[n];
		int val = 0;
		
		//form maxHeap
		for(int i=0;i<n;i++)
			addToHeap(arr[i],i,heap);
		
		int k = 2;
		//find nth greater element
		for(int i=0;i<k;i++)
			val = delete(heap);
		
		System.out.println(k+"largest element in heap"+val);
	}	
	
	private static int delete(int[] heap) {
		int maxVal = heap[0];
		int lastIndex = heap.length;
		swap(heap,0,lastIndex-1);
		int rootIndex = 0;
		while(rootIndex < lastIndex){
			int leftChild = rootIndex*2+1;
			int rightChild = rootIndex*2 + 2;
			
			if(leftChild < lastIndex && heap[rootIndex] < heap[leftChild]
					&& ( rightChild >= lastIndex 
							|| heap[leftChild] > heap[rightChild])){
				swap(heap,rootIndex,leftChild);
				rootIndex = leftChild;	
					
			}else if(rightChild < lastIndex && heap[rootIndex] < heap[rightChild]){
				swap(heap,rootIndex,rightChild);
				rootIndex = rightChild;
			}else{
				break;
			}
				
		}
		return maxVal;
	}

	public static void addToHeap(int val,int lastIndex,int[] heap){
		heap[lastIndex] = val;
		maximizeHeap(heap,lastIndex);
	}

	private static void maximizeHeap(int[] heap, int lastIndex) {
		int rootIndex = lastIndex;
		while(rootIndex > 0){
			rootIndex = lastIndex / 2;
			
			if(heap[rootIndex] > heap[lastIndex]){
				break;
			}else{
				swap(heap,rootIndex,lastIndex);
				lastIndex = rootIndex;
			}
		}
	}

	private static void swap(int[] heap, int rootIndex, int lastIndex) {
		int temp = heap[rootIndex];
		heap[rootIndex] = heap[lastIndex];
		heap[lastIndex] = temp;
	}
	

}
