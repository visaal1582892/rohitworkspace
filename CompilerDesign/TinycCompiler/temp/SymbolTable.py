class SymbolTableEntry:
    def __init__(self,name,datatype):
        self.name=name
        self.datatype=datatype
    def getSymbolName(self):
        return self.name
    def getDataType(self):
        return self.datatype
    def print(self,output):
        if output is not None:
            output.write(f"name : {self.name}   data_type : {self.datatype}\n")
        else:
            print(f"name : {self.name}   data_type : {self.datatype}")
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
    def printSymbolTable(self,output):
        for i in self.symboltable.values():
            i.print(output)
