package com.list.testing;

import com.example.doublylinkedist.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;

public class test {

	
	 int solution(int[] A, int X) {
	        int N = A.length;
	        if (N == 0) {
	            return -1;
	        }
	        int l = 0;
	        int r = N - 1;
	        while (l < r) {
	            int m = (int) Math.ceil((double) (l + r) / 2);
	            if (A[m] > X) {
	                r = m - 1;
	            } else {
	                l = m;
	            }
	        }
	        if (A[l] == X) {
	            return l;
	        }
	        return -1;
	    }
}
