# 🏬 Sistema de Monitoramento e Controle de Estoque

<sub>*Solução escalável e eficiente para gestão de estoque em tempo real para pequenas e médias empresas.*</sub>

<div align="center">
 <img height=250 width=250 src="https://media.tenor.com/KSYEM2r0IIAAAAAi/moving-cute-boxes-cat-tired.gif">
</div>

---

## 📜 Índice

- [ℹ️ Informações](#-informações)
- [💡 Visão Geral](#-visão-geral)
- [🎯 Proposta do Projeto](#-proposta-do-projeto)
- [📈 Contexto e Justificativa](#-contexto-e-justificativa)
- [🛠️ Arquitetura do Sistema](#-arquitetura-do-sistema)
- [💻 Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [🧩 Funcionalidades](#-funcionalidades)
- [🏗️ Arquitetura](#%EF%B8%8F-arquitetura)
- [🔄 Fluxo de Operações](#-fluxo-de-operações)
- [📥 Instalação e Execução](#-instalação-e-execução)
- [📊 Benefícios para o Investidor](#-benefícios-para-o-investidor)
- [📌 Conclusão](#-conclusão)

---
## ℹ️ Informações

- **Status:** Em andamento
- **Integrantes:** Esthevan Pereira, Lucas Ramon, Maria Eduarda Maia, Maurício Krziminski
- **Link:** [Link Repositorio](https://github.com/DudaWendelMaia/T2-Projarc.git)
---
## 💡 Visão Geral

Este projeto é um **Sistema de Monitoramento e Controle de Estoque** desenvolvido especialmente para **Pequenas e Médias Empresas (PMEs)**. Utilizando uma arquitetura de **microsserviços**, o sistema oferece:

- **Monitoramento em tempo real** de produtos
- **Alertas automáticos** para reabastecimento
- **Escalabilidade** para crescer junto com a empresa
- **Relatórios de desempenho e insights**

---

## 🎯 Proposta do Projeto

Desenvolver uma solução capaz de **gerenciar estoques** com eficiência, automatizando o processo de controle e reposição de produtos. A estrutura modular em microsserviços permite uma manutenção simplificada e uma escalabilidade flexível, adequada para o aumento de demandas e operações de vendas.

---

## 📈 Contexto e Justificativa

Em empresas de menor porte, a gestão de estoque é um dos principais desafios. A **falta de produtos** ou **estoque em excesso** impactam diretamente nas finanças. Este sistema:

- **Reduz a dependência** de processos manuais
- **Minimiza perdas** com controle de inventário em tempo real
- **Facilita a reposição** com alertas automatizados e gestão centralizada

---

## 🧩 Funcionalidades

O sistema possui várias funcionalidades voltadas para a **eficiência na gestão de estoques**, como:

1. **Cadastro e Gerenciamento de Produtos**
   - Adicione, edite e visualize produtos, incluindo dados como categoria, fornecedor e preço.

2. **Gestão de Estoque em Tempo Real**
   - Controle de entradas e saídas de produtos com atualizações em tempo real, permitindo consultas rápidas.

3. **Notificações e Alertas Automáticos**
   - Receba alertas quando os produtos estiverem em níveis críticos de estoque, promovendo reabastecimento proativo.

4. **Relatórios e Análises de Estoque**
   - Geração de relatórios com insights sobre produtos de alta rotatividade, períodos de maior consumo e itens em risco de falta.

5. **Reabastecimento Automático**
   - Gera pedidos automáticos para fornecedores quando o estoque atinge níveis baixos, reduzindo a chance de rupturas.

---

## 🏗️ Arquitetura

A arquitetura deste sistema é baseada em **microsserviços**, cada um responsável por uma funcionalidade específica e interligado por um **Gateway de API**.

### Componentes da Arquitetura:

- **Gateway de API**: Ponto de entrada para todas as requisições, gerenciando autenticação, roteamento e balanceamento de carga.
- **Cache Distribuído**: Otimiza consultas frequentes, acelerando o tempo de resposta para dados de estoque e produtos.
- **Microsserviços Independentes**: Cada serviço é isolado e gerencia sua responsabilidade:
  - **Cadastro de Produtos**: Gerencia informações dos produtos e atualiza o cache.
  - **Serviço de Estoque**: Registra entradas e saídas, envia alertas de nível crítico.
  - **Relatórios e Análises**: Gera relatórios de rotatividade e itens críticos.
  - **Notificações e Alertas**: Envia notificações aos administradores.
  - **Pedidos e Reabastecimento**: Gera pedidos de reabastecimento automáticos.

### Banco de Dados

Utilizamos o **H2 Database** em ambiente de desenvolvimento e testes, garantindo praticidade sem necessidade de configuração complexa.

---

## ⚙️ Configuração do Projeto

Para configurar o projeto, siga os passos abaixo:

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/DudaWendelMaia/T2-Projarc.git
   cd estoque-microsservicos
   ```


2. **Instalação das Dependências**:
   - Execute o Maven para instalar as dependências:
   ```bash
   mvn clean install
   ```

---

## 📥 Instalação e Execução

### Pré-requisitos

- **Java 17**
- **Maven**

### Instruções de Instalação

1. **Configuração das Variáveis de Ambiente**
   - Verifique que o **Java 17** e o **Maven** estejam corretamente configurados em seu sistema.

2. **Compilação do Projeto**
   - No diretório raiz do projeto, execute:
   ```bash
   mvn clean install
   ```

3. **Executando a Aplicação**
   - Para iniciar a aplicação, utilize:
   ```bash
   mvn spring-boot:run
   ```

4. **Acessando a Aplicação**
   - A aplicação estará disponível em `http://localhost:8080`.

5. **Documentação da API**
   - Acesse a documentação da API gerada automaticamente pelo OpenAPI em `http://localhost:8080/swagger-ui.html`.

---

## 🔄 Fluxo de Operações

1. **Cadastro de Novo Produto**
   - O administrador insere um novo produto através do gateway, que direciona a requisição ao Serviço de Cadastro. O cache é atualizado com as novas informações.

2. **Atualização de Estoque**
   - Entradas e saídas de produtos são registradas no Serviço de Estoque. Quando atinge o nível mínimo, um alerta é gerado.

3. **Consultas de Relatórios**
   - Relatórios são consultados para entender o desempenho do estoque. Dados frequentemente consultados são mantidos no cache.

4. **Pedido de Reabastecimento Automático**
   - Ao atingir o estoque mínimo, um pedido de reabastecimento é gerado e enviado ao fornecedor. O status do pedido é armazenado temporariamente no cache.

---

## 📊 Benefícios para o Investidor

Investir neste sistema proporciona várias vantagens:

- **Escalabilidade e Flexibilidade**: A arquitetura permite o crescimento sem comprometer o desempenho.
- **Desempenho Otimizado**: Cache reduz o tempo de resposta, melhorando a experiência e aliviando o banco de dados.
- **Segurança e Controle**: O gateway centraliza a autenticação e controle de tráfego, oferecendo segurança adicional.
- **Redução de Perdas**: Monitora o estoque continuamente, minimizando perdas e facilitando o controle de inventário.
