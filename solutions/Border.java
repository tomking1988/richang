package Problem;

import java.util.*;


public class Border {
	public int findRedundant(Scanner scanner){
		int numOfBorder = scanner.nextInt();
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		Interval currentInterval;
		int counter = 0;
		
		for(int i=0; i<numOfBorder; i++){
			intervals.add(new Interval(scanner.nextInt(), scanner.nextInt()));
		}
		
		Collections.sort(intervals, new IntervalComparator());
		 
		currentInterval = intervals.get(0);
		for(int i=0; i<intervals.size()-1; i++){
			if(currentInterval.contains(intervals.get(i+1))){	
				counter++;
			}else{
				currentInterval = intervals.get(i+1);
			}
			 
		}
		return counter;
	}

	private class Interval {
		public int start;
		public int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public boolean contains(Interval other) {
			if (this.start <= other.start && this.end >= other.end) {
				return true;
			} else {
				return false;
			}
		}
	}

	private class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			if(o1.start < o2.start)
				return -1;
			else if(o1.start == o2.start){
				if(o1.end > o2.end)
					return -1;
			}
			
			return 1;
			
		}

	}
}
