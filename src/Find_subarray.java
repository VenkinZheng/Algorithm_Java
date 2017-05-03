class CSub_Ret {
	public int left;
	public int right;
	public int array_sum;
	public String toString(){
		String ret = new String("Sub-Array left index is:"+left+".\n"
			+ "Sub-Array right index is:"+right+".\n"
			+ "Sub-Array sum is:"+array_sum+".\n");
		return ret;
	}
}

public class Find_subarray {
	static int min_val = (int)	Integer.MIN_VALUE;
	public static int [] sample_array = {13,-3,15,-25,-4,20,-3,-16,-23,18,20,-70,12,-50,7,-20,789};
	int[] B ;
	int count = 8000 ;   //array size for testing
	CSub_Ret tmp1;
	public Find_subarray(){
		B = new int[count];
		int r = Insertion_sort.gen_list(count, B);
		if(r==0){
			System.out.println("Failed to generate int array.");
		}
		tmp1 = new CSub_Ret();
	}

	public CSub_Ret find_crossing_subarray(int[] A, int low, int mid, int high){
		CSub_Ret cross_subarray_result = new CSub_Ret();
		int left_sum = min_val;
		int sum = 0;
		int max_left = mid;
		for(int i=mid; i>=low; i--){
			sum = sum + A[i];
			if(sum > left_sum){
				left_sum = sum;
				max_left = i;
			}
		}

		int right_sum = min_val;
		sum = 0;
		int max_right = mid;
		for(int j=mid+1; j<=high; j++){
			sum = sum + A[j];
			if(sum > right_sum){
				right_sum = sum;
				max_right = j;
			}
		}
		cross_subarray_result.array_sum = left_sum + right_sum;
		cross_subarray_result.left = max_left;
		cross_subarray_result.right = max_right;

		return cross_subarray_result;
	}
	
	public CSub_Ret find_max_subarray(int[] A, int low, int high){
		
		if(low==high){
			CSub_Ret end_result = new CSub_Ret();
			end_result.array_sum = A[low];
			end_result.left = low;
			end_result.right = high;

			return end_result;
		}
		else {
			int mid = (int) (low+high)/2;
			
			CSub_Ret left_result = new CSub_Ret();
			left_result = find_max_subarray(A, low, mid);
			
			CSub_Ret right_result = new CSub_Ret();
			right_result = find_max_subarray(A, mid+1, high);
			
			CSub_Ret cross_result = new CSub_Ret();
			cross_result = find_crossing_subarray(A, low, mid, high);
			
			if( left_result.array_sum >= right_result.array_sum 
					&& left_result.array_sum >= cross_result.array_sum){
				return left_result;
			}
			else if(right_result.array_sum >= left_result.array_sum 
					&& right_result.array_sum >= cross_result.array_sum){
				return right_result;
			}
			else {
				return cross_result;
			}
		}
	}
	
	public int get_sum(int[] A, int beg, int end){
		int sum = 0;
		for(int i=beg;i<=end;i++){
			sum += A[i];
		}
		return sum;
	}
	public CSub_Ret loop_find_max_subarray(int[] A){
		int beg=0;
		int end=A.length-1;
		CSub_Ret tmprst = new CSub_Ret();
		int max_sum=min_val;
		for(int i=beg;i<=end;i++){
			for(int j=i;j<=end;j++){
				int tmp_sum = get_sum(A,i,j);
				if(tmp_sum > max_sum){
					max_sum = tmp_sum;
					tmprst.left = i;
					tmprst.right = j;
					tmprst.array_sum = tmp_sum;
				}
			}
		}
		return tmprst;	
	}

	public void testFind_crossing_subarray() {
		long bct = System.currentTimeMillis();
		CSub_Ret test1 = find_max_subarray(B, 0, count-1);
		long ect = System.currentTimeMillis();
		long exectime = (ect-bct);
		System.out.println(test1);
		System.out.println("The Cross-Find Max Subarray of count: "+count+" , run time is:" + exectime);
		tmp1.left=test1.left;
		tmp1.right=test1.right;
		tmp1.array_sum=test1.array_sum;
	}

	public void testLoop_find_max_subarray() {
		long bct = System.currentTimeMillis();
		CSub_Ret test1 = loop_find_max_subarray(B);
		long ect = System.currentTimeMillis();
		long exectime = (ect-bct);
		System.out.println(test1);
		System.out.println("The Loop-Find Max Subarray of count: "+count+" , run time is:" + exectime);
		tmp1.left=test1.left;
		tmp1.right=test1.right;
		tmp1.array_sum=test1.array_sum;
	}

	public static void main(String[] args) {
		Find_subarray test_class =  new Find_subarray();
//		CSub_Ret test1 = test_class.find_max_subarray(sample_array, 0, sample_array.length-1);
//		System.out.println(test1);
//		CSub_Ret test2 = test_class.loop_find_max_subarray(sample_array);
//		System.out.println(test2);
		test_class.testFind_crossing_subarray();
		test_class.testLoop_find_max_subarray();;
	}

}
