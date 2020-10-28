package tsp_GA;




public class Individual {
	int[] genes;
	double fitness;
	double distance;
	double rate;   //被选中的概率
	Individual next;
	
	Individual() {
		this.genes=new int[Data.N];
		this.next=null;
		this.fitness=0;
		this.distance=0;
		this.rate=0;
	}
    
	public void randomCreat() {    //随机创建个体
		for(int i=0;i<Data.N;i++) {
			genes[i]=i;
		}
	}
	

	public void getFitness() {   //计算适应度
		int totalDistance=0;
		for(int i=1;i<genes.length;i++) 
			totalDistance+=Data.disMat[this.genes[i-1]][this.genes[i]];
		totalDistance=(int)(totalDistance+Data.disMat[genes[Data.N-1]][genes[0]]);
		this.distance=totalDistance;
	    this.fitness=1/totalDistance;
	    
	    
	}
	
	public Individual cloneSpecies() {
		Individual species=new Individual();
		for(int i=0;i<genes.length;i++) 
			species.genes[i]=this.genes[i];
		species.fitness=this.fitness;
		species.distance=this.distance;
		
		return species;
	}
	
	
}
