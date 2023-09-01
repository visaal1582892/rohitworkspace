from SymbolTable import SymbolTable
class Function:
    def __init__(self,name,return_type):
        self.name=name
        self.return_type=return_type
        self.localSymboltable=SymbolTable()
        self.statementsAstList=[]
    def setLocalSymbolTable(self,symboltable):
        self.localSymboltable=symboltable
    def getLocalSymbolTable(self):
        return self.localSymboltable
    def setStatementsAstList(self,sastlist):
        self.statementsAstList=sastlist
    def getStatementsAstList(self):
        return self.statementsAstList