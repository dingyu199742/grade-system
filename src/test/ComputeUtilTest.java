package test;

import java.util.Map;

import dao.ScoreDao;
import entity.Score;
import Util.ComputeUtil;

public class ComputeUtilTest {

	public static void main(String[] args) {
		//computingAvegrade
		ComputeUtil cu=new ComputeUtil();
		ScoreDao sd=new ScoreDao();
		Map<String, Score> map =sd.selectStuScoreOfMathToCompute("16160001078");
		double avegrade=cu.computingAvegrade(map);
		System.out.println(avegrade);

	}

}
