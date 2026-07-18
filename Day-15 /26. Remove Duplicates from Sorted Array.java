class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int itr = 0;
        for(int jtr = 1 ;jtr<nums.length;jtr++){
            if(nums[itr] != nums[jtr]){
                itr++;
                nums[itr] = nums[jtr];
            }
        }
        return itr + 1;
    }
}
