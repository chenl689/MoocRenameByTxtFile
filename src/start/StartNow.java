package start;

import java.util.Scanner;

import tool.Mytools;

public class StartNow {

	public static void main(String[] args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		System.out.println("输入保存文件名的文件的路径");
		String url=scanner.next();
		System.out.println("输入文件名前缀长度");
		int stringSize=scanner.next().length();
		Mytools mytools=new Mytools();
		mytools.readTxtFile(url, stringSize,mytools.readFileName(args, url));
	}

}
