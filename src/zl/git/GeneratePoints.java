package zl.git;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 获取测试点
 * 
 * @author zl
 * 
 */
public class GeneratePoints {
	/**
	 * 获取默认测试点
	 * 
	 * @param center
	 *            抽稀中心点，以该点作为中心朝四边扩散
	 * @param sum
	 *            生成的点数量
	 * @param dis
	 *            以center点作为中心随机范围,x 位于区间【center.x-dis，center.x+dis】，同y
	 * @return 生成的结果集
	 */

	public List<VecuteObject> getTestPointList(Point center, int sum, double dis) {
		List<VecuteObject> pointList = new ArrayList<>();
		double x = center.getX();
		double y = center.getY();
		Random rand = new Random(new Date().getTime());// 获取随机数
		VecuteObject vp;
		double span;
		for (int i = 0; i < sum; i++) {
			vp = new VecuteObject();
			span = rand.nextDouble() * dis;// 随机偏向x值
			// rd.nextBoolean()用来确定随机数是负数还是正数
			vp.setX(x + (rand.nextBoolean() ? span : -1 * span));// 随机x值
			span = rand.nextDouble() * dis;// 随机偏向y值
			vp.setY(y + (rand.nextBoolean() ? span : -1 * span));// 随机y值
			pointList.add(vp);
		}
		return pointList;
	}
}
