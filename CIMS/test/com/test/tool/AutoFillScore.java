package com.test.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AutoFillScore {

	// 评委Id列表
	List<Integer> judgeList;
	// 选手Id列表
	List<Integer> playerList;
	// 赛事列表
	Integer raceId;
	// 评委评分详细
	List<Integer> standardList;

	public void init() {
		raceId = 10;
		judgeList = new ArrayList<Integer>();
		judgeList.addAll(Arrays.asList(new Integer[] { 11, 12, 13 }));
		playerList = new ArrayList<Integer>();
		playerList.addAll(Arrays.asList(new Integer[] { 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42}));
		standardList = new ArrayList<Integer>();
		standardList.addAll(Arrays.asList(new Integer[] { 36, 37, 38, 39, 40 }));
	}

	public static void main(String[] args) throws SQLException {
		AutoFillScore auto = new AutoFillScore();
		auto.init();
		auto.reset();
		auto.fill();
		System.out.println("done!");
	}

	public void fill() throws SQLException {

		String scoreSQLTemplate = "insert into cims_score(raceId,playerId,judgeId,score) values(%d,%d,%d,%d)";
		String scoreDetailSQLTemplate = "insert into cims_scoredetail(scoreId,standardId,score) values(%d,%d,%d)";
		String finalSQLTemplate = "update cims_finalscore set finalScore=%d where raceId=%d and playerId=%d";
		String drawSQLTemplate = "update cims_draw set scored='T' where raceId=%d and userId=%d";
		String liveScoreSQLTemplate = "update cims_livescore set liveScore=%d where raceId=%d and playerId=%d";

		String scoreSQL;
		String scoreDetailSQL;
		String finalSQL;
		String drawSQL;
		String liveScoreSQL;

		for (Integer player : playerList) {
			Integer finalScore = 0;
			List<Integer> livescore = new ArrayList<Integer>();
			for (Integer judge : judgeList) {
				List<Integer> scoreDetail = generateScore();
				Integer score = sum(scoreDetail);
				livescore.add(score);
				scoreSQL = String.format(scoreSQLTemplate, raceId, player, judge, score);
				Integer scoreId = executeSQLReturnKey(scoreSQL);
				for (int i = 0; i < standardList.size(); i++) {
					scoreDetailSQL = String.format(scoreDetailSQLTemplate, scoreId, standardList.get(i), scoreDetail.get(i));
					executeSQL(scoreDetailSQL);
				}
			}
			finalScore = computeExcludeMaxMinThenSum(livescore);
			liveScoreSQL = String.format(liveScoreSQLTemplate, finalScore, raceId, player);
			executeSQL(liveScoreSQL);
			finalSQL = String.format(finalSQLTemplate, finalScore, raceId, player);
			executeSQL(finalSQL);
			drawSQL = String.format(drawSQLTemplate, raceId, player);
			executeSQL(drawSQL);
		}
	}

	public Integer computeExcludeMaxMinThenSum(List<Integer> scorelist) {
		Integer max = 0, min = Integer.MAX_VALUE, result = 0;
		for (Integer i : scorelist) {
			result += i;
			if (max < i) {
				max = i;
			}
			if (min > i) {
				min = i;
			}
		}
		if (scorelist.size() >= 3) {
			result -= max;
			result -= min;
		}
		return result;
	}

	public void reset() throws SQLException {
		String sql = "TRUNCATE table cims_score;";
		executeSQL(sql);
		sql = "TRUNCATE table cims_scoredetail;";
		executeSQL(sql);
		sql = " update cims_finalscore set finalScore=0.0;";
		executeSQL(sql);
		sql = " update cims_livescore set liveScore=0.0;";
		executeSQL(sql);
		sql = " update cims_draw set scored='F';";
		executeSQL(sql);

	}

	public Integer sum(List<Integer> input) {
		Integer sum = 0;
		for (Integer i : input) {
			sum += i;
		}
		return sum;
	}

	public List<Integer> generateScore() {

		List<Integer> scoreDetails = new ArrayList<Integer>();
		for (int i = 0; i < standardList.size(); i++) {
			Random random = new Random(System.nanoTime());
			Integer tem = random.nextInt(21);
			scoreDetails.add(tem);
		}
		return scoreDetails;
	}

	public void executeSQL(String sql) throws SQLException {
		Connection conn = null;
		// MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
		// 避免中文乱码要指定useUnicode和characterEncoding
		String url = "jdbc:mysql://localhost:3306/cims?"
				+ "user=root&password=1232112321&useUnicode=true&characterEncoding=UTF8";

		try {
			// 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
			// 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
			Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
			// or:
			// com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
			// or：
			// new com.mysql.jdbc.Driver();

			// 一个Connection代表一个数据库连接
			conn = DriverManager.getConnection(url);
			// Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
			Statement stmt = conn.createStatement();

			stmt.execute(sql);

		} catch (SQLException e) {
			System.out.println("MySQL操作错误");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}

	public Integer executeSQLReturnKey(String sql) throws SQLException {
		Connection conn = null;
		// MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
		// 避免中文乱码要指定useUnicode和characterEncoding
		String url = "jdbc:mysql://localhost:3306/cims?"
				+ "user=root&password=1232112321&useUnicode=true&characterEncoding=UTF8";

		try {
			// 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
			// 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
			Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
			// or:
			// com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
			// or：
			// new com.mysql.jdbc.Driver();

			// 一个Connection代表一个数据库连接
			conn = DriverManager.getConnection(url);
			// Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
			Statement stmt = conn.createStatement();

			Integer key = -1;
			stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				key = rs.getInt(1);
			}
			return key;

		} catch (SQLException e) {
			System.out.println("MySQL操作错误");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return -1;
	}
}
