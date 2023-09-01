from sly import Parser
from TinycLexer import lexer
from Ast import *
from SymbolTable import *
from Program import *
from Function import Function
import argparse
a=argparse.ArgumentParser()
a.add_argument('InputFile')
args=a.parse_args()
class parser(Parser):
    def __init__(self):
        self.fun=Function('main',int)
        self.tinycprogram=Program()
        self.sastlist=[]
    tokens=lexer.tokens
    literals=lexer.literals
    @_('return_type ID "(" ")" "{" statements "}"')
    def program(self,t):
        self.tinycprogram.addFunctionDetails(t.ID,t.statements)
        print(self.tinycprogram.getMainFunction())
    @_('statement ";" statements')
    def statements(self,t):
        return t.statements
    @_('statement ";"')
    def statements(self,t):
        return t.statement
    @_('declaration_stmt','assignment_stmt','print_stmt')
    def statement(self,t):
        self.sastlist.append(t[0])
        return self.sastlist
    @_('INT')
    def return_type(self,t):
        pass
    @_('INT list_of_variables')
    def declaration_stmt(self,t):
        #self.sastlist.append(t.list_of_variables)
        return t.list_of_variables
    @_('ID "," list_of_variables')
    def list_of_variables(self,t):
        if self.fun.localSymboltable.isVarInSymbolTable(t.ID):
            print("cannot declare two variables with same names")
        else:
            s=SymbolTableEntry(t.ID,int)
            self.fun.localSymboltable.addSymbol(s)
            node=NameAst(s)
            return [node]+t.list_of_variables
    @_(' ID ')
    def list_of_variables(self,t):
        if self.fun.localSymboltable.isVarInSymbolTable(t.ID):
            print("cannot declare two variables with same names")
        else:
            s=SymbolTableEntry(t.ID,int)
            self.fun.localSymboltable.addSymbol(s)
            node=NameAst(s)
            return [node]
    @_('ID "=" ID')
    def assignment_stmt(self,t):
        if self.fun.localSymboltable.isVarInSymbolTable(t.ID0) and self.fun.localSymboltable.isVarInSymbolTable(t.ID1):
            left=NameAst(self.fun.localSymboltable.symboltable[t.ID0])
            right=NameAst(self.fun.localSymboltable.symboltable[t.ID1])
            node=AssignAst(left,right)
            if node.checkDataTypes():
                return node
            else:
                print("error occurred at assignment statement")
    @_('ID "=" NUMBER')
    def assignment_stmt(self,t):
        if self.fun.localSymboltable.isVarInSymbolTable(t.ID):
            left=NameAst(self.fun.localSymboltable.symboltable[t.ID])
            right=NumberAst(t.NUMBER)
            node=AssignAst(left,right)
            if node.checkDataTypes():
                return node
            else:
                print("error occurred at assignment statement")
    @_('PRINT ID')
    def print_stmt(self,t):
        if self.fun.localSymboltable.isVarInSymbolTable(t.ID):
            node=PrintAst(t.ID)
            return node
tinycFile=open(args.InputFile,'r')
l=lexer()
p=parser()
p.parse(l.tokenize(tinycFile.read()))

        
