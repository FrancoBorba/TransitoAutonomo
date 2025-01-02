# Projeto: Simulação de Trânsito Autônomo com Semáforos

## Descrição Geral
Este projeto é uma simulação de um sistema de trânsito autônomo onde **oito carros** percorrem trajetos predefinidos em uma malha viária. As rotas dos carros são sorteadas no início da execução, e o objetivo principal é evitar colisões nos cruzamentos utilizando **semáforos** para controle de acesso às zonas críticas.

O projeto foi desenvolvido como parte das atividades da disciplina de **Programação Concorrente**, orientada pelo professor **Marlos Marques**.

---

## Funcionalidades
- **Simulação de Trânsito**:
  - Oito carros percorrem trajetos definidos de forma independente.
  - As rotas dos carros foram sorteadas junto com sua direção(hóraria ou anti-hóraria)
- **Controle de Conflitos**:
  - Utilização de semáforos para gerenciar o acesso aos cruzamentos.
  - Exclusão mútua garantida nos pontos de interseção das rotas.
- **Interatividade**:
  - Ao clicar em um carro, é exibida a rota completa que ele irá seguir.

---

## Objetivos do Projeto
- Garantir que os carros sigam suas rotas sem colisões.
- Demonstrar o uso de **semáforos** para gerenciar zonas críticas em um ambiente concorrente.
- Simular um cenário realista de trânsito autônomo com controle eficiente de recursos compartilhados.

---

## Tecnologias Utilizadas
- **Linguagem de Programação**: Java
- **Biblioteca Gráfica**: JavaFX para simulação e interatividade.
- **Conceitos de Concorrência**:
  - Semáforos para controle de acesso às zonas críticas.
  - Gerenciamento de threads para simular o movimento dos carros.

---

## Estrutura do Projeto
1. **Carros**: Cada carro é representado como uma thread que executa sua rota predefinida.
2. **Rotas**: As rotas são sorteadas no início e representadas como caminhos no mapa.
3. **Zonas Críticas**: Pontos de interseção nas rotas são tratados como zonas críticas controladas por semáforos.
4. **Interação**: Clique em um carro para visualizar sua rota no mapa.

---
## Como Executar
1. Clone este repositório:
   ```bash
   git clone https://github.com/FrancoBorba/JantarDosFilosofos.git
2. Abra o projeto em sua IDE de preferência.
3. Compile e execute o código principal para iniciar a simulação.

## Aprendizados
- Implementação de soluções clássicas para problemas de concorrência.
- Análise comparativa de desempenho entre as soluções (eficiência e simplicidade).
- Desenvolvimento de aplicações concorrentes em Java.

## Autor
**Franco Ribeiro Borba**
- **Curso**: Ciência da Computação, 4º semestre
- **Instituição**: UESB (Universidade Estadual do Sudoeste da Bahia)
- **Professor Orientador**: Marlos Marques

## Licença
Este projeto é licenciado sob a Licença MIT. Consulte o arquivo `LICENSE` para mais informações.

## Contato
- [LinkedIn](https://www.linkedin.com/in/franco-borba-37462825b/)
- Email: franco.borba14@gmail.com

