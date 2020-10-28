package tsp_GA;



import tsp_GA.Data;

public class Main {

	public static void main(String[] args) throws Exception{
		
		
		// TODO Auto-generated method stub
		
		//¶ÁÈ¡Êý¾Ý
    	Data data=new Data();
    	data.input();
        Population list=new Population();
        GeneticProcess run=new GeneticProcess();
        run.run(list);
        
        
	
         
         
	}

}
