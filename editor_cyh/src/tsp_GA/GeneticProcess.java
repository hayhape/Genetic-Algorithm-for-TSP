package tsp_GA;

import java.security.Policy;
import java.util.Random;

public class GeneticProcess {
	
       
	public void run(Population list) {
		
		creat(list);

		for(int i=0;i<Data.iteration_number;i++) {
			select(list);
			Crossover(list);
			Mutation(list);
			
		}
		getBest(list);
		
	}
	
	public void  creat(Population list) {
		for(int i=0;i<Data.speciesNum;i++) {
			Individual species=new Individual();
			species.randomCreat();
			list.add(species);
		}
		
	}
	
	public void select(Population list) {     //根据适应度选择个体进入下一个种群
		int num=(int)(Data.speciesNum/2);
		Rate(list);
		double talentDis=Double.MAX_VALUE;
		Individual talentSpecies=null;
		Individual point=list.head.next;
		
		while(point!=null) {
			
			if(talentDis>point.distance) {
				talentDis=point.distance;
				talentSpecies=point;
			}
			
			point=point.next;
		}
		//将最大适应度的物种复制到新种群里
		Population newList=new Population();
		for(int i=0;i<num;i++) {
			Individual newSpecies=talentSpecies.cloneSpecies();
			newList.add(newSpecies);
		}
		
		//轮盘赌选择剩余的
		int randomNum=Data.speciesNum-num;
	    for(int i=0;i<randomNum;i++) {
	    	double select_rate=Math.random();
	    	Individual Otherpoint=list.head.next;
	    	while(Otherpoint!=null&&Otherpoint!=talentSpecies) {
	    		
	    		if(select_rate<=Otherpoint.rate) {
	    			Individual newSpecies=new Individual();
	    			newSpecies=Otherpoint.cloneSpecies();
	    			newList.add(newSpecies);
	    			break;
	    		}
	    		else {
	    			select_rate=select_rate-Otherpoint.rate;
	    		}
	    		Otherpoint=Otherpoint.next;
	    	}
	    	if(Otherpoint==null||Otherpoint==talentSpecies) {
	    		point=list.head;
	    		while(point.next!=null) {
	    			point=point.next;
	    		}
	    		Individual newSpecies=point.cloneSpecies();
	    		newList.add(newSpecies);
	    	}
	    }
	    list.head=newList.head;
	    
	    
		
		
	}
	
	public void Mutation(Population list) {
		Individual point=list.head.next;//变异操作
		while(point!=null) {
		double rand=Math.random();
		if(Data.mutation_rate>rand) {
			Random random=new Random();
			int left=random.nextInt(Data.N);
			int right=random.nextInt(Data.N);
			
			if(left>right) {
				int temp=right;
				right=left;
				left=temp;
			}
			
			while(left<right) {
				int temp;
				temp=point.genes[left];
				point.genes[left]=point.genes[right];
				point.genes[right]=temp;
				left++;
				right--;
			}
			
		}
		point=point.next;
		}
		
	}
	
	public void Crossover(Population list) {    //交换操作
		Individual point=list.head;
		
		
		double crossover_rate=Math.random();
		if(crossover_rate>Data.crossoverRate_lower&&(crossover_rate<Data.crossoverRate_upper) ){
			Random rand=new Random();
			int random=rand.nextInt(Data.speciesNum-1);
		while(point!=null&&random!=0) {
			point=point.next;
			random--;
		}
			
			if(point.next!=null) {
				int i_position=rand.nextInt(Data.N);
				for(int i=i_position;i<Data.N;i++) {
					int fir,sec;
					for(fir=0;fir<Data.N;fir++) {
						if(point.genes[fir]==point.next.genes[i])
						break;
					}
					for(sec=0;sec<Data.N;sec++) {
						if(point.genes[i]==point.next.genes[sec])
							break;
					}
					
					int temp;
					temp=point.genes[i];
					point.genes[i]=point.next.genes[i];
					point.next.genes[i]=temp;
					
					temp=point.genes[fir];
					point.genes[fir]=point.next.genes[sec];
					point.next.genes[sec]=temp;
				}
				
		
			
			}
			
			
			
		}
	}
	
	
	public void Rate(Population list) {    //计算物种被选中的概率
		Individual point=list.head.next;
		int totalFitness=0;
		while(point!=null) {
			point.getFitness();
			totalFitness+=point.fitness;
			point=point.next;
		}
		
		point=list.head.next;
		while(point!=null) {
			point.rate=point.fitness/totalFitness;
			point=point.next;
		}
	}
	
	
	public void getBest(Population list) {
		Individual point=list.head.next;
		Individual bestSpeices=new Individual();
		bestSpeices=null;
		double bestDis=Double.MAX_VALUE;
		while(point!=null) {
			if(bestDis>point.distance) {
				bestSpeices=point;
				bestDis=point.distance;
			}
			point=point.next;
		}
		
		for(int a:bestSpeices.genes) {
			System.out.print(a+"—>");
		}
		System.out.println(bestSpeices.genes[0]);
		System.out.println(bestSpeices.distance);
	}
	
	public void print(Population list) {
		Individual point=list.head.next;
		while(point!=null) {
			point.getFitness();
			for(int a:point.genes) {
				System.out.print(a+"->");
			}
			System.out.println(point.genes[0]);
			System.out.println(point.distance);
			point=point.next;
		}
		
	}
}
