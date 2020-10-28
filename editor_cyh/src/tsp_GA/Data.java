package tsp_GA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class Data {
	    
	  
		static double[][] disMat;
		static int speciesNum=200;
		static int N=31;
		static int iteration_number=1000;  //迭代次数
		static double crossoverRate_upper=0.6;
		static double crossoverRate_lower=0.9;
		static double mutation_rate=0.4;
		
		
	
		
	    public void input() throws Exception {
	    	 String path="T:\\java相关\\lib\\att48.tsp";
			 int N=48;
			 double[][] city_pos=new double[N][2];
		  	 String line=null;
	    	 String[] str=null;
	    	 Scanner cin=new Scanner(new BufferedReader(new FileReader(path)));
	    	 for(int i=0;i<6;i++) {
	    		 line=cin.nextLine();
	    	 }
	    	 for(int i=0;i<N;i++) {
	    		 line=cin.nextLine();
	    		 line.trim();
	    		 str=line.split("\\s+");
	    		 city_pos[i][0]=Double.parseDouble(str[1]);
	    		 city_pos[i][1]=Double.parseDouble(str[2]);
	    		
	    	 }
	    	 cin.close();
	    	 
	    
	    	/* double[][] city_pos={
	 				{1304,        2312},{3639,        1315},         
	 				{4177,        2244},{3712,        1399},         	
	 				{3488,        1535},{3326,        1556},         
	 				{3238,        1229},{4196,        1004},         
	 				{4312,         790},{4386,         570},
	 				{3007,        1970},{2562,        1756},
	 				{2788,        1491},{2381,        1676},
	 				{1332,         695},{3715,        1678},
	 				{3918,        2179},{4061,        2370},
	 				{3780,        2212},{3676,        2578},
	 				{4029,        2838},{4263,        2931},
	 				{3429,        1908},{3507,        2367},
	 				{3394,        2643},{3439,        3201},
	 				{2935,        3240},{3140,        3550},
	 				{2545,        2357},{2778,        2826},
	 				{2370,        2975}};//31个城市（最优解:14700）
	    	 
	    	 
	    	 
	    	 */
	    	 
	    
	    	 
	    	disMat=new double[N][N];
	    	 for(int i=0;i<N;i++) {
	    		 for(int j=0;j<N;j++) {
	    			 disMat[i][j]=Math.sqrt(((city_pos[i][0]-city_pos[j][0])
								*(city_pos[i][0]-city_pos[j][0])+
						(city_pos[i][1]-city_pos[j][1])
						*(city_pos[i][1]-city_pos[j][1])));
	    			 disMat[i][j]=double_truncate(disMat[i][j]);
	    		 }
	    	 } 
	    	 

	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	     }
	     
	     public static double double_truncate(double v){
	 		int iv = (int) v;
	 		if(iv+1 - v <= 1e-6)
	 			return iv+1;
	 		double dv = (v - iv) * 10;
	 		int idv = (int) dv;
	 		double rv = iv + idv / 10.0;
	 		return rv;
	 	}	
	     
	 
	   
}
