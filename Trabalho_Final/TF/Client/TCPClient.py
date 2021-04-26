from socket import *
import Mensagem
import json

class Client:
    clientSocket = None
    msg = Mensagem.mensagem()

    def __init__(self):       
        serverName = 'localhost'
        serverPort = 7896
        self.clientSocket = socket(AF_INET, SOCK_STREAM)
        self.clientSocket.connect((serverName, serverPort))
      
    def doOperation(self, RmtObj, mtdId, args):

        self.msg.msgType = 0
        self.msg.rqId += 1
        self.msg.objRef = RmtObj
        self.msg.mtdId = mtdId
        self.msg.args = args

        #envio da mensagem
        send = json.dumps(self.msg, default=lambda o: o.__dict__, indent=4)

        self.clientSocket.send(len(str(send).encode("UTF-8")).to_bytes(2, byteorder='big'))
        self.clientSocket.send(str(send).encode("UTF-8"))
        
        if(self.msg.mtdId == -1):
            self.clientSocket.close()
            return "Conexão encerrada"

        
        msgAux = Mensagem.mensagem()

        #Resposta
        tam = int.from_bytes(self.clientSocket.recv(2), byteorder='big')
        receive = self.clientSocket.recv(tam).decode("UTF-8")

        data = json.loads(receive)
        
        msgAux.msgType = data["msgType"]
        msgAux.rqId = data["rqId"]
        msgAux.objRef = data["objRef"]
        msgAux.mtdId = data["mtdId"]
        msgAux.args = data["args"]

        if(self.msg.rqId != msgAux.rqId):
            return "RequestId Diferente"

        return msgAux.args[0]

