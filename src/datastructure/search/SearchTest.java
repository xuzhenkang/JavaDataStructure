package datastructure.search;

public class SearchTest {
	
	public static void main(String[] args) {
		
	}
	
	/** 算法1
	顺序查找
	此算法适用于线性表（包括顺序表和链表）
	*/
	public int search(int R[], int n, int key) {
		for (int i = 1; i <= n; i++) {
			if (R[i] == key) return i;
		}
		return 0;
	}
	/* 算法2
	折半查找
	*/
	public int bSearch(int R[], int low, int high, int key)
	{
	    int mid;
	    while (low <= high)
	    {
	        mid = (low + high) / 2;
	        if (R[mid] > key) high = mid - 1;
	        else if (R[mid] < key) low = mid + 1;
	        else return mid;
	    }
	    return 0;
	}
	/*算法3
	二叉排序树查找关键字的算法
	*/
	public BTNode bstSearch(BTNode bt, int key)
	{
	    if (null == bt)
	        return null;
	    else if (bt.key == key)
	        return bt;
	    else if (bt.key > key)
	        return bstSearch(bt.left, key);
	    else
	        return bstSearch(bt.right, key);
	}

	/*算法4
	二叉排序树插入关键字的算法
	*/
	public boolean bstInsert(BTNode bt, int key)
	{
	    if (null == bt)
	    {
	        bt = new BTNode();
	        bt.left = bt.right = null;
	        bt.key = key;
	        return true;
	    }
	    else if (key == bt.key)
	        return false;
	    else if (key > bt.key)
	        return bstInsert(bt.right, key);
	    else
	        return bstInsert(bt.left, key);
	}
	/*算法5
	判断一棵二叉树是否为二叉排序树
	*/
	int pre = -1;
	public boolean judBST(BTNode bt)
	{
	    if (null == bt)
	        return true;
	    else
	    {
	        if (!judBST(bt.left) || pre > bt.key)
	            return false;
	        pre = bt.key;
	        return judBST(bt.right);
	    }
	}
	/*算法6
	创建二叉排序树
	*/
	public void createBST(BTNode bt, int key[], int n)
	{
	    bt = null;
	    for (int i = 1; i <= n; ++i)
	    {
	    	System.out.println("插入key[" + i + "] = " + key[i]);
	        bstInsert(bt, key[i]);
	        System.out.println("插入完毕");
	    }
	}
	
	
}
