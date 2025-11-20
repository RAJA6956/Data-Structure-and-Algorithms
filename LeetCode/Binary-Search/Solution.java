class Solution {
    public int search(int[] nums, int target) {
        return binary(nums,0,nums.length-1,target);
        
    }
    public int binary(int[] nums,int l,int r,int target){
        if(l>r) return -1;
        int mid=l+(r-l)/2;
        if(nums[mid]==target){
            return mid;
        }
        else if(target>nums[mid]){
            return binary(nums,l=mid+1,r,target);
        }else{
            return binary(nums,l,r=mid-1,target);
        }


        

    }
}