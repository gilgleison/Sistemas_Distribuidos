class aluno(object):
     
    nome = None
    vecDisc = []

    def __init__(self, nome):
        self.nome = nome
        
    def Matricular(self, disc):
        for j in range(len(self.vecDisc)):
            if disc == str(self.vecDisc[j]):
                return
        self.vecDisc.append(disc)
    
    def Desmatricular(self, nome):
        for j in range(len(self.vecDisc)):
            if nome == str(self.vecDisc[j]):
                del(self.vecDisc[j])
                return

    def show(self):
        ss = self.nome + ":"
        for i in range(len(self.vecDisc)):
            ss = ss + "\n" +"\t" + str(self.vecDisc[i])
        return ss

    def getDisc(self):
        return self.vecDisc

    def getName(self):
        return self.nome



class disciplina(object):
     
    disc = None
    vecAlu = []

    def __init__(self, disc):
        self.disc = disc

    def Matricular(self, nome):
        for j in range(len(self.vecAlu)):
            if nome == str(self.vecAlu[j]):
                return
        self.vecAlu.append(nome)
    
    def Desmatricular(self, disc):
        for j in range(len(self.vecAlu)):
            if disc == str(self.vecAlu[j]):
                del(self.vecAlu[j])
                return
            
    def show(self):
        ss = self.disc + ":"
        for i in range(len(self.vecAlu)):
            ss = ss + "\n" +"\t" + str(self.vecAlu[i])
        return ss

    def getAlu(self):
        return self.vecAlu

    def getName(self):
        return self.disc



class repositorio(object):
    
    repAlu = []
    repDis = []

    def addAlu(self, nome):
        for i in range(len(self.repAlu)):
        # self.repAlu[nome] = aluno(nome)
            if nome == str(self.repAlu[i]):
                return
        self.repAlu.append(aluno(nome))

    def addDis(self, disc):
        for i in range(len(self.repDis)):
        # self.repAlu[nome] = aluno(nome)
            if disc == str(self.repDis[i]):
                return
        self.repDis.append(disciplina(disc))

    def Matricular(self, disc, nome):
       for i in range(len(self.repDis)):
           if disc == self.repDis[i].getName():
               for j in range(len(self.repAlu)):
                   if nome == str(self.repAlu[j].getName()):
                    self.repAlu[j].Matricular(disc)
                    self.repDis[i].Matricular(nome)
                    return

    def Desmatricular(self, disc, nome):
       for i in range(len(self.repDis)):
           if disc == str(self.repDis[i].getName()):
               for j in range(len(self.repAlu)):
                   if nome == self.repAlu[j].getName():
                    self.repAlu[j].Desmatricular(disc)
                    self.repDis[i].Desmatricular(nome)
                    return

    def rmAlu(self, nome):
        if nome in self.repAlu:
            indAlu = self.checkIndA(nome)
            y = self.repAlu[indAlu].getDisc()
            for i in y:
                self.repDis[i].Desmatricular(nome)
            del(self.repAlu[indAlu])

    def showAlu(self, nome):
        for i in range(len(self.repAlu)):
            if nome == str(self.repAlu[i].getName()):
                show = nome + ":"
                y = self.repAlu[i].getDisc()
                for j in range(len(y)):
                    show = show + "\n" + "\t" + str(y[j])
                return show
        return "não existe"

    def showDisc(self, nome):
        for i in range(len(self.repDis)):
            if nome == str(self.repDis[i].getName()):
                show = nome + ":"
                y = self.repDis[i].getAlu()
                for j in range(len(y)):
                    show = show + "\n" + "\t" + str(y[j])
                return show
        return "não existe"

    def showAllAlu(self):
        show = ""
        for i in self.repAlu:
            show = show +"\n"+ i.getName()
        show = show + "\n"
        return show

    def showAllDisc(self):
        show = ""
        for i in self.repDis:
            show = show +"\n"+ i.getName()
        show = show + "\n"
        return show

