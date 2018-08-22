import java.io.*;
import java.util.*;

public class coloring {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("graph.in"));
		
		in.readLine();
		int N = Integer.parseInt(in.readLine());
		String[] vertices = new String[N];
		boolean[][] edges = new boolean[N][N];
		
		for(int i = 0; i<N; i++){
			for(int j = 0; j<N; j++){
				
				edges[i][j] = false;
				
			}
			
		}
		
		for(int i = 0; i<N; i++){
			
			vertices[i] = in.readLine();
			//System.out.println(vertices[i]);
			
		}
		
		N = Integer.parseInt(in.readLine());
		
		for(int i = 0; i<N; i++){
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			String name1 = st.nextToken();
			String name2 = st.nextToken();
			int index1 = indexOf(vertices, name1);
			int index2 = indexOf(vertices, name2);
			edges[index1][index2] = true;
			edges[index2][index1] = true;
			
		}
		
		IntervalGraph intervalgraph = new IntervalGraph(N, edges);

		ArrayList[] intervals = intervalgraph.getIntervals();
		
		HashMap colors = new HashMap();
		
		for(int i = 0, end1 = intervals.length; i<end1; i++){
			
			int color = 1;
			ArrayList alreadyUsedColor = new ArrayList();
				
			for(int j = 0, end2 = intervals[i].size(); j<end2; j++){
				
				if(colors.get(intervals[i].get(j)) != null){
					
					alreadyUsedColor.add(colors.get(intervals[i].get(j)));
				
				}
				
			}
			
			for(int j = 0, end2 = intervals[i].size(); j<end2; j++){
			
				if(!colors.containsKey(intervals[i].get(j))){
					
					while(alreadyUsedColor.contains(color)){
						
						color++;
						
					}
				
					colors.put(intervals[i].get(j), color);
					alreadyUsedColor.add(color);
					color = 1;
					
				}
				
			}
			
		}
		
		for(int i = 0; i<vertices.length; i++){
			
			System.out.println("Vertex " + vertices[i] + " is color " + colors.get(i));
			
		}
		
	}

	static int indexOf(String[] vertices, String value){
		int index = -1;
		
		for(int i = 0, end = vertices.length; i<end; i++){
			
			if(value.equals(vertices[i])){
				
				index = i;
				break;
				
			}
			
		}
		
		return index;
		
	}
	
}
