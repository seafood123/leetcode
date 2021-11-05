import java.util.Arrays;

class NumArray {
	public static int[] tree;
	public static int init;
    public NumArray(int[] nums) {
        init = init(nums.length);
        
        tree = new int[init*2];
        for(int i=0;i<nums.length;i++) {
        	tree[init+i] = nums[i];
        }
        makeTree(1,init, init*2-1);
    }
    
    public void update(int i, int val) {
        int now = init+i;
        int temp = tree[now];
        int diff = temp - val;
        
        while(now > 0) {
        	tree[now] -= diff;
        	now /= 2;
        }
        
        
    }
    
    public int sumRange(int i, int j) {
    	int sum = 0;
    	int start = init+i;
    	int end = init+j;
    	while(start<=end) {
    		if(start % 2 == 1) sum+=tree[start++];
    		if(end %2 == 0) sum+=tree[end--];
    		start /= 2;
    		end /= 2;
    	}
    	
        return sum;
    }
    
    public int init(int n) {
    	int init = 1;
    	while(init < n) {
    		init *= 2;
    	}
    	return init;
    }
    
    public int makeTree(int node, int start, int end) {
    	if(start >= end) {
    		return tree[node];
    	}
    	int mid = (start+end)/2;
    	return tree[node] = makeTree(node*2 ,start, mid ) + makeTree(node*2+1, mid+1, end);
    	
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

public class Solution1514{
	public static void main(String[] args) {
		NumArray arr = new NumArray(new int[] {1,3,5});
		System.out.println(Arrays.toString(arr.tree));
		System.out.println(arr.sumRange(0,2));
		arr.update(1, 2);
		System.out.println(arr.sumRange(0,2));
	}
}