package zl.git;

import java.util.List;
import java.util.logging.Logger;

public class Main {
	private static Logger log;// 日志系统
	static {// 初始化日志为本地配置文件，否则条用jre/lib下的配置文件
		System.setProperty("java.util.logging.config.file",
				"logging.properties");
		log = Logger.getAnonymousLogger();
	}

	private Main() {
	}

	public static void main(String[] args) {
		Point cp = new Point();// 选一个中心点
		cp.setX(116.231);
		cp.setY(44.55231);
		List<VecuteObject> pList;// 抽稀目标集
		int pointNum = 500000;
		pList = new GeneratePoints().getTestPointList(cp, pointNum, 2.0);
		long startMillis = System.currentTimeMillis();
		pList = Algorithm.vecutePoints(pList, 100, 200);
		long endMillis = System.currentTimeMillis();
		for (Point point : pList) {
			log.info(point.toString());
		}
		log.warning(pointNum + "个点位抽稀后数据数量：" + pList.size());
		double timeSpan = (endMillis - startMillis) / 1000.0;
		log.warning(pointNum + "个点位抽稀消耗时间（秒）：" + timeSpan);
	}

}
