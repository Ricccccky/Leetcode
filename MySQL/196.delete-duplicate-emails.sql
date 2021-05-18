--
-- @lc app=leetcode id=196 lang=mysql
--
-- [196] Delete Duplicate Emails
--

-- @lc code=start
# Write your MySQL query statement below
DELETE p1 FROM Person AS p1, Person p2
WHERE p1.Email = p2.Email AND p1.id > p2.id;
-- @lc code=end

