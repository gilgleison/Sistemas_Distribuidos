from socket import *
import Repositorio
import json
import Mensagem

serverPort = 9002
serverSocket = socket(AF_INET, SOCK_STREAM)
serverSocket.bind(('', serverPort))
serverSocket.listen(1)
print('The server is ready to receive')

rep = Repositorio.repositorio()
msg = Mensagem.mensagem()
data= ""

def fromJson(data):
    return json.loads(data)

def toJson(data):
    return json.dumps(data)

def getResquest(connectionSocket):
    length_of_message = int.from_bytes(connectionSocket.recv(2), byteorder='big')
    sentence = connectionSocket.recv(length_of_message).decode("UTF-8")
    #sentence = connectionSocket.recv(2048)
    return sentence

def sendReply(connectionSocket, data):
    connectionSocket.send(len(str(data).encode("UTF-8")).to_bytes(2, byteorder='big'))
    connectionSocket.send(str(data).encode("UTF-8"))



while True:
    #cria o socket pro cliente e estabelece a conexão
    connectionSocket, addr = serverSocket.accept()
    
  
    # ta funcionando : addAlu, addDis, mostrar alu, mostrar dis,
    # não ta funcionando: matricular

    ## erro na hora de mostar ou na hora de matricular,
    ## ao matricular 1 em um disciplina a disciplina aparece em todos os outros, mas na disciplina aparece somento o aluno certo
    ## quando matriculo o aluno em alguma disciplina ele é mostrado nas outras, assim como nas discilpinas, mesmo sem estar matriculado
    ## falta retornar quando a operação não foi feita, como em caso de ja estar matriculado 

    ## passei pra lista até matricular, faltar dele para baixo

    data = getResquest(connectionSocket)
    print(data)

    y = fromJson(data)
    
    if y["mtdId"] == 1:
        print("oi 1 \n")
        rep.addAlu(y["args"][1])
        y["args"][0] = "ok"
        print("ok")

    elif y["mtdId"] == 2:
        print("oi 2 \n")
        rep.addDis(y["args"][0])
        y["args"][0] = "ok"

    elif y["mtdId"] == 3:
        print("oi 3 \n")
        rep.Matricular(y["args"][0], y["args"][1])
        y["args"][0] = "ok"

    elif y["mtdId"] == 4:
        print("oi 4 \n")
        rep.Desmatricular(y["args"][0], y["args"][1])
        y["args"][0] = "ok"

    elif y["mtdId"] == 5:
        print("oi 5 \n")
        rep.rmAlu(y["args"][1])
        y["args"][0] = "ok"

    elif y["mtdId"] == 6:
        print("oi 6 \n")
        y["args"][0] = rep.showAllDisc()

    elif y["mtdId"] == 7:
        print("oi 7 \n")
        y["args"][0] = rep.showAllAlu()
    
    elif y["mtdId"] == 8:
        print("oi 8 \n")
        y["args"][0] = rep.showDisc(y["args"][0])
    
    elif y["mtdId"] == 9:
        print("oi 9 \n")
        y["args"][0] = rep.showAlu(y["args"][1])
    

    y["msgType"] = 1

    data = toJson(y)
    sendReply(connectionSocket, data)
