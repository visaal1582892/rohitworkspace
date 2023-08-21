from sly import Lexer
def daysofmonth(month,year):
    tdm=31 if month in [1,3,5,7,8,10,12] else 30 if month in [4,6,9,11] else 29 if leapyear(year) else 28
    return tdm
def leapyear(a):
    if a%4==0:
        if a%100!=0:
            return True
        elif a%100==0 and a%400!=0:
            return False
        elif a%100==0 and a%400==0:
            return True
    else:
        return False
class date:
    def __init__(self,dateinput):
        self.day=int(dateinput[0:2])
        self.month=int(dateinput[3:5])
        self.year=int(dateinput[6:])
        self.tdm=daysofmonth(self.month,self.year)
    def __add__(self,other):
        day=self.day
        month=self.month
        year=self.year
        tdm=self.tdm
        while other!=0:
            remain=tdm-day
            if other>remain:
                other-=((tdm-day)+1)
                day=1
                month+=1
                if(month>12):
                    month%=12
                    year+=1
                tdm=daysofmonth(month,year)
            else:
                day=other+1
                other=0
        return f"{day : 02}/{month : 02}/{year}"
    def __sub__(self,other):
        year=other.year
        month=other.month
        tdm=other.tdm
        result=tdm-other.day
        month+=1
        if month>12:
            month%=12
            year+=1
        while(month!=self.month or year!=self.year):
            tdm=daysofmonth(month,year)
            result+=tdm
            month+=1
            if month>12:
                month%=12
                year+=1
        result+=self.day
        return result
class lexer(Lexer):
    tokens={DATE,INT}
    literals={'+','-'}
    DATE=r'\d\d/\d\d/\d\d\d\d'
    INT=r'\d+'
    @_('\d\d/\d\d/\d\d\d\d')
    def DATE(self,t):
        t.value=date(t.value)
        return t
    @_('\d+')
    def INT(self,t):
        t.value=int(t.value)
        return t