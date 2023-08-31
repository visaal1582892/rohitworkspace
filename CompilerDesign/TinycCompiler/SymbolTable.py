class SymbolTableEntry:
    def __init__(self,name,datatype):
        self.name=name
        self.datatype=datatype
    def getSymbolName(self):
        return self.name
    def getDataType(self):
        return self.datatype
    def print(self):
        print(f"{self.name}({self.datatype})",end='')
class SymbolTable:
    def __init__(self):
        self.symboltable={}
    def addSymbol(self,symbol):
        self.symboltable[symbol.name]=symbol
    def isVarInSymbolTable(self,name):
        if name in self.symboltable.keys():
            return True
        else:
            return False
    def printSymbolTable(self):
        for i in self.symboltable:
            print(i)