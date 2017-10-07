"""
Solution of Codechef Problem - A Balanced Contest
Problem Code - PERFCONT
Link - https://www.codechef.com/problems/PERFCONT
"""

import sys
out = sys.stdout
testcases = int(input())
while testcases > 0:
	arg = list(map(int, input().split()))
	n, p = arg[0], arg[1]
	numbers = list(map(int, input().split()))
	counter1, counter2 = 0, 0
	for i in numbers:
		if i >= p//2:
			counter1 += 1
		elif i <= p//10:
			counter2 += 1
	if counter1 is 1 and counter2 is 2:
		out.write("yes\n")
	else:
		out.write("no\n")
	testcases -= 1