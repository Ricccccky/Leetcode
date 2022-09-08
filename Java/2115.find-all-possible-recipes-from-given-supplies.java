import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * @lc app=leetcode id=2115 lang=java
 *
 * [2115] Find All Possible Recipes from Given Supplies
 */

// @lc code=start
class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new ArrayList<>();
        Map<String, Set<String>> ingredientToRecipes = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Deque<String> available = Stream.of(supplies).collect(Collectors.toCollection(LinkedList::new));
        for (int i = 0; i < recipes.length; i++) {
            for (String ing : ingredients.get(i)) {
                ingredientToRecipes.computeIfAbsent(ing, s -> new HashSet<>()).add(recipes[i]);
            }
            inDegree.put(recipes[i], ingredients.get(i).size());
        }
        while (!available.isEmpty()) {
            String ing = available.poll();
            if (ingredientToRecipes.containsKey(ing)) {
                for (String rcp : ingredientToRecipes.remove(ing)) {
                    if (inDegree.merge(rcp, -1, Integer::sum) == 0) {
                        available.offer(rcp);
                        result.add(rcp);
                    }
                }
            }
        }

        return result;
    }
}
// @lc code=end

