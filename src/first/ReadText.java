package first;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

//テキストを読み込み、２次元配列に格納するメソッドを定義するクラス
public class ReadText {
	private int count1, count2;
	//private Object[][] data2;
	private String[][] data3;
	
	// readTextコンストラクタ
	ReadText(String url) {
		try {
			File file = new File(url);
			BufferedReader br1 = new BufferedReader(new FileReader(file));
			StringTokenizer st1, st2;
			count1 = 0;
			count2 = 0; // countの初期化
			String tmp;
			while ((tmp = br1.readLine()) != null) {
				st1 = new StringTokenizer(tmp);
				count2 = 0;
				while (st1.hasMoreTokens()) {
					st1.nextToken();
					count2++;
				}
				count1++;
			}
			System.out.println("count1:" + count1 + ",count2:" + count2);
			br1.close();
			BufferedReader br2 = new BufferedReader(new FileReader(file));
			String tmp_str;
			//data2 = new Object[count1][count2];
			data3 = new String[count1][count2];
			int i = 0;
			while ((tmp_str = br2.readLine()) != null) {
				st2 = new StringTokenizer(tmp_str);
				int j = 0;
				while (st2.hasMoreTokens()) {
					String stn = String.valueOf(st2.nextToken());
					//Object obj = stn;
					data3[i][j] = stn;
					//data2[i][j] = obj;
					j++;
				}
				System.out.println("");
				i++;
			}
			br2.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	// 配列data2の中身を確認するデバッグ用のメソッド
	public void showData() {
		for (int i = 0; i < count1; i++) {
			for (int j = 0; j < count2; j++) {
				//System.out.print(data2[i][j]);
				System.out.print(data3[i][j]);
			}
		}
	}

	public String[][] getData(){
		return data3;
	}
	
	/*
 * 	// 実際に配列data2を得る出力用のメソッド

	public Object[][] getData() {
		return data2;
	}
*/
	
	// 読み込んだテキスト行列（配列data2）の行数を取得するメソッド
	public int getCount1() {
		return count1;
	}

	// 読み込んだテキスト行列(配列data2)の列数を取得するメソッド
	public int getCount2() {
		return count2;
	}

}
