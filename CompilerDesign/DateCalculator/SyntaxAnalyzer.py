from sly import Parser
from LexicalAnalyzer import lexer
class parser(Parser):
    tokens=lexer.tokens
    literals=lexer.literals
    @_('DATE "+" INT')
    def E(self,value):
        return value.DATE+value.INT
l=lexer()
p=parser()
data='''16/01/2004+61'''
result=p.parse(l.tokenize(data))
print(result)