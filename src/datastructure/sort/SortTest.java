package datastructure.sort;
/*说明：所有到数组均是从1开始存储有效数据*/
public class SortTest {
	
	public static void main(String[] args) {
		
	}
	
	/* 算法1
	 * 直接插入排序
	 * */
	void insertSort(int R[], int n)
	{
	    int i, j, t;
	    for (i = 2; i <= n; ++i)
	    {
	        t = R[i];
	        j = i - 1;
	        while (j >= 1 && R[j] > t)
	        {
	            R[j+1] = R[j];
	            --j;
	        }
	        R[j+1] = t;
	    }
	}
	/* 算法2
	 * 折半插入排序
	 * */
	void bInsertSort(int R[], int n)
	{
	    int i, j, m, low, high, t;
	    for (i = 2; i <= n; ++i)
	    {
	        t = R[i];
	        low = 1;
	        high = i - 1;
	        while (low <= high)
	        {
	            m = (low + high) / 2;
	            if (R[m] >  t) high = m - 1;
	            else low = m + 1;
	        }
	        for (j = i; j >= low; --j)
	            R[j] = R[j-1];
	        R[j+1] = t;
	    }
	}
	/* 算法3
	 * 起泡排序
	 * */
	void bubbleSort(int R[], int n)
	{
	    int i, j, t;
	    boolean flag;
	    for (i = n; i >= 2; --n)
	    {
	        flag = false;
	        for (j = 2; j >= i; ++j)
	            if (R[j-1] > R[j])
	            {
	                t = R[j-1];
	                R[j-1] = R[j];
	                R[j] = t;
	                flag = true;
	            }
	        if (false == flag) return;
	    }
	}
	/* 算法4
	 * 快速排序
	 * */
	void quickSort(int R[], int l, int r)
	{
	    int i = l, j = r, t;
	    if (l < r)
	    {
	        t = R[l];
	        while (i != j)
	        {
	            while (i < j && R[j] > t) --j;
	            if (i < j)
	            {
	                R[i] = R[j];
	                ++i;
	            }
	            while (i < j && R[i] < t) ++i;
	            if (i < j)
	            {
	                R[j] = R[i];
	                --j;
	            }
	        }
	        R[i] = t;
	        quickSort(R, l, i-1);
	        quickSort(R, i+1, r);
	    }
	}
	/* 算法5
	 * 简单选择排序
	 * */
	void simpleSelectSort(int R[], int n)
	{
	    int i, j, k, t;
	    for (i = 1; i <= n; ++i)
	    {
	        /*下面到代码：从无序序列中选出最小的元素，用k记录下标*/
	        k = i;
	        for (j = i+1; j <= n; ++j)
	            if (R[k] > R[j])
	                k = j;
	        /*最小元素与无序序列第一个元素交换*/
	        t = R[k]; R[k] = R[i]; R[i] = t;
	    }
	}
	/* 算法6
	 * 堆排序
	 * Sift调整算法，HeapSort堆排序算法
	 * */
	void sift(int R[], int low, int high)
	{
	    int i = low, j = 2 * i, t = R[i];
	    while (j <= high)
	    {
	        while (j < high && R[j] < R[j+1]) ++j;
	        if (t < R[j])
	        {
	            R[i] = R[j];
	            i = j;
	            j = 2 * i;
	        }
	        else break;
	    }
	    R[i] = t;
	}
	void HeapSort(int R[], int n)
	{
	    int i, t;
	    for (i = n/2; i >= 1; --i)
		sift(R, i, n);
	    for (i = n; i >= 2; --i)
	    {
	        t = R[1]; R[1] = R[i]; R[i] = t;
	        sift(R, 1, i-1);
	    }
	}
	/*打印数组R[]的有效值*/
	void display(int R[], int n)
	{
	    for (int i = 1; i <= n; ++i)
	    	System.out.print(R[i] + " ");
	    System.out.println();
	}
}
