from sly import Parser
from LexicalAnalyzer import lexer
class parser(Parser):
    tokens=lexer.tokens
    literals=lexer.literals
    @_('DATE "+" INT')
    def E(self,value):
        return value.DATE+value.INT
    @_('DATE "-" DATE')
    def E(self,value):
        return value.DATE0-value.DATE1
l=lexer()
p=parser()
data="16/01/2005-16/01/2004"
result=p.parse(l.tokenize(data))
print(result)