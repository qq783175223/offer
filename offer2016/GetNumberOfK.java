package offer2016;

public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int number=0;
        if(array!=null&&array.length>0){
            int first=getFirstK(array,k,0,array.length-1);
            int last=getLastK(array,k,0,array.length-1);
            if(first>-1&&last>-1){
            	number=last-first+1;
        	}
        }
       	return number;
    }
    private int getFirstK(int[] array,int k,int start,int end){
        if(start>end){
            return -1;
        }
        int midIndex=(start+end)/2;
        int midData=array[midIndex];
        if(midData==k){
            if(midIndex>0&&array[midIndex-1]!=k||midIndex==0){
            	return midIndex;
        	}else{
                end=midIndex-1;
            }
        }else if(midData>k){
            end=midIndex-1;
        }else{
            start=midIndex+1;
        }
        return getFirstK(array,k,start,end);
    }
    private int getLastK(int[] array,int k,int start,int end){
        if(start>end){
            return -1;
        }
        int midIndex=(start+end)/2;
        int midData=array[midIndex];
        if(midData==k){
            if(midIndex<end&&array[midIndex+1]!=k||midIndex==end){
            	return midIndex;
        	}else{
                start=midIndex+1;
            }
        }else if(midData<k){
            start=midIndex+1;
        }else{
            end=midIndex-1;
        }
        return getLastK(array,k,start,end);
    }
}