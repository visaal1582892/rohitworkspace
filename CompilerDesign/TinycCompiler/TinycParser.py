from sly import Parser
from TinycLexer import lexer
from Ast import *
from SymbolTable import *
import argparse
a=argparse.ArgumentParser()
a.add_argument('InputFile')
args=a.parse_args()
ST=SymbolTable()
class parser(Parser):
    def __init__(self):
        self.memory={}
    tokens=lexer.tokens
    literals=lexer.literals
    @_('return_type ID "(" ")" "{" statements "}"')
    def program(self,t):
        pass
    @_('statement ";" statements')
    def statements(self,t):
        pass
    @_('statement ";"')
    def statements(self,t):
        pass
    @_('declaration_stmt','assignment_stmt','print_stmt')
    def statement(self,t):
        pass
    @_('INT')
    def return_type(self,t):
        pass
    @_('INT list_of_variables')
    def declaration_stmt(self,t):
        pass
    @_('ID "," list_of_variables')
    def list_of_variables(self,t):
        s=SymbolTableEntry(t.ID,int)
        ST.addSymbol(s)
        node=NameAst(s)
    @_(' ID ')
    def list_of_variables(self,t):
        s=SymbolTableEntry(t.ID,int)
        ST.addSymbol(s)
        node=NameAst(s)
    @_('ID "=" ID')
    def assignment_stmt(self,t):
        left=ST.symboltable[t.ID0]
        right=ST.symboltable[t.ID1]
        node=AssignAst(left,right)
        if node.checkDataTypes():
            node.print()
        else:
            print("error occurred at assignment statement")
    @_('ID "=" NUMBER')
    def assignment_stmt(self,t):
        left=ST.symboltable[t.ID]
        right=NumberAst(t.NUMBER)
        node=AssignAst(left,right)
        if node.checkDataTypes():
            node.print()
        else:
            print("error occurred at assignment statement")
    @_('PRINT ID')
    def print_stmt(self,t):
        node=PrintAst(ST.symboltable[t.ID])
        node.print()
tinycFile=open(args.InputFile,'r')
l=lexer()
p=parser()
p.parse(l.tokenize(tinycFile.read()))

        
