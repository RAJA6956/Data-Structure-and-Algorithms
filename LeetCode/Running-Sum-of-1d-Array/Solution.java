// Input: nums = [1,2,3,4]
// Output: [1,3,6,10]

var runningSum = function(nums) {
  
  let temp = 0, arrTemp = [];
  
  for (let i = 0; i < nums.length; i++){
    temp += nums[i]
    arrTemp.push(temp)
  }    
  return arrTemp
};

const nums = [1,2,3,4];
console.log(runningSum(nums))