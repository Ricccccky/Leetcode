--
-- @lc app=leetcode id=185 lang=mysql
--
-- [185] Department Top Three Salaries
--

-- @lc code=start
# Write your MySQL query statement below
SELECT d.Name AS 'Department', x.Name AS 'Employee', x.Salary
FROM Employee AS x
JOIN Department AS d ON x.DepartmentId = d.Id
WHERE 3 > (
    SELECT COUNT(DISTINCT y.Salary)
    FROM Employee AS y
    WHERE y.Salary > x.Salary AND x.DepartmentId = y.DepartmentId
);
-- @lc code=end

