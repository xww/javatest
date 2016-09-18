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
import java.util.Stack;




class Step{
    int x,y,d;
    public Step(int x,int y,int d) {
        this.x = x;//横坐标
        this.y = y;//纵坐标
        this.d = d;//方向
    }
}

public class maze {

    //文件转整数数组 一共N+1行
    public static List<List<Integer>> FileToIntergerArray() {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        try {
            FileReader reader = new FileReader("aaa.txt");
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



    public static void main(String[] args) {
        // 迷宫定义
        List<List<Integer>> maze = FileToIntergerArray();
        int n = maze.get(0).get(0);//迷宫行
        int m = maze.get(0).get(1);//迷宫列
        int p = maze.get(0).get(2);//青蛙的体力
        maze.remove(0);  //去掉第一行，留下剩下的矩阵数据

        int[][] move = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        Stack s = new Stack();
        Stack s1 = new Stack();
        boolean result = path(maze, move, s,n,m,p);
        System.out.println(result);

    }
    public static boolean path(List<List<Integer>> maze,int[][] move,Stack s,int n, int m,int p){
        Step temp = new Step(1,1,-1); //起点
        s.push(temp);
        while(!s.isEmpty()){
            temp = (Step) s.pop();
            int x = temp.x;
            int y = temp.y;
            int d = temp.d+1;
            while(d<n){
                int i = x + move[d][0];
                int j = y + move[d][1];
                if(maze.get(i).get(j) == 1){    //该点可达
                    temp = new Step(i,j,d); //到达新点
                    if(j==1){
                        p-=1;
                    }
                    if(x==1){
                        p-=2;
                    }
                    s.push(temp);
                    x = i;
                    y = j;
                    maze.get(x).set(y,-1);  //到达新点，标志已经到达
                    if(x == 0 && y == m-1 && p>0){
                        return true;  //到达出口，迷宫有路，返回1
                    }else{
                        d = 0;  //重新初始化方向
                    }
                }else{
                    d++; //改变方向
                }
            }
        }
        return false;
    }
}

