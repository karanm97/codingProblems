"""
Solution of Codechef Problem - A Big Sale
Problem Code - BIGSALE
Link - https://www.codechef.com/problems/BIGSALE
"""

def calculate_loss(a,b,c):
	d = a + a*c/100
	d = d - d*c/100
	return (a-d)*b

testcases = int(input())
while testcases > 0:
	n = int(input())
	total_loss = 0
	for i in range(0,n):
		arg = list(map(int, input().split()))
		total_loss += calculate_loss(arg[0],arg[1],arg[2])
	print(total_loss)   
	testcases -= 1

