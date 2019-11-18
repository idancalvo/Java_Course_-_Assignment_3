
/*
* Create a Map nxn
*/
public class Map {
	
	private char[][] Map=null;
	
	//Map Contractor - Create a map and check that all the chars and A-Z or a-z
	public Map(char[][] map) {
	  if (map!=null){
		Map = new char [map.length][map[0].length];
		for (int i = 0 ; i <= map.length-1 ; i++){
			for (int j = 0 ; j <= map[0].length-1 ; j++){
				if (map[i][j]>='A' & map[i][j]<='Z'){
					Map[i][j] = (char) (map[i][j] + 32);
				}
				else if (map[i][j]>='a' & map[i][j]<='z')
				{
					 Map[i][j]=map[i][j];
				}	
				else Map[i][j]='z';
			
			}// end of for j
		}//end of for i
	  }// end of null map
	}//end of public Map
	
	//empty Contractor 
	public Map (){
		this(new char[1][1]);
	}
	
	// send the char Array of the map
	public char[][] getMap() {
		char[][] ArrayMap = new char [Map.length][Map[0].length];
		for (int i=0 ; i<=ArrayMap.length-1 ; i++){
			for (int j=0 ; j<=ArrayMap[0].length-1 ; j++){
				ArrayMap[i][j] = Map[i][j];
			}
	    }
		return ArrayMap;
		
	}//end get map
	
	// Checking if map is equals to other map
	public boolean equals(Map map) {
		boolean ans=false;
		if (map!=null){ // check if the other map is null
		ans=true;
		char[][] mapArray = map.getMap();
	    if (Map.length==mapArray.length & Map[0].length==mapArray[0].length ) // Checking the Array length
	    {
	    	for (int i=0 ; i<=Map.length-1 & ans; i++)
	    	{
	    		for (int j=0 ; j<=Map[0].length-1 & ans ; j++)
	    		{
	    			if (Map[i][j]!=mapArray[i][j])
	    			{
	    			ans=false;
	    			}
	    		}
	    	}
	    }// end if Array length
		}//end of null map
	   return ans;
	}
	
	// Number of Different Colors in the Map
	public int numOfColors() {
		char[][] Map = this.getMap();
		int answer=0;
		String Colors="";
		boolean DifColor;
		if(Map!=null){ // checking if map is null
			for (int i=0 ; i<=Map.length-1 ; i++)
			{
				for (int j=0 ; j<=Map[0].length-1 ; j++)
				{
				   DifColor=true;
				   for (int col=0 ; col<=Colors.length()-1 ; col++)
				   {
					   if (Map[i][j]==Colors.charAt(col)){
						   DifColor=false;
					   }//end of if
				   }//end of Third for
					   if (DifColor==true){
						   Colors=Colors + Map[i][j];
					   }
				}//end of second for
			}//end of first for
		answer=Colors.length();
		}//null map
		return answer;
	}//end numOfColors
	
	// the Colors of the Neighbors
	public int numOfColors(Point p) {
		int answer=0, Mapsize=Map.length-1;
		int x = p.getX();
		int y = p.getY();
		char[][] SmallMap = new char [3][3];
		
		if ((x<=Mapsize & x>=0) & (y<=Mapsize & y>=0)) //if x and y is in the Map
		{
			if ((x+1)<=Mapsize & (y+1)<=Mapsize) //Checking the Neighbors
				SmallMap[2][2]=Map[x+1][y+1];
			else SmallMap[2][2]=Map[x][y];
			
			if ((y+1)<=Mapsize)
				SmallMap[1][2]=Map[x][y+1];
			else SmallMap[1][2]=Map[x][y];
			
			if ((x+1)<=Mapsize)
				SmallMap[2][1]=Map[x+1][y];
			else SmallMap[2][1]=Map[x][y];
			
			if ((x+1)<=Mapsize & (y-1)>=0)
				SmallMap[2][0]=Map[x+1][y-1];
			else SmallMap[2][0]=Map[x][y];
			
			if ((y-1)>=0)
				SmallMap[1][0]=Map[x][y-1];
			else SmallMap[1][0]=Map[x][y];
			
			if ((x-1)>=0 & (y-1)>=0)
				SmallMap[0][0]=Map[x-1][y-1];
			else SmallMap[0][0]=Map[x][y];
			
			if ((x-1)>=0)
				SmallMap[0][1]=Map[x-1][y];
			else SmallMap[0][1]=Map[x][y];
			
			if ((x-1)>=0 & (y+1)<=Mapsize)
				SmallMap[0][2]=Map[x-1][y+1];
			else SmallMap[0][2]=Map[x][y];
			
			SmallMap[1][1]=Map[x][y];
			
			Map Neighbors = new Map(SmallMap); // Make a Neighbors Map 
		    answer = Neighbors.numOfColors();
		}//if
		
		return answer;
		
	}
	
