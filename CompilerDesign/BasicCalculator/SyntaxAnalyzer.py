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
    @_('E NEWLINE E')
    def E(self,value):
        print(value.E0) if value.E0 is not None else ''
        print(value.E1) if value.E1 is not None else ''
    @_('INT')
    def E(self,value):
        return value.INT
    @_('ID')
    def E(self,value):
        return value.ID
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
input=open(args.inputfile,'r')
l=lexer()
p=parser()
if args.o is None:
    p.parse(l.tokenize(input.read()))
else:
    output=open(args.o[0],'a')
    for tok in l.tokenize(input.read()):
        output.write(f"type : {tok.type}      value : {tok.value}\n")

