"""
Solution of Codechef Problem - Chef on a trip
Problem Code - CHEFTRAV
Link - https://www.codechef.com/problems/CHEFTRAV
"""

import sys
out = sys.stdout
testcases = int(input())
while testcases > 0:
    n = int(input())
    places = {}
    end_city = set([])
    for i in range(n):
    	source = input()
    	destination = input()
    	places[source] = destination
    	end_city.add(destination)
    start_City = ""
    for k in places.keys():
    	if k not in end_city:
    		start_City = k
    		break
    for i in range(n):
    	out.write(start_City +"-"+places[start_City]+" ")
    	start_City = places[start_City]
    out.write("\n")
    testcases -= 1