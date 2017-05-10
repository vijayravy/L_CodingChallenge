package lancopeGraph;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCountUtil {

	public static void main(String[] args) {
		String filename = "C:\\Users\\veravichandran\\Downloads\\lancope\\WordCount.txt";	
		String  pattern = "\"[^\"]*\"'";
		WordCountUtil wordUtil = new WordCountUtil();
		wordUtil.readFile(filename,pattern);
	}

	private void readFile(String filename,String pattern) {
		BufferedReader bufferedReader = null;
		Scanner scan = null;
		try {
			Map<String,Integer> wordCountMap = new HashMap<String,Integer>(20);
			bufferedReader = new BufferedReader(new FileReader(filename));
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				scan = new Scanner(line);
				while(scan.hasNextLine()){
				   line = scan.nextLine().replaceAll(pattern, "");
				}
				String[] tokens = line.split(" ");
				if(tokens != null && tokens.length >0){
					for(String token : tokens){
						token = token.toLowerCase();
						if(wordCountMap.containsKey(token)){
							Integer value = wordCountMap.get(token);
							if(value != null){
								value = value.intValue() + 1;
							}
							wordCountMap.put(token, value);
						}else{
							wordCountMap.put(token, new Integer(1));
						}
					}
				}
			}
			System.out.println(" Map Count"+wordCountMap);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				scan.close();
				bufferedReader.close();
			} catch (Exception e) {
				// Ignore
			}
		}
	}

}
