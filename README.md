# Sistema de Matrículas
Este repositório contém o projeto do Sistema de Matrículas desenvolvido para a disciplina de Laboratório de Desenvolvimento de Software, do curso de Engenharia de Software na PUC Minas.

## Integrantes do grupo
* [Gabriel Ramos](https://github.com/gramos22)

* [João Pedro Braga](https://github.com/joaopedro-braga)

* [Júlia Moreira Nascimento](https://github.com/JulyaMoreyra)

## Descrição do Projeto
O Sistema de Matrículas é um software desenvolvido para informatizar o processo de matrícula em disciplinas de uma universidade. 

O sistema permite que alunos se matriculem em disciplinas obrigatórias e optativas, além de possibilitar o cancelamento de matrículas.

O sistema também gera notificações para o sistema de cobranças da universidade e fornece aos professores uma visão sobre quais alunos estão matriculados em suas disciplinas.

### Funcionalidades
* **Cadastro de Disciplinas:** Permite à secretaria da universidade cadastrar disciplinas, associando professores e alunos.
* **Matrícula em Disciplinas:** Os alunos podem se matricular em até 4 disciplinas obrigatórias e 2 optativas.
* **Cancelamento de Matrícula:** Os alunos podem cancelar suas matrículas dentro do período estabelecido.
* **Controle de Vagas:** Cada disciplina tem um limite de vagas, sendo ativada apenas se houver um número mínimo de alunos matriculados.
* **Notificações de Cobrança:** Integração com o sistema de cobranças para geração de boletos conforme as matrículas realizadas.
* **Consulta de Matrículas:** Professores podem consultar a lista de alunos matriculados em suas disciplinas.

### Tecnologias Utilizadas
* **Linguagem de Programação:** Java
* **Ferramentas de Modelagem:** Astah, draw.io
* **Controle de Versão:** Git/GitHub

## Histórias de Usuário

### US01
```
Como secretaria,
eu desejo poder gerar um currículo para cada semestre
para manter as informações sobre as disciplinas, professores e alunos.
```

### US02
```
Como aluno,
eu desejo poder me matricular em disciplinas obrigatórias
para que eu possa montar minha grade de estudos
```

### US03
```
Como aluno,
eu desejo poder cancelar minha matrícula,
para que eu possa desistir de um curso quando necessário 
```

### US04
```
Como secretaria,
eu desejo poder definir o período em que os alunos podem acessar o sistema
para definir seu tempo de matricula
```

### US05
```
Como secretaria,
eu desejo que uma disciplina seja cancelada automáticamente caso tenha menos de três alunos matriculados
para não precisar alocar professores em turmas muito pequenas
```

### US06
```
Como secretaria,
eu desejo que as incrições para uma disciplina sejam encerradas caso a mesma tenha 60 alunos matriculados
para não ter salas muito cheias
```

### US07
```
Como secretaria,
eu desejo que o sistema de cobranças notifique o aluno após sua matrícula
para que o mesmo saiba como pagar pelas disciplinas em que se inscreveu
```

### US08
```
Como professor,
eu desejo poder acessar o sistema
para ver quaias alunos estão cadastrados em cada disciplina
```

### US09
```
Como usuário,
eu desejo que minha conta seja protegida por uma senha
para que ninguém possa acessá-la
```

### US10
```
Como aluno, 
eu desejo poder me cadastrar em disciplinas optativas, 
para que eu possa montar minha grade de estudos personalizada
```

### US11
```
Como secretaria, 
eu desejo poder cadastrar e modificar os cursos, 
para poder determinar o número de créditos e as disciplinas que o compõe 
```

### US12
```
Como usuário, 
eu desejo poder recuperar minha senha, 
para poder acessar minha conta
```

## Diagrama de Caso de Uso

![Diagrama de Caso de Uso](docs/UseCaseDiagram.png)

## Diagrama de Classe 

![Diagrama de Classe](docs/ClassDiagram.png)
[Acessar Figma](https://www.figma.com/board/Th7yAG7cy99eHgFXyXoaOa/Class-Diagram---Enrollment-System?node-id=0-1&t=nfERT34drKPhAzjv-0)
