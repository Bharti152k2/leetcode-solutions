class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        addSubset(nums, 0, new ArrayList<>(), res);

        return res;
    }

    public void addSubset(int[] nums, int index,
                           List<Integer> subset,
                           List<List<Integer>> res) {

        if (index == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        // take
        subset.add(nums[index]);
        addSubset(nums, index + 1, subset, res);

        // backtrack
        subset.remove(subset.size() - 1);

        // don't take
        addSubset(nums, index + 1, subset, res);
    }
}