import java.util.Arrays;
public class BinaryHeap
{
	int[] array;
	int size=0;
	/*
	*Shifts everything down.
	*/
	public BinaryHeap()
	{
		array= new int[10];
	}
	public void shiftd(int parent)
	{
		int child=parent*2+1;
		if (child<size)
		{
			if ((child+1)<size&&array[child+1]<array[child])
				child=child+1;
			if(array[parent]>array[child])
			{
				swap(array,child,parent);
				shiftd(child);
			}
		}


	}/*
	*Grows the array.
	*/
	public void growarray()
	{
		// arr.size*2 so you double it. 
		int temp[]= new int[array.length*2];
		for (int x=0;x<array.length;x++)
		{
			temp[x]=array[x];
		}
		array=temp;
	}
	/*
	*swaps two ints.
	*/
	public void swap(int[] arr,int parent,int child)
	{
		int temp=arr[child];
		arr[child]=arr[parent];
		arr[parent]=temp;
	}

	/*
	*adds to the queue
	*/
	public void add(int x)
	{
		//size++;
		if(size==array.length)
		{
			growarray();
		}
		array[size++]=x;
		int child=size-1;
		int parent=(child-1)/2;
		while(parent>=0&&array[parent]>array[child])
		{
			swap(array,parent,child);
			child=parent;
			parent=(child-1)/2;

		}

	}
	public void print()
	{
		System.out.println(Arrays.toString(array));
	}
	/*
	*removes item from the queue.
	*Throws exception if empty.
	*/
	public int remove()
	{
		int temp=array[0];
		array[0]=array[--size];
		shiftd(0);
		return temp;
	}

}