t=int(input())
for k in range(t):
    n=int(input())
    a=list(map(int,input().strip().split()))
    stack=[]
    res={}
    for i in a:
        res[i]=-1
    for j in a:
        if len(stack)==0:
            stack.append(j)
        else:
            while len(stack)>0 and stack[-1]<j:
                res[stack.pop()]=j
            stack.append(j)
    for p in a:
        print(res[p],end=" ")
    print()
