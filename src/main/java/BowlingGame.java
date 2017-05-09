package main.java;

/**
 * Created by pig on 2017/5/4.
 */
public class BowlingGame {

    public int getBowlingScore(String bowlingCode){
        String[] temp = bowlingCode.split("\\|");
        String[] extrapoint = bowlingCode.split("\\|\\|");
        //生成每次投球的分记录score 和 每次的得分 x（strike） s（spare） a
        int[] score={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        char[] flag={'a','a','a','a','a','a','a','a','a','a','a'};
        int total = 0;
        for(int i=0;i<=9;i++){
            String st = temp[i];
            if(st.contains("X"))
            {
                score[2*i]=10;
                flag[i]='x';
            }
            else if (st.contains("/"))
            {
                String[] sa = st.split("");
                int a = Integer.parseInt(sa[1]);
                int b = 10-a;
                score[2*i]=a;
                score[2*i+1]=b;
                flag[i]='s';
            }
            else if (st.contains("-")) {
                String str = st.replaceAll("-","0");
                String[] sa = str.split("");
                int a = Integer.parseInt(sa[1]);
                int b = Integer.parseInt(sa[2]);
                score[2*i]=a;
                score[2*i+1]=b;
            }
            else {
                String[] sa = st.split("");
                int a = Integer.parseInt(sa[1]);
                int b = Integer.parseInt(sa[2]);
                score[2*i]=a;
                score[2*i+1]=b;
            }
        }
        if(flag[9]=='x') {
            String[] extras = extrapoint[1].split("");
            for(int i =1;i<extras.length;i++){
                if(extras[i].equals("X"))
                {
                    score[19+i]=10;
                    flag[10]='x';
                }
                else
                    score[19+i]=Integer.parseInt(extras[i]);
            }
        }
        if(flag[9]=='s') {
            if (extrapoint[1] == "x")
                score[19] = 10;
            else
                score[20]=Integer.parseInt(extrapoint[1]);
        }
        //total point
        for(int i=0;i<=9;i++){
            if(flag[i]=='x')
                if(flag[i+1]=='x'){
                    if(i==9)
                        total+=10+score[2*i+2]+score[2*i+3];
                    else
                        total+=10+score[2*i+2]+score[2*i+4];
                }
                else
                    total+=10+score[2*i+2]+score[2*i+3];
            else if(flag[i]=='s')
                    total+=10+score[2*i+2];
            else
                total+=score[2*i]+score[2*i+1];
        }
            return total;
    }


}
