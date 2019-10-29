package com.ge.exercise2;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayQuadrantUtil {
	    private static final Logger logger = LogManager.getLogger(ArrayQuadrantUtil.class);
			
		 private char[][] array;
		  private static int quadrantSize;
		 
		  public ArrayQuadrantUtil(int[][] array1) {
			  String [][] strConv = new String[array1.length][];
			  for(int i=0; i<array1.length; i++) {
			    int [] row = array1[i];
			    strConv[i] = new String[row.length];
			    for(int j=0; j<row.length; j++) {
			    	strConv[i][j] = Integer.toString(row[j]);
			    }
			  }			  
		  }
		  
		  @SuppressWarnings("static-access")
		public ArrayQuadrantUtil(char[][] array) {
			
		    this.array = array;
		    this.quadrantSize = array.length / 2;
		  }

		  public ArrayQuadrantUtil getQuadrantValues(int quadrant) {
		    ArrayQuadrantUtil quadrantArray;

		    switch(quadrant) {
		      case 1:
		        quadrantArray = getQuadrantValues(0, quadrantSize);
		        break;
		      case 2:
		        quadrantArray = getQuadrantValues(0, 0);
		        break;
		      case 3:
		        quadrantArray = getQuadrantValues(quadrantSize, 0);
		        break;
		      case 4:
		        quadrantArray = getQuadrantValues(quadrantSize, quadrantSize);
		        break;
		      default:
		        throw new IllegalArgumentException("Invalid quadrant: " + quadrant);
		    }
		    return quadrantArray;
		  }

		  public ArrayQuadrantUtil getQuadrantValues(int startRow, int startCol) {
			  char[][] quadrantArray = new char[quadrantSize][];
		    for (int r = 0; r < quadrantSize; r++) {
		      quadrantArray[r] = Arrays.copyOfRange(array[startRow + r], startCol, startCol + quadrantSize);
		   //   System.out.println( quadrantArray[r]);
		      logger.info(quadrantArray[r]);
		    }

		    return new ArrayQuadrantUtil(quadrantArray);
		  }
		  
		  public ArrayQuadrantUtil getQuadrantValuesrows(int startRow) {
			  char[][] quadrantArray = new char[quadrantSize][];
			    for(int i=0; i<quadrantArray.length; i++){
			    	quadrantArray[i] = array[startRow];
			    //	System.out.println(quadrantArray[i]);
			    	logger.info(quadrantArray[i]);
			    }
				return new ArrayQuadrantUtil(quadrantArray);
		    
		    }
		  
		  public ArrayQuadrantUtil getQuadrantValuesColumn(int column) {
			  char[][] twoDArray = new char[array.length][];
			    int x = 0;
			    for (int i = 0; i < twoDArray.length; i++) {
			        for (int j = 0; j < twoDArray.length; j++) {
			            x = j + 1;
			            if(x == column) {
			            	twoDArray[i]=array[x];
			            	logger.info(twoDArray[i]);
			            //    System.out.print(array[i][j]);
			            }
			        }
			    }
				return new ArrayQuadrantUtil(twoDArray);
		    
		    }

		  
		  
		  
		
		  }
