"""
Solution of Codechef Problem - Max Mex
Problem Code - MEX
Link - https://www.codechef.com/problems/MEX
"""

testcases = int(input())
universe = set()
for i in range(2 * 100001):
	universe.add(i)
while testcases > 0:
	arg = list(map(int, input().split()))
	n, k = arg[0], arg[1]
	set_s = set(list(map(int, input().split())))
	print(list(universe - set_s)[k])
	testcases -= 1