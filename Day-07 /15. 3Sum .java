class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length - 2;i++){

            if(i>0 && nums[i] == nums[i-1]){
                continue;
                
            } 
            int leftptr = i+1;
            int rightptr = nums.length - 1;

            while (leftptr < rightptr){
                    int sum = nums[i] + nums[leftptr] + nums[rightptr];
            if(sum == 0){
                answer.add(Arrays.asList(nums[i],nums[leftptr],nums[rightptr]));
                leftptr++;
                rightptr--;

                while (leftptr < rightptr && nums[leftptr] == nums[leftptr - 1]) {
                        leftptr++;
                    }

                    while (leftptr < rightptr && nums[rightptr] == nums[rightptr + 1]) {
                        rightptr--;
                    }
            }
                
                else if (sum < 0) {
                    leftptr++;
                }
            
                else {
                    rightptr--;
                }
            }
        }
        return answer;
    }
}
