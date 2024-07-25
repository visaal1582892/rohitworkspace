n = int(input())
ia=[]
for i in range(n):
    ia.append(int(input()))
fn=int(input())
fa=[]
for i in range(fn):
    fa.append(int(input()))
sc=int(input())
def getMinimumCost(ia, fa, sc):
    tc=0
    for i in range(fa):
        for j in range(ia):
            if fa[i]>ia[i]:
                for k in range(i,len(fa)):
                    if 


