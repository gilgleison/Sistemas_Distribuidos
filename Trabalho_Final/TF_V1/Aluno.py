class aluno(object):
     
    nome = None
    vecDisc = []

    def __init__(self, nome):
        self.nome = nome
        
    def Matricular(self, disc):
        if disc not in self.vecDisc:
            self.vecDisc.append(disc)
    
    def Desmatricular(self, nome):
        if nome in self.vecDisc:
            ind = self.checkInd(nome)
            del(self.vecDisc[ind])

    def checkInd(self, nome):
        self.vecDisc.index(nome)

    def show(self):
        ss = self.nome + ":"
        for i in range(len(self.vecDisc)):
            ss = ss + "\n" +"\t" + str(self.vecDisc[i])
        return ss

    def getDisc(self):
        return self.vecDisc