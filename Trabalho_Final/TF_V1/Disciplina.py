class disciplina(object):
     
    disc = None
    vecAlu = []

    def __init__(self, disc):
        self.disc = disc

    def Matricular(self, aluno):
        if aluno not in self.vecAlu:
            self.vecAlu.append(aluno)
    
    def Desmatricular(self, disc):
        if disc in self.vecAlu:
            ind = self.checkInd(disc)
            del(self.vecAlu[ind])
    
    def checkInd(self, nome):
        self.vecAlu.index(nome)

    def show(self):
        ss = self.disc + ":"
        for i in range(len(self.vecAlu)):
            ss = ss + "\n" +"\t" + str(self.vecAlu[i])
        return ss

    def getAlu(self):
        return self.vecAlu