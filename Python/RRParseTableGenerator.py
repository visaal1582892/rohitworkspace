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
    def toString(self):
        for ruleList in self.grammarDict.values():
            for ruleIndex in range(len(ruleList)):
                ruleList[ruleIndex]=''.join(ruleList[ruleIndex])
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
    def precede(self,var):
        preset=set()
        if var==startSymbol:
            preset.add('$')
        for (lhs,rules) in self.grammarDict.items():
            for rule in rules:
                for itemIndex in range(len(rule)):
                    if rule[itemIndex]==var:
                        if (itemIndex-1)<0:
                            if lhs!=var:
                                    preset=preset | self.precede(lhs)
                                    return preset
                        else:
                            if rule[itemIndex-1] in terminals-{'epsilon'}:
                                preset.add(rule[itemIndex-1])
                            elif rule[itemIndex-1] in non_terminals and 'epsilon' not in self.last(rule[itemIndex-1][0]):
                                preset=preset | self.last(rule[itemIndex-1])[0]
                            elif rule[itemIndex-1] in non_terminals and 'epsilon' in self.last(rule[itemIndex-1][0]):
                                preset=preset | self.last(rule[itemIndex-1])[0]-{'epsilon'} | self.precede(lhs)
        return preset
    def parseTable(self):
        tableColumns=list(terminals-{'epsilon'})+['$']
        parseTable=pd.DataFrame(columns=tableColumns)
        for i in non_terminals:
            for j in tableColumns:
                parseTable.at[i,j]='e'
        parseTable.index=non_terminals
        for non_terminal in non_terminals:
            for lastItem in self.last(non_terminal)[0]-{'epsilon'}:
                parseTable.at[non_terminal,lastItem]=self.last(non_terminal)[1][lastItem]
            if 'epsilon' not in self.last(non_terminal)[0]:
                pass
            else:
                for precedeItem in self.precede(non_terminal):
                    parseTable.at[non_terminal,'$']=self.last(non_terminal)[1]['epsilon']
        print(parseTable)
parseTable=ParseTableGenerator(grammarDict)
parseTable.rightRecursionElimination()
parseTable.rightFactoring()
parseTable.parseTable()

