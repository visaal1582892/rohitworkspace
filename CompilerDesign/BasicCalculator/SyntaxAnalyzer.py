#importing required modules
import argparse      #used for giving command line arguments
a=argparse.ArgumentParser()
a.add_argument("inputfile")
a.add_argument("-o",nargs=1)
args=a.parse_args()
from LexicalAnalyzer import lexer     #importing lexer class from LexicalAnalyzer.py
from sly import Parser       #importing predefined class
#creating parser class
class parser(Parser):
    tokens=lexer.tokens
    literals=lexer.literals
    #defining prescedence of operators
    precedence=(('left',NEWLINE),('left','+','-'),('left','*','/'))
    #defining grammar for language
    @_('L NEWLINE E')
    def L(self,value):
        print(value.E)
    @_('INT')
    def E(self,value):
        return value.INT
    @_('E "+" E')
    def E(self,value):
        return value.E0+value.E1
    @_('E "-" E')
    def E(self,value):
        return value.E0-value.E1
    @_('E "*" E')
    def E(self,value):
        return value.E0*value.E1
    @_('E "/" E')
    def E(self,value):
        return value.E0/value.E1
    @_('"(" E ")"')
    def E(self,value):
        return value.E
    @_('')
    def E(self,value):
        return
    @_('E')
    def L(self,value):
        print(value.E)
input=open(args.inputfile,'r')
l=lexer()
p=parser()
if args.o is None:
    result=p.parse(l.tokenize(input.read()))
    print(result)
else:
    pass

