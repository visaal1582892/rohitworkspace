from sly import Lexer
class lexer(Lexer):
        tokens={INT,ID,NUMBER,PRINT}
        literals={',','=','(',')','{','}',';'}
        ignore=r'\t '
        ignore_newline=r'\n+'
        ignore_comments=r'\#.*'
        ID=r'[a-zA-Z_][0-9a-zA-Z_]*'
        NUMBER=r'\d+'
        ID['int']=INT
        ID['print']=PRINT
        @_('\d+')
        def NUMBER(self,t):
                t.value=int(t.value)
                return t
