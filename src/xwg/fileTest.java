package xwg;

/**
 * Created by xiongwenwu on 2016/9/18.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/9/8.
 */
public class fileTest {
    //文件转整数数组
    public List<List<Integer>> FileToIntergerArray() {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        try {
            FileReader reader = new FileReader("C:\\360极速浏览器下载\\aaa.txt");
            BufferedReader br = new BufferedReader(reader);
            String str = null;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
                List<Integer> row = new ArrayList<>();
                String[] rowString = str.split(" ");
                for (int i = 0; i < rowString.length; i++) {
                    row.add(Integer.parseInt(rowString[i]));
                }
                result.add(row);
            }
            System.out.println(result.get(0));

            br.close();
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //文件转字符串数组
    public List<String> FileToStringArray() {
        List<String> result = new ArrayList<>();
        try {
            FileReader reader = new FileReader("C:\\360极速浏览器下载\\aaa.txt");
            BufferedReader br = new BufferedReader(reader);
            String str = null;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
                result.add(str);
            }
            System.out.println(result.get(0));
            br.close();
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        new fileTest().FileToIntergerArray();
        new fileTest().FileToStringArray();

    }
}

