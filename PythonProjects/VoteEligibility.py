a=int(input("enter the age of a person : "))
if(a<18):
    print("according to given age of person he is not eligible for vote")
    print(f"he will recieve his vote eligibility after {18-a} years")
else:
    print("according to given age of person he is eligible for vote")