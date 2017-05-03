package c02;

//import java.util.*;

public class Merge_sort {
	public Insertion_sort s1;
	public Merge_sort(){
		s1 = new Insertion_sort();
	}
	public void merge(int[] SA, int beg, int mid, int end){
		int n1 = mid - beg + 1;
		int n2 = end - mid;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for (int i=0;i<n1;i++){
			L[i] = SA[beg+i];
		}
		for (int j=0;j<n2;j++){
			R[j] = SA[mid+j+1];
		}
		int il=0;
		int ir=0;
		for (int k=beg;k<=end;k++){
//			System.out.println("Merge with b:" + beg +" k:"+ k +" e:"+ end+" il:"+il+" ir:"+ir+" n1:"+n1+" n2:"+n2);
			if(ir>=n2 || (il<n1 && L[il]<=R[ir]) ){
				SA[k] = L[il];
				il++;
			}
			else{
				SA[k] = R[ir];
				ir++;
			}
		}
	}
	public void sort_split(int[] SA, int beg, int end){
		int mid = 0;
		if(beg < end){
			mid = (int) (end + beg)/2;
//			System.out.println("Split with b:" + beg +" m:"+ mid +" e:"+ end);
			sort_split(SA, beg, mid);
			sort_split(SA, mid+1, end);
			merge(SA, beg, mid, end);
		}
	}
	
	public void test_SMS_BW(int count, int mod){
		long bct = System.currentTimeMillis();
		int[] B ;
		B = new int[count];
		int r = s1.gen_sorted_list(count, B, mod);
		if(r==0){
			System.out.println("Failed to generate int array.");
			return;
		}
		sort_split(B , 0, count-1);
		long ect = System.currentTimeMillis();
		long exectime = (ect-bct);
		if (mod == 1) {
			System.out.println("The best case of Split-Merge Sort of count: "+count+" , run time is:" + exectime);
		}
		else {
			System.out.println("The worst case of Split-Merge Sort of count: "+count+" , run time is:" + exectime);
		}
	}

	public void test_SMS(int count){
		long bct = System.currentTimeMillis();
		int[] B ;
		B = new int[count];
		int r = Insertion_sort.gen_list(count, B);
		if(r==0){
			System.out.println("Failed to generate int array.");
			return;
		}
		sort_split(B, 0, count-1);
		long ect = System.currentTimeMillis();
		long exectime = (ect-bct);
		System.out.println("test Split-Merge of count: "+count+" run time is:" + exectime);	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Merge_sort m1 = new Merge_sort();
		int count ;
		if ( args.length > 0 ){
			count = Integer.parseInt(args[0]);
			m1.test_SMS_BW(count, 1);
			m1.test_SMS_BW(count, 2);
			m1.test_SMS(count);
		}
		else{
			m1.test_SMS(10000);
		}
	}

}
