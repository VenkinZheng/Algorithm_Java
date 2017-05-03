package c02;

import java.util.*;

public class Insertion_sort {
	public int A[] = { 91,83,74,66,58,49,310,27,12,5,11 };
	static Random rand = new Random();
	
	public static int gen_list (int count, int[] ary1){
		if (count < 1){
			System.out.println("wrong value for count, must great than 1");
			return 0;
		}
		for (int i=0; i<count; i++){
			ary1[i] = rand.nextInt(2*count);
			if(rand.nextInt(2)==1){
				ary1[i] = - ary1[i];
			}
		}
		return 1;
	}

	public int gen_sorted_list (int count, int[] ary1, int ord){
		if (count < 1){
			System.out.println("wrong value for count, must great than 1");
			return 0;
		}
		if (ord == 1){
			for (int i=0; i<count; i++){
				ary1[i] = i;
			}
		}
		else if (ord == 2){
			for (int i=0; i<count; i++){
				ary1[count-1-i] = i;
			}
		}
		else
			return 0;
		return 1;
	}

	public void sort_asc (int[] A1, int ord){
		int n = A1.length;
		int j;
		int i;
		int key=A1[0];
		if (ord<1 || ord > 2){
			System.out.println("ord : 1 - sort in ascendent, 2 - sort in descendant \n");
			System.out.println("Wrong value input for ord, default value 1 will be taken. \n");
			ord = 1;
		}
		for (j=1;j<n;j++){
			key = A1[j];
			i = j-1;
			if (ord == 1) {
				while ( i >= 0 && A1[i] > key ) {
					A1[i+1] = A1[i];
					i--;
				}
			}
			else {
				while ( i >= 0 && A1[i] < key ) {
					A1[i+1] = A1[i];
					i--;
				}
			}
			A1[i+1] = key;
		}
	}


	public void selection_sort (int[] A1, int ord){
		int n = A1.length;
		int j;
		int i;
		int key=A1[0];
		int maxv,maxi;
		if (ord<1 || ord > 2){
			System.out.println("ord : 1 - sort in ascendent, 2 - sort in descendant \n");
			System.out.println("Wrong value input for ord, default value 1 will be taken. \n");
			ord = 1;
		}
		for (j=0;j<n;j++){
			key = A1[j];
			maxv = key;
			maxi = j;
			i = j;
//			if (ord == 1) {
				for ( i=j; i < n ; i++ ) {
					if ( A1[i] > maxv ) {
						maxv = A1[i];
						maxi = i;
					}
				}
//			}
//			else {
//				while ( i >= 0 && A1[i] < key ) {
//					A1[i+1] = A1[i];
//					i--;
//				}
//			}
			A1[j] = maxv;
			A1[maxi] = key;
		}
	}

	public void test_IS_BW(int count, int mod){
		long bct = System.currentTimeMillis();
		int[] B ;
		B = new int[count];
		int r = gen_sorted_list(count, B, mod);
		if(r==0){
			System.out.println("Failed to generate int array.");
			return;
		}
		sort_asc(B , 1);
		long ect = System.currentTimeMillis();
		long exectime = (ect-bct);
		if (mod == 1) {
			System.out.println("The best case of Insertion Sort of count: "+count+" , run time is:" + exectime);
		}
		else {
			System.out.println("The worst case of Insertion Sort of count: "+count+" , run time is:" + exectime);
		}

	}

	public void test_SS_BW(int count, int mod){
		long bct = System.currentTimeMillis();
		int[] B ;
		B = new int[count];
		int r = gen_sorted_list(count, B, mod);
		if(r==0){
			System.out.println("Failed to generate int array.");
			return;
		}
		selection_sort(B, 1);
		long ect = System.currentTimeMillis();
		long exectime = (ect-bct);
		if (mod == 1) {
			System.out.println("The best case of Selection Sort of count: "+count+" , run time is:" + exectime);
		}
		else {
			System.out.println("The worst case of Selection Sort of count: "+count+" , run time is:" + exectime);
		}

	}
/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		long bct = System.currentTimeMillis();
		Insertion_sort s1 = new Insertion_sort();
		if ( args.length > 0 ){
			int count = Integer.parseInt(args[0]);
			s1.test_IS_BW(count, 1);
			s1.test_IS_BW(count, 2);
			s1.test_SS_BW(count, 1);
			s1.test_SS_BW(count, 2);
		}
/*		int[] B ;
		if ( args.length > 0 ){
			int count = Integer.parseInt(args[0]);
			B = new int[count];
			int r = s1.gen_list(count, B);
			if(r==0){
				System.out.println("Failed to generate int array.");
				return;
			}
			s1.sort_asc(B , 1);
//			s1.selection_sort(B,1);
		}
/*		else{
			B=s1.A;
			s1.sort_asc(B , 1);
//			s1.selection_sort(B, 1);
		}
		long ect = System.currentTimeMillis();
		for(int i=0;i<B.length;i++){
			System.out.println(B[i]);
		}
		long exectime = (ect-bct);
		System.out.println("run time is:" + exectime);
*/
	}

}
