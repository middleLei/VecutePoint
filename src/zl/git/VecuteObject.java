package zl.git;

/**
 * 抽稀返回对象
 * 
 * @author zl
 * 
 */
public class VecuteObject extends Point {
	/**
	 * 初始化构造函数，数量设为1
	 */
	public VecuteObject() {
		this.sum = 1;
	}

	/**
	 * 抽稀后的数量，用来记录落在某一个小举行块内的总数
	 */
	private int sum;

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "数量：" + sum + ",X:" + getX() + ",Y:" + getY();
	}

}
