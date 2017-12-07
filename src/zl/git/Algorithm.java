package zl.git;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {

	private Algorithm() {
	}

	/**
	 * 抽稀函数
	 * 
	 * @param pList
	 *            抽稀的源数据
	 * @param m
	 *            抽稀的矩阵函数（m*n）
	 * @param n
	 *            抽稀的矩阵列数（m*n）
	 * @return
	 */
	public static List<VecuteObject> vecutePoints(List<VecuteObject> pList,
			int m, int n) {
		if (pList == null || m < 1 || n < 1)
			return vecute(null);
		double minX = Double.MAX_VALUE, maxX = 0;
		double minY = Double.MAX_VALUE, maxY = 0;
		double x, y;
		for (VecuteObject vo : pList) {// 第一次遍历，获取最大值和最小值，用于判断矩阵的间隔
			x = vo.getX();
			y = vo.getY();
			maxX = Math.max(x, maxX);
			minX = Math.min(x, minX);
			maxY = Math.max(y, maxY);
			minY = Math.min(y, minY);
		}
		double disX = (maxX - minX) / m;
		double disY = (maxY - minY) / n;
		VecuteObject[][] vecuteMatrix = new VecuteObject[m][n];// 抽稀矩阵，存放数据
		int i, j;// 计算这个点应该放在矩阵哪个位置
		VecuteObject point;
		for (VecuteObject vo : pList) {// 第二次遍历，抽稀
			i = (int) ((vo.getX() - minX) / disX);
			i = (i < m) ? i : m - 1;
			j = (int) ((vo.getY() - minY) / disY);
			j = (j < n) ? j : n - 1;
			point = vecuteMatrix[i][j];
			if (point == null)
				vecuteMatrix[i][j] = vo;
			else
				point.setSum(point.getSum() + 1);
		}
		return vecute(vecuteMatrix);
	}

	/**
	 * 将抽稀后的矩阵变成list返回
	 * 
	 * @param vecuteMatrix
	 *            需要抽稀的矩阵
	 * @return
	 */
	private static List<VecuteObject> vecute(VecuteObject[][] vecuteMatrix) {
		List<VecuteObject> reList = new ArrayList<>();// 抽稀后的数据
		if (vecuteMatrix == null)
			return reList;
		for (VecuteObject[] vos : vecuteMatrix) {
			for (VecuteObject vo : vos) {
				if (vo == null)
					continue;
				reList.add(vo);
			}
		}
		return reList;
	}
}
