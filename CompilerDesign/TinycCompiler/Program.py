class Program:
    def __init__(self):
        self.functions={}
    def addFunctionDetails(self,name,function):
        self.functions[name]=function
    def getMainFunction(self):
        return self.functions['main']
    def print(self):
        pass