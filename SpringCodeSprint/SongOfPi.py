# Enter your code here. Read input from STDIN. Print output to STDOUT
def isPi(s):
    pi = "3141592653589793238462643383279502884197169399375105820974944592307816"
    l = s.split()
    for i in range(len(l)):
        if len(l[i]) != int(pi[i]):
            return False        
    return True
T = input()
str = []
for i in range(T):
    str.append(raw_input())

for i in range(T):
    if isPi(str[i]):
        print "It's a pi song."
    else:
        print "It's not a pi song."
