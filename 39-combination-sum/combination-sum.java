class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        addCombination(candidates, 0, target, new ArrayList<>(), res);

        return res;
    }

    public void addCombination(int[] candidates, int index, int target,
                               List<Integer> combination,
                               List<List<Integer>> res) {

        if (target == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }

        if (index == candidates.length) {
            return;
        }

        // TAKE
        if (candidates[index] <= target) {
            combination.add(candidates[index]);

            // index stays same because we can reuse the candidate
            addCombination(
                candidates,
                index,
                target - candidates[index],
                combination,
                res
            );

            // BACKTRACK
            combination.remove(combination.size() - 1);
        }

        // DON'T TAKE
        addCombination(
            candidates,
            index + 1,
            target,
            combination,
            res
        );
    }
}