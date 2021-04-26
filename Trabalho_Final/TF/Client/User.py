import TCPClient
client = TCPClient.Client()

while True:

    num = input( "Escolha a opção desejada: \n"
        + "1 : Adicionar Aluno \n"
        + "2 : Adicionar Disciplina \n"
        + "3 : Matricular \n"
        + "4 : Desmatricular \n"
        + "5 : Remover Aluno \n"
        + "6 : Remover Disciplina \n"
        + "7 : Mostrar Disciplinas \n"
        + "8 : Mostrar Alunos \n"
        + "9 : Sair \n"
    )


    envia = []

    if(num == "1"):
        envia.append(input("Nome do Aluno: "))
        envia.append(input("Matricula do Aluno: "))
        print(client.doOperation("Repositorio", 1, envia))

    elif(num == "2"):
        envia.append(input("ID da Disciplina: "))
        envia.append(input("Código da Disciplina: "))
        print(client.doOperation("Repositorio", 2, envia))

    elif(num == "3"):
        envia.append(input("Código da Disciplina: "))
        envia.append(input("Matricula do Aluno: ")) 
        print(client.doOperation("Repositorio", 3, envia))

    elif(num == "4"):
        envia.append(input("Código da Disciplina: "))
        envia.append(input("Matricula do Aluno: "))
        print(client.doOperation("Repositorio", 4, envia))

    elif(num == "5"):
        envia.append(input("Matricula do Aluno: ")) 
        print(client.doOperation("Repositorio", 5, envia))

    elif(num == "6"):
        envia.append(input("Codigo da Disciplina: ")) 
        print(client.doOperation("Repositorio", 6, envia))

    elif(num == "7"):
        print(client.doOperation("Repositorio", 7, envia))

    elif(num == "8"):
        print(client.doOperation("Repositorio", 8, envia))
    
    elif(num == "9"):
        print(client.doOperation("Repositorio", -1, envia))
        break
    else:
        print("Opção inválida")

