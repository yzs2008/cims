package com.test.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.apache.commons.lang3.time.StopWatch;

public class SortFile {

	int max = 9999999;
	// int max = 10;

	// 数据源
	int[] data = new int[max];
	// 辅助空间
	int[] count = new int[max];

	public SortFile() {
		Random random = new Random();
		// 初始化数据
		for (int i = 0; i < max; i++) {
			data[i] = random.nextInt(max);
			count[i] = 0;
		}
	}

	public static void main(String[] args) throws Exception{

		SortFile sortFile = new SortFile();
		sortFile.showResult(0);
		StopWatch stopWatch=new StopWatch();
		stopWatch.start();
		sortFile.sort();
		stopWatch.stop();
		long span= stopWatch.getTime();
		System.out.println(span);
		sortFile.showResult(1);
	}

	private void doSort(int target) {
		if (data[target] == -1) {
			data[target] = target;
			++count[target];
			return;
		}
		if (data[target] == target) {
			++count[target];
			return;
		}
		int tem = data[target];
		data[target] = target;
		++count[target];
		doSort(tem);
	}

	public void sort() {
		// 排序算法
		for (int i = 0; i < max; i++) {

			int target = data[i];
			if (target == i) {
				if (count[i] == 0) {
					++count[i];
				}
			} else {
				data[i] = -1;
				doSort(target);
			}
		}

		adjustResult();
	}

	private void adjustResult() {
		int[] result = new int[max];
		int k = 0;
		for (int i = 0; i < max; i++) {
			if (data[i] != -1) {
				for (int j = 0; j < count[i]; j++) {
					result[k++] = data[i];
				}
			}
		}
		data = result;
	}

	private long flag;

	public void showResult(int model) throws Exception {
		String path="H:\\interim\\";
		if (model == 0) {
			flag = System.currentTimeMillis();
			path+=String.valueOf(flag) + "_data.txt";
		} else {
			path+=String.valueOf(flag) + "_result.txt";
		}
		File file =new File(path);
		if(file.exists()){
			file.delete();
		}
		file.createNewFile();
		FileOutputStream outPut = new FileOutputStream(file);
		PrintStream print = new PrintStream(outPut);
		for (int i = 0; i < data.length; i++) {
			print.print(data[i]);
		}
		outPut.close();
	}
}
