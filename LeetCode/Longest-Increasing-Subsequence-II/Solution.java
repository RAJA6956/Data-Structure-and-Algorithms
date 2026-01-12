class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        return helper(0,-1,k,nums);
    }
    public int helper(int idx,int prevIdx,int k,int nums[]){
        if(idx==nums.length){
            return 0;
        }
        
        int ans=Integer.MIN_VALUE;
        
        if(prevIdx==-1 || ((nums[idx]-nums[prevIdx])>0 && (nums[idx]-nums[prevIdx]) <=k)){
            ans=Math.max(ans,1+helper(idx+1,idx,k,nums));
        }
        ans=Math.max(ans,helper(idx+1,prevIdx,k,nums));

        
        return ans;
    }
}