#imported ast class which is used to take inputs from a file
import ast
#created a class
class NFAtoDFA:
#creating constuctor for the class with initial state and input file as arguments
    def __init__(self,InitialState,InputFile):
        self._InitialState=InitialState
        self._InputFile=InputFile
        fp=open(self._InputFile)
        strinput=fp.readlines()
        self._TransitionFunction=ast.literal_eval(strinput[0])
        self._InputAlphabet=ast.literal_eval(strinput[1])
        self._FinalStatesOfNfa=ast.literal_eval(strinput[2])
        self._FinalStatesOfDfa=set()
#function definition used to convert nfa to dfa
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
print("enter file name or path with inputs in below order")
#Desciption of form of input to be given 
print("enter the transitions in set representation in first line")
print("enter input alphabet in form of set in second line")
print("enter set of final states of NFA in third line")
#taking filename as input
InputFile=input();    
a=NFAtoDFA(1,InputFile)
a.NFAtoDFA()


