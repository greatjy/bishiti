package com.huawei.bishi;

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String string = in.nextLine();
		// System.out.println(string);
		String[] line = string.split(",");
		String s1 = line[0].substring(1, line[0].length());
		String s2 = line[1].substring(0, line[1].length() - 1);
		int x = Integer.valueOf(s1);
		int y = Integer.valueOf(s2);
		int dir = Integer.valueOf(line[2]);
		int point = Integer.valueOf(line[3]);
		// System.out.println(""+x+y+dir+point);
		int[][] route = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String[] route1 = in.nextLine().split(",");
			for (int j = 0; j < 9; j++) {
				route[i][j] = Integer.valueOf(route1[j]);
			}
		}

		if(findBao(x, y, dir, point, route)== -1)
		{
			System.out.println("roadlessness");
		}
		if(findBao(x, y, dir, point, route)==-2)
		{
			System.out.println("nothing");
		}
		if(findBao(x, y, dir, point, route)==0)
		{
			System.out.println("eureka");
		}

	}

	private static int findBao(int x, int y, int dir, int point, int[][] route) {
		System.out.println(x + " " + y + " " + point + " " + dir + " ");
		if (point == 0 && route[x][y] != 9 || point <0) {
			return -2;
		}
		if (x < 0 || x >= 9 || y < 0 || y >= 9) {
			return -1;
		}
		if (route[x][y] == 9) {
			//System.out.println("haha");
			return 0;
		}
		if (dir == 6) {
			if(y+1 <0 || y+1 >9)
				return -1;
			if (route[x][y + 1] == 0) {
				findBao(x, y + 1, dir, point - 1, route);
			} else if (route[x][y + 1] == 1) {
				findBao(x, y + 1, dir, point - 3, route);
			} else if (route[x][y + 1] == 5) {
				if(y+3 > 9)
					return -1;
				if(route[x][y+2] == 9 || route[x][y+3] == 9)
					return 0;
				findBao(x, y + 3, dir, point - 3, route);
			} else {
				findBao(x, y + 1, route[x][y+1], point - 1, route);
			}

		} 
		else if (dir == 8) {
			if(0>x-1 || x-1 > 9)
				return -1;
			if (route[x-1][y] == 0) {
				findBao(x-1, y, dir, point - 1, route);
			} else if (route[x-1][y] == 1) {
				findBao(x-1, y, dir, point - 3, route);
			} else if (route[x-1][y] == 5) {
				if(x-4 < 0)
					return -1;
				if(route[x-2][y] == 9 || route[x-3][y] == 9)
					return 0;
				findBao(x-3, y, dir, point - 3, route);
			} else {
				findBao(x-1, y, route[x - 1][y], point - 1, route);
			}

		}else if (dir == 2) {
			if(0> x+1 || x+1 >9)
				return -1;
			if (route[x+1][y] == 0) {
				findBao(x+1, y, dir, point - 1, route);
			} else if (route[x+1][y] == 1) {
				findBao(x+1, y, dir, point - 3, route);
			} else if (route[x+1][y] == 5) {
				if(x+3 > 9)
					return -1;
				if(route[x+2][y] == 9 || route[x+3][y] == 9)
					return 0;
				findBao(x+3, y, dir, point - 3, route);
			} else {
				findBao(x+1, y, route[x+1][y], point - 1, route);
			}

		} 
		else if (dir == 4) {
			if(0>y-1 || y-1 >9)
				return -1;
			if (route[x][y - 1] == 0) {
				findBao(x, y - 1, dir, point - 1, route);
			} else if (route[x][y - 1] == 1) {
				findBao(x, y - 1, dir, point - 3, route);
			} else if (route[x][y - 1] == 5) {
				if(y-3 <0 )
					return -1;
				if(route[x][y-2] == 9 || route[x][y-3] == 9)
					return 0;
				findBao(x, y - 3, dir, point - 3, route);
			} else {
				findBao(x, y - 1, route[x][y-1], point - 1, route);
			}

		} 

		return 0;
	}
}
