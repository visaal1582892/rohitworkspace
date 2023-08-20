from sly import Lexer    #module for lexical analysis
#creating a class
class lexer(Lexer):
    #declaring tokens and literals
    tokens={INT,ID,NEWLINE}
    literals={'+','-','*','/','(',')'}
    #defining the mentioned tokens
    INT=r'\d+'
    ID=r'[a-zA-Z_][a-zA-Z0-9_]*'
    NEWLINE=r'\n'
    #redefining the value in INT
    @_('\d+')
    def INT(self,t):
        t.value=int(t.value)
        return t     
    @_('[a-zA-Z_][a-zA-Z0-9_]*')
    def ID(self,t):
        t.value=int(input(f"enter the value if {t.value}"))
        return t