from Function import *
class Program:
        def __init__(self):
                self.functions={}
        def addFunctionDetails(self,name,function):
                self.functions[name]=function
        def getMainFunction(self):
                return self.functions['main'].getStatementsAstList()
        def print(self,output):
                if output is not None:
                        output.write("Program :\n")
                else:
                        print("Program :")
                for i in self.functions:
                        self.printFunctionHeader(i,output)
                #for i in self.getMainFunction():
                        #i.print()
                        for j in self.getFunctionDetails(i):
                                j.print(output)

        def printFunctionHeader(self,name,output):
                if output is not None:
                        output.write(f"\tProcedure: {name}   ReturnType: {self.functions[name].return_type}\n")
                else:
                        print(f"\tProcedure: {name}   ReturnType: {self.functions[name].return_type}")
        def getFunctionDetails(self,name):
                return self.functions[name].getStatementsAstList()
