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
        def print(self,output):
                if output is not None:
                        output.write(f"Name : {self.symbol.getSymbolName()})\n")
                else:
                        print(f"Name : {self.symbol.getSymbolName()}",end=')\n')
        def getDataType(self):
                return self.symbol.getDataType()
        def getName(self):
                return self.symbol.getSymbolName()
class NumberAst(Ast):
        def __init__(self,number):
                self.number=number
        def print(self,output):
                if output is not None:
                        output.write(f"Num : {self.number})\n")
                else:
                        print(f"Num : {self.number}",end=')\n')
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
        def print(self,output):
                if output is not None:
                        output.write("\t\tAsgn :\n")
                        output.write("\t\t\tLHS (")
                        self.left.print(output)
                        output.write("\t\t\tRHS (")
                        self.right.print(output)
                else:
                        print("\t\tAsgn :")
                        print("\t\t\tLHS (",end='')
                        self.left.print(output)
                        print("\t\t\tRHS (",end='')
                        self.right.print(output)  
class PrintAst(Ast):
        def __init__(self,symbol):
                self.symbol=symbol
        def print(self,output):
                if output is not None:
                        output.write("\t\tPrint :\n")
                        output.write("\t\t\t(")
                else:
                        print("\t\tPrint :")
                        print("\t\t\t(",end='')
                self.symbol.print(output)
