a=float(input("enter value of first number : "))
b=float(input("enter value of second number : "))
c=float(input("enter value of third number : "))
if(a!=b and b!=c and c!=a):
    if(a>b and a>c):
       print(f"first number {a} is the largest")
    elif(b>a and b>c):    
       print(f"first number {b} is the largest")
    else:
       print(f"first number {c} is the largest")
if(a==b and b==c and c==a):
    print("given three numbers are equal")
elif(a==b):
    if(a>c):
        print(f"given first {a} and second {b} numbers are equal which are greater than third number {c}")
    else:
        print(f"given first {a} and second {b} numbers are equal which are smaller than third number {c}")
elif(b==c):
    if(c>a):
        print(f"given second {b} and third {c} numbers are equal which are greater than first number {a}")
    else:
        print(f"given second {b} and third {c} numbers are equal which are smaller than first number {a}")
elif(a==c):
    if(a>c):
        print(f"given first {a} and third {c} numbers are equal which are greater than second number {b}")
    else:
        print(f"given first {a} and third {c} numbers are equal which are smaller than second number {b}")
