--
-- @lc app=leetcode id=181 lang=mysql
--
-- [181] Employees Earning More Than Their Managers
--

-- @lc code=start
# Write your MySQL query statement below
SELECT E.Name AS 'Employee'
FROM Employee AS E, Employee AS M
WHERE E.ManagerId = M.Id 
AND E.Salary > M.Salary;
-- @lc code=end

