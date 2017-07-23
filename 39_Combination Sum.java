public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null) {
            return result;
        }
        //我犯的错：没有sort
        Arrays.sort(candidates);
        List<Integer> combination =new ArrayList<Integer>();
        helper(candidates, result, combination, target, 0);
        return result;
    }
    
    private void helper(int[] candidates,
                        List<List<Integer>> result,
                        List<Integer> combination,
                        int target,
                        int index                       
                       ) {
        //刚好等于target，退出， 我犯的错：没有result.add(), 或者把combination直接add到了result里
        
        if (target == 0) {
            result.add(new ArrayList<Integer>(combination));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            //超过停止
            if (candidates[i] > target) {
                break;
            }
            //跳过重复
            //我犯的错：candidates[i] == candidates[i + 1] 会可能指空
            //i != index代表了i前面至少有index，所以candidates[i - 1]一定不为null，candidates[i + 1]就不一定了
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.add(candidates[i]);
            //为什么helper里传的不是i + 1
            helper(candidates, result, combination, target - candidates[i], i);
            combination.remove(combination.size() - 1);
            
        }
    }
}