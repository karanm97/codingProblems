"""
Solution of Codechef Problem - Periodic Palindrome Construction
Problem Code - PERPALIN
Link - https://www.codechef.com/problems/PERPALIN
"""

import sys
out = sys.stdout
testcases = int(input())
while testcases > 0:
	numbers = list(map(int, input().split()))
	n, p = numbers[0], numbers[1]
	if p == 2 or n%p != 0 or p == 1:
		out.write("impossible\n")
	else:
		out.write(("a" + "b" * (p-2) + "a") * (n//p) + "\n")
	testcases -= 1