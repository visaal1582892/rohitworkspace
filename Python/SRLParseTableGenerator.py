import ast
import string
import random
import pandas as pd
from argparse import ArgumentParser
variableList=list(string.ascii_uppercase)
a=ArgumentParser()
a.add_argument('inputfile')
args=a.parse_args()
input=open(args.inputfile)
fileInputList=input.readlines()
terminals=ast.literal_eval(fileInputList[0])
terminals.add('epsilon')
non_terminals=ast.literal_eval(fileInputList[1])
startSymbol=ast.literal_eval(fileInputList[2])
grammar=[]
for i in range(3,len(fileInputList)):
    grammar.append(fileInputList[i])
grammarDict={}
for i in non_terminals:
    grammarDict[i]=[[]]
    variableList.remove(i)
for line in grammar:
    if line[0] not in non_terminals and line[1]!=' ' and line[2]!='-' and line[3]!='>':
        print("Given grammar input is not in correct format")
for line in grammar:
    prodno=0
    i=4
    while i<len(line):
        if line[i]==' ':
            pass
        elif line[i]=='|':
            grammarDict[line[0]].append([])
            prodno+=1
        elif line[i]=='\n':
            pass
        else:
            if line[i] not in non_terminals and line[i] not in terminals:
                temp=list()
                temp.append(line[i])
                while ''.join(temp) not in terminals and ''.join(temp) not in non_terminals:
                    i+=1
                    temp.append(line[i])
                a=''.join(temp)
            else:
                a=line[i]
            grammarDict[line[0]][prodno].append(a)
        i+=1
class State:
    inc=0
    states=set()
    def __init__(self):
        State.inc+=1
        self.name=f"s{State.inc}"
        self.items={}
        self.edges={}
    def closure(self,non_terminal,augmentedGrammarDict):
        closureDict={}
        for item in augmentedGrammarDict[non_terminal]:
            if item[-2] in non_terminals:
                closureDict=closureDict | {non_terminal : augmentedGrammarDict[non_terminal]} | self.closure(non_terminal,augmentedGrammarDict)
        return closureDict   
class ParseTableGenerator:
    def __init__(self,grammarDict):
        self.grammarDict=grammarDict
    def rightRecursionElimination(self):
        recursionFreeVariables=[]
        for var in self.grammarDict:
            dict={}
            ruleList=self.grammarDict[var]
            for ruleIndex in range(len(ruleList)):
                if ruleList[ruleIndex][-1] in recursionFreeVariables:
                    toReplace=ruleList[ruleIndex][-1]
                    flag=0
                    for replaceRule in self.grammarDict[toReplace]:
                        if replaceRule[-1]==var:
                            flag=1
                    if flag==1:
                        ruleList[ruleIndex]=[]
                        ruleList[ruleIndex].pop(-1)
                        prefix=ruleList[ruleIndex]
                        for replaceRule in self.grammarDict[toReplace]:
                            ruleList.append(prefix+replaceRule)            
            while [] in ruleList:
                ruleList.remove([])
            rightRecursiveRules=[]
            remainingRules=[]
            for i in range(len(ruleList)):
                if ruleList[i][-1]==var:
                    rightRecursiveRules.append(i)
                else:
                    remainingRules.append(i)
                    
            if len(rightRecursiveRules)!=0:
                tempVar=random.choice(variableList)
                non_terminals.add(tempVar)
                variableList.remove(tempVar)
                dict[tempVar]=[]
            else:
                recursionFreeVariables.append(var)
                continue
            for nonRecursiveRuleindex in remainingRules:
                for recursiveRuleindex in rightRecursiveRules:
                    if ruleList[recursiveRuleindex]!=[]:
                        ruleList[recursiveRuleindex].pop(-1)
                        recursivePart=ruleList[recursiveRuleindex]
                        dict[tempVar].extend([[tempVar]+recursivePart])
                        ruleList[recursiveRuleindex]=[]
                ruleList.append([tempVar]+ruleList[nonRecursiveRuleindex])
                ruleList[nonRecursiveRuleindex]=[]
            for i in range(len(remainingRules)+len(rightRecursiveRules)):
                ruleList.remove([])
            dict[tempVar].append(['epsilon'])
            recursionFreeVariables.append(var)
            self.grammarDict=self.grammarDict | dict
    def rightFactoring(self):
        dict={}
        for var in self.grammarDict:
            ruleList=self.grammarDict[var]
            classes=set()
            for ruleIndex1 in range(len(ruleList)):
                classList=[]
                for ruleIndex2 in range(len(ruleList)):
                    if ruleList[ruleIndex2][-1]==ruleList[ruleIndex1][-1]:
                        classList.append(ruleIndex2)
                classTuple=tuple(classList)
                classes.add(classTuple)
            for classTuple in classes:
                if len(classTuple)==1:
                    pass
                else:
                    tempVar=random.choice(variableList)
                    variableList.remove(tempVar)
                    non_terminals.add(tempVar)
                    dict[tempVar]=[]
                    commonFactor=ruleList[classTuple[0]][-1]
                    for classItem in classTuple:
                        ruleList[classItem].pop(-1)
                        dict[tempVar].extend([ruleList[classItem]])
                        ruleList[classItem]=[]
                    ruleList.append([tempVar]+[commonFactor])
                    for i in range(len(classTuple)):
                        ruleList.remove([])
        self.grammarDict=self.grammarDict | dict
        print(self.grammarDict)
    def last(self,var):
        lastSet=set()
        lastDict={}
        for rule in self.grammarDict[var]:
            if rule[-1] in terminals or rule[-1] == 'epsilon':
                lastSet.add(rule[-1])
                lastDict[rule[-1]]=rule
            elif rule[-1] in non_terminals and 'epsilon' not in self.last(rule[-1])[0]:
                lastSet=lastSet | self.last(rule[-1])[0]
                for i in self.last(rule[-1])[0]:
                    lastDict[i]=rule
            elif rule[-1] in non_terminals and 'epsilon' in self.last(rule[-1])[0]:
                lastSet=lastSet | (self.last(rule[-1])[0] - {'epsilon'} | self.last(rule[-2])[0])
                for i in (self.last(rule[-1])[0] - {'epsilon'} | self.last(rule[-2])[0]):
                    lastDict[i]=rule
        return (lastSet,lastDict)
    def augmentedGrammarGenerator(self):
        self.augmentedGrammarDict=self.grammarDict
        for ruleList in self.augmentedGrammarDict.values():
            for rule in ruleList:
                rule.append('.')
        self.augmentedStartSymbol=random.choice(variableList)
        non_terminals.add(self.augmentedStartSymbol)
        variableList.remove(self.augmentedStartSymbol)
        self.augmentedGrammarDict[self.augmentedStartSymbol]=[[f"{startSymbol}",'.']]
        print(self.augmentedGrammarDict)
    def statesGenerator(self):
        self.states={}
        self.initialState=State()
        State.states.add(self.initialState)
        self.initialState.items[self.augmentedStartSymbol]=self.augmentedGrammarDict[self.augmentedStartSymbol]
        self.initialState.items = self.initialState.items | self.initialState.closure(startSymbol,self.augmentedGrammarDict)
        print(self.initialState.items)
parseTable=ParseTableGenerator(grammarDict)
parseTable.rightRecursionElimination()
parseTable.rightFactoring()
parseTable.augmentedGrammarGenerator()
parseTable.statesGenerator()