	// Checking if 2 points are Neighbor 
	public boolean legalNeighbor(Point p1, Point p2) {
		boolean answer = false;
		if (p1!=null & p2!=null){ // not null points
		int x1 = p1.getX();
		int y1 = p1.getY();
		int x2 = p2.getX();
		int y2 = p2.getY();
		
		if (!(p1.equals(p2)))// if its not the same point
			if ((x1<Map.length & x1>=0) & (y1<Map.length & y1>=0))// if x1,y1 in the map
				if ((x2<Map.length & x2>=0) & (y2<Map.length & y2>=0))// if x2,y2 in the map
					if (Math.abs(x1-x2)<=1 & Math.abs(y1-y2)<=1)// if the points are neighbor
						if (Map[x1][y1]==Map[x2][y2])// same color
							answer = true;
		}
		return answer;
		
	}
	
	// fill the area of Point P
	public void fill(Point p,char color) {
		if ((color>='a' & color<='z') | (color>='A' & color<='Z')){ // Valid color
			if (color>='A' & color<='Z') // Change to Small letter
				color = (char) (color + 32);
		int x = p.getX();
		int y = p.getY();
		int Mapsize=Map.length-1;
		
		if ((x<=Mapsize & x>=0) & (y<=Mapsize & y>=0)) //if x and y is in the Map
		{
			char OriColor=Map[x][y]; 
			Map[x][y]=color; // Change the Color of P
			
			if ((x+1)<=Mapsize & (y+1)<=Mapsize) //Checking the Neighbors
			   if (Map[x+1][y+1]==OriColor)
			   {
			   Point p1 = new Point(x+1,y+1);
			   fill(p1,color);
			   }
				   
			if ((y+1)<=Mapsize)
			  if (Map[x][y+1]==OriColor)
			   {
			   Point p2 = new Point(x,y+1);
			   fill(p2,color);
			   }
			
			if ((x+1)<=Mapsize)			  
	          if (Map[x+1][y]==OriColor)
			   {
			   Point p3 = new Point(x+1,y);
			   fill(p3,color);
			   }
			
			if ((x+1)<=Mapsize & (y-1)>=0)			
		      if (Map[x+1][y-1]==OriColor)
			   {
			   Point p4 = new Point(x+1,y-1);
			   fill(p4,color);
			   }
			
			if ((y-1)>=0)			 
		      if (Map[x][y-1]==OriColor)
			   {
			   Point p5 = new Point(x,y-1);
			   fill(p5,color);
			   }
			
			if ((x-1)>=0 & (y-1)>=0)			
		      if (Map[x-1][y-1]==OriColor)
			   {
			   Point p6 = new Point(x-1,y-1);
			   fill(p6,color);
			   }
			
			if ((x-1)>=0)			 
		      if (Map[x-1][y]==OriColor)
			   {
			   Point p7 = new Point(x-1,y);
			   fill(p7,color);
			   }
			
			if ((x-1)>=0 & (y+1)<=Mapsize)		
		      if (Map[x-1][y+1]==OriColor)
			   {
			   Point p8 = new Point(x-1,y+1);
			   fill(p8,color);
			   }
		   }
		}
	}
}
