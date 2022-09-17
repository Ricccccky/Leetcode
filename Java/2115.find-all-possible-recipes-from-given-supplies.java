import java.util.*;

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
        Deque<String> available = new LinkedList<>();
        for (int i = 0; i < recipes.length; i++) {
            for (String ing : ingredients.get(i)) {
                ingredientToRecipes.computeIfAbsent(ing, s -> new HashSet<>()).add(recipes[i]);
            }
            inDegree.put(recipes[i], ingredients.get(i).size());
        }
        for (String supply : supplies) {
            available.offer(supply);
        }
        while (!available.isEmpty()) {
            String ing = available.poll();
            if (ingredientToRecipes.containsKey(ing)) {
                for (String recipe : ingredientToRecipes.remove(ing)) {
                    inDegree.put(recipe, inDegree.get(recipe) - 1);
                    if (inDegree.get(recipe) == 0) {
                        available.offer(recipe);
                        result.add(recipe);
                    }
                }
            }
        }

        return result;
    }
}
// @lc code=end

