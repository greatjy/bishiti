package com.shenxinfu.bishi;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Point2d{ 
	public double x; 
	public double y; 
	public double getX() {return x;} 
	public void setX(double x){ this.x = x; }
	public double getY() { return y; }
	public void setY(double y) { this.y = y; } 
	public Point2d(double x, double y) { super(); this.x = x; this.y = y;} 
}  
public class DuoBianXingNeiBu 
{	
	public static void main(String[] args) 
	{ 	
		    //Point2d p = new Point2d(1.0, 2.4);
			List<Point2d> list = new ArrayList<Point2d>();
			//list.add(new Point2d(1.0, 2.0));
			//list.add(new Point2d(2.0, 3.0));
			//list.add(new Point2d(1.0, 1.0));
			//list.add(new Point2d(3.0, 5.0));
			//list.add(new Point2d(3.0, 2.0));
			// list为多边形边界,p为一个待测点
			Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			for(int i =0;i<n;i++)
			{
				list.add(new Point2d(in.nextDouble(), in.nextDouble()));
			}
			String string = in.nextLine();
			int m = in.nextInt();
			//System.out.println(m);
			int count = 0;
			for(int i=0;i<m;i++)
			{
				Point2d p = new Point2d(in.nextDouble(), in.nextDouble());
			    boolean flag = rayCasting(p, list);
			    if(flag)
			    {
			    	count++;
			    }
			}
			System.out.println(count);
	}
		/*
		 * p为待测点  list为多边形边界
		 */
		private static boolean rayCasting(Point2d p, List<Point2d> list) {
			double px = p.x, py = p.y;
			boolean flag = false;
			//
			for (int i = 0, l = list.size(), j = l - 1; i < l; j = i, i++) {
				 //取出边界的相邻两个点 
				double sx = list.get(i).x,
					   sy = list.get(i).y,
					   tx = list.get(j).x,
					   ty = list.get(j).y;
				// 点与多边形顶点重合
				if ((sx == px && sy == py) || (tx == px && ty == py)) {
					return false;
				}
				// 判断线段两端点是否在射线两侧
				//思路:作p点平行于y轴的射线 作s,t的平行线直线  如果射线穿过线段，则py的值在sy和ty之间  
				if ((sy < py && ty >= py) || (sy >= py && ty < py)) {
					// 线段上与射线 Y 坐标相同的点的 X 坐标 ,即求射线与线段的交点  
					double x = sx + (py - sy) * (tx - sx) / (ty - sy);
					// 点在多边形的边上
					if (x == px) {
						return false;
					}
					// 射线穿过多边形的边界
					if (x > px) {
						flag = !flag;
					}
				}
			}
			// 射线穿过多边形边界的次数为奇数时点在多边形内
			return flag ? true : false;
		}
		 
}
