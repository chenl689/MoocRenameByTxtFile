package tool;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;




public class Mytools 
{
		//readFileName
		public List<String> readFileName(String[] args,String url)
		{
			List<String> strings=new ArrayList<String>();
			File paFile=new File(url);
			String[] list;
			if (args.length==0) {
				list=paFile.list();
			}
			else {
				list=paFile.list(new DirFillter(args[0]));
			}
			for (String dirItem :list) {
				strings.add(dirItem);
			}
			return strings;
		}
		//readTxtFile
		public void readTxtFile(String url,int size,List<String> stringList) throws Exception {
			url=url+"\\新建文本文档.txt";
			List<String> strings=new ArrayList<String>();
			File file=new File(url);
			InputStreamReader inputStreamReader=new InputStreamReader(new FileInputStream(file),"UTF-8");
			BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
			String str;
			while((str=bufferedReader.readLine())!=null)
			{
				strings.add(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			contentSolve(strings, size,stringList,url);
		}
		//TxtContentSolve
		public void contentSolve(List<String> strings,int size,List<String> stringList,String url) {
			for(String string:strings)
			{
				if(string.length()>size)
				{
				String newstring=string.substring(size,string.length());
				String startName=newstring.substring(0, newstring.indexOf("+|+"));
				String overName=newstring.substring(startName.length()+3,newstring.length());
				renameFile(startName,overName,url,stringList);
				}
			}
		}
		//renameFile
		public void renameFile(String startName,String overName,String url,List<String> stringList) {
			url=url.substring(0,url.length()-11);
			for(String string:stringList)
			{
				if(string.equals(startName))
				{
//					System.out.println(url+"\\"+startName);
//					System.out.println(url+"\\"+overName+".mp4");
					File oldName=new File(url+"\\"+startName);
					File newName=new File(url+"\\"+overName+".mp4");
					if(oldName.renameTo(newName))
					{
						
					}else
					{
						System.out.println("file");
					}
				}
			}
		}
}

		class DirFillter implements FilenameFilter{
			private Pattern pattern;
			public DirFillter(String regex) {
				pattern=pattern.compile(regex);
			}
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
			
		}
