import ast
class NFAtoDFA:
    def __init__(self,InitialState):
        self._InitialState=InitialState
        fp=open("InputForNFAtoDFA.txt")
        strinput=fp.readlines()
        self._TransitionFunction=ast.literal_eval(strinput[0])
        self._InputAlphabet=ast.literal_eval(strinput[1])
        self._FinalStatesOfNfa=ast.literal_eval(strinput[2])
        self._FinalStatesOfDfa=set()
    def NFAtoDFA(self):
        FinalDFA={}
        visited=set()
        StatesInNFA=set()
        tempList=[]
        tempList.append(self._InitialState)
        InitialStateInTupleForm=tuple(tempList)
        StatesInNFA.add(InitialStateInTupleForm)
        for i in self._InputAlphabet:
            tempstate=self._TransitionFunction[(self._InitialState,i)]
            tempstate=tuple(tempstate)
            StatesInNFA.add(tempstate)
            FinalDFA[InitialStateInTupleForm,i]=tempstate
        visited.add(InitialStateInTupleForm)
        StatesInNFA=list(StatesInNFA)
        for i in StatesInNFA:
            if i not in visited:
                for j in self._InputAlphabet:
                    tempstate=set()
                    for k in i:
                        tempstate=tempstate.union(self._TransitionFunction[(k,j)])
                    tempstate=tuple(tempstate)
                    StatesInNFA.append(tempstate)
                    FinalDFA[(i,j)]=tempstate
                visited.add(i)
        for i in StatesInNFA:
            for j in self._FinalStatesOfNfa:
                if j in i:
                    self._FinalStatesOfDfa.add(i)
        print("Transition_Function of Final DFA is :")  
        print(FinalDFA)
        print("Final states of DFA are ")
        print(self._FinalStatesOfDfa)       
a=NFAtoDFA(1)
a.NFAtoDFA()


