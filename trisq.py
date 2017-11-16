"""
Solution of Codechef Problem - Fit Squares in Triangle
Problem Code - TRISQ
Link - https://www.codechef.com/problems/TRISQ
"""

testcases = int(input())
while testcases > 0:
	b = int(input())//2
	print(b*(b-1)//2)
	testcases -= 1