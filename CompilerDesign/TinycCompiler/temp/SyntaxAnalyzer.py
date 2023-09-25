from sly import Parser
from LexicalAnalyzer import lexer
from Ast import *
from SymbolTable import *
from Program import *
from Function import Function
import argparse
a=argparse.ArgumentParser()
a.add_argument('InputFile')
a.add_argument('-t',nargs=1)
a.add_argument('-ast',nargs=1)
a.add_argument('-st',nargs=1)
args=a.parse_args()
class parser(Parser):
        def __init__(self):
                #self.tinycprogram=Program()
                #self.fun=Function('main',int)
                self.localSymbolTable=SymbolTable()
                self.sastlist=[]
        tokens=lexer.tokens
        literals=lexer.literals
        @_('return_type ID "(" ")" "{" statements "}"')
        def program(self,t):
                tinycprogram=Program()
                fun=Function('main',int)
                #self.fun.setStatementsAstList(t.statements)
                #self.tinycprogram.addFunctionDetails(t.ID,self.fun)
                fun.setStatementsAstList(t.statements)
                fun.localSymbolTable=self.localSymbolTable
                tinycprogram.addFunctionDetails(t.ID,fun)
                if args.ast is not None:
                        f=open(args.ast[0],'w')
                        f.write('')
                        f.close()
                        f=open(args.ast[0],'a')
                        tinycprogram.print(f)
                        f.close()
                elif args.ast is None and args.st is not None:
                        pass
        @_('statement ";" statements')
        def statements(self,t):
                return t.statements
        @_('statement ";"')
        def statements(self,t):
                return t.statement
        @_('assignment_stmt','print_stmt')
        def statement(self,t):
                
                self.sastlist.append(t[0])
                return self.sastlist
        @_('declaration_stmt')
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
                
                if t.ID in self.localSymbolTable.symboltable.keys():
                        print("cannot declare two variables with same names")
                else:
                        s=SymbolTableEntry(t.ID,int)
                        #self.fun.localSymboltable.addSymbol(s)
                        self.localSymbolTable.addSymbol(s)
        @_(' ID ')
        def list_of_variables(self,t):
                
                #if self.fun.localSymboltable.isVarInSymbolTable(t.ID):
                if t.ID in self.localSymbolTable.symboltable.keys():
                        print("cannot declare two variables with same names")
                else:
                        s=SymbolTableEntry(t.ID,int)
                        self.localSymbolTable.addSymbol(s)
        @_('ID "=" ID')
        def assignment_stmt(self,t):
                #if self.fun.localSymboltable.isVarInSymbolTable(t.ID0) and self.fun.localSymboltable.isVarInSymbolTable(t.ID1):
                if t.ID0 in self.localSymbolTable.symboltable.keys() and t.ID1 in self.localSymbolTable.symboltable.keys():
                        left=NameAst(self.localSymbolTable.symboltable[t.ID0])
                        right=NameAst(self.localSymbolTable.symboltable[t.ID1])
                        node=AssignAst(left,right)
                        if node.checkDataTypes():
                                return node
                        else:
                                print("error occurred at assignment statement")
        @_('ID "=" NUMBER')
        def assignment_stmt(self,t):
                #if self.fun.localSymboltable.isVarInSymbolTable(t.ID):
                if t.ID in self.localSymbolTable.symboltable.keys():
                        left=NameAst(self.localSymbolTable.symboltable[t.ID])
                        right=NumberAst(t.NUMBER)
                        node=AssignAst(left,right)
                        if node.checkDataTypes():
                                return node
                        else:
                                print("error occurred at assignment statement")
        @_('PRINT ID')
        def print_stmt(self,t):
                #if self.fun.localSymboltable.isVarInSymbolTable(t.ID):
                if t.ID in self.localSymbolTable.symboltable.keys():
                        symbol=NameAst(self.localSymbolTable.symboltable[t.ID])
                        node=PrintAst(symbol)
                        return node
                else:
                        print("given symbol is not declared")
tinycFile=open(args.InputFile,'r')
l=lexer()
p=parser()
if args.t is None and args.ast is not None and args.st is None:
        p.parse(l.tokenize(tinycFile.read()))
elif args.t is not None and args.ast is None and args.st is None:
        f=open(args.t[0],'w')
        f.write('')
        f.close()
        f=open(args.t[0],'a')
        for t in l.tokenize(tinycFile.read()):
                f.write(f"type : {t.type}       value : {t.value}\n")
        f.close()
elif args.t is None and args.ast is None and args.st is not None:
        f=open(args.st[0],'w')
        f.write('')
        f.close()
        f=open(args.st[0],'a')
        p.parse(l.tokenize(tinycFile.read()))
        p.localSymbolTable.printSymbolTable(f)
        f.close()
else:
        p.parse(l.tokenize(tinycFile.read()))
        