from SymbolTable import *
from abc import ABCMeta,abstractmethod,ABC
class Ast(ABC):
    def getDataType(self):
        pass
    @abstractmethod
    def print(self):
        pass
    def checkDataTypes(self):
        pass
class NameAst(Ast):
    def __init__(self,symbol):
        self.symbol=symbol
    def print(self):
        self.symbol.print()
    def getDataType(self):
        return self.symbol.getDataType()
class NumberAst(Ast):
    def __init__(self,number):
        self.number=number
    def print(self):
        print(self.number)
    def getDataType(self):
        return type(self.number)
class AssignAst(Ast):
    def __init__(self,left,right):
        self.left=left
        self.right=right
    def checkDataTypes(self):
        if self.left.getDataType()==self.right.getDataType():
            return True
        else:
            return False
    def print(self):
        self.left.print()
        print(" = ",end='')
        self.right.print()
class PrintAst(Ast):
    def __init__(self,symbol):
        self.symbol=symbol
    def print(self):
        print(f"\nprint ",end='')
        self.symbol.print()