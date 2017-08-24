import math
age = int(input())
for z in range (age):
	n,m = input().split()
	n = int(n)
	m = int(m)
	if(n <= 10000000 and m <= 10000000) :
		sum=0
		flag=False
		if ((n*(n+1))/2) < m:
			print("-1")
			flag=True
	
		for i in range(1,n+1):
			if flag:
				break
			sum+=i
			if sum==m or sum>m:
				print(i)
				break
	else :	
		if(n*(n+1)/2) < m :
			print("-1")
		else :
			q1 = int(math.sqrt(1+(m*8)))
			q2 = int((q1 - 1)/2 + 1)
			q3 = q2
			if(q2 < q1) :
				while((q2*(q2+1)/2) < m):
					q3 += 1
				print(q3)
			else:
				print(q2)
