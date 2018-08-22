import java.util.ArrayList;
import java.util.PriorityQueue;

public class IntervalGraph {

	private ArrayList[] intervals;
	
	public IntervalGraph(){
		
		intervals = new ArrayList[0];
		
	}
	
	public IntervalGraph(int numOfVert, boolean[][] edges){
		
		intervals = new ArrayList[numOfVert];
		
		//initialize the intervals
		for(int x = 0, end = intervals.length; x<end; x++){
			
			intervals[x] = new ArrayList();
			
		}
		
		ArrayList listVert = new ArrayList();
		
		for(int x = 0, end = edges.length; x<end; x++){
			
			listVert.add(x);
			//System.out.println(listVert);
			
		}
		
		//counts the interval of which the vertices overlap 
		int interval = -1;
		
		while(listVert.size() > 0){
			
			int vertex = (int) listVert.get(0);
			//System.out.println("New Vertex: " + vertex);
			ArrayList listOverlap = new ArrayList();
			
			//adding all vertices overlapping with the original into new ArrayList
			for(int x = 0, end = edges[vertex].length; x<end; x++){
				
				if(edges[vertex][x] == true && x != vertex){
					
					listOverlap.add(x);
					
				}
				
			}
				
			if(listOverlap.size() == 0){
				
				interval++;
				intervals[interval].add(vertex);
				//System.out.println(intervals[interval]);
				
			}
			
			//System.out.println("ListOverlap: " + listOverlap);
			
			while(listOverlap.size() > 0){
				
				interval++;
				intervals[interval].add(vertex);
				listVert.remove(0);
				
				for(int i = 0; i<listOverlap.size(); i++){
					
					intervals[interval].add((int) listOverlap.get(i));
						
					for(int j = 0; j<listOverlap.size(); j++){
						
						if(edges[(int) listOverlap.get(i)][(int) listOverlap.get(j)] == true){
			
							intervals[interval].add((int) listOverlap.get(j));
							listVert.remove(listOverlap.get(j));
							listOverlap.remove(listOverlap.get(j));
							j = 0;
							
						}
						
					}
					
					i = 0;
					listVert.remove(listOverlap.get(i));
					listOverlap.remove(listOverlap.get(i));
				
				}
				
				//System.out.println(intervals[interval]);
				
			}
			
		}
		
	}

	public ArrayList[] getIntervals() {
		return intervals;
	}

	public void setIntervals(ArrayList[] intervals) {
		this.intervals = intervals;
	}
	
}
