PROJETO SISTEMAS

Participantes:
•	Eliel Pereira de Oliveira Filho
•	Kelvson Nilson da Silva
•	Artur Freitas 
 
Descrição do Projeto:
Este projeto é dividido em três sistemas principais, cada um com sua própria funcionalidade e responsável. O objetivo é criar soluções de software para diferentes cenários, como a gestão de eventos, restaurantes e clínicas, com foco na organização, automação de processos e geração de relatórios.


SISTEMA CLÍNICA (Responsáveis: Artur e Kelvson)

O sistema da clínica médica é composto por várias classes fundamentais que desempenham papéis específicos: Consulta.java ; GerenciamentoClinica.java ; GerenciamentoConsulta.java ; GerenciamentoMedico.java ; GerenciamentoPaciente.java ; Medico.java ; Paciente.java ; Relatorio.java.

O Sistema de Clínica é uma aplicação para o gerenciamento de pacientes e consultas em uma clínica médica. O sistema busca proporcionar uma melhor organização e controle sobre as consultas, além de facilitar o acesso às informações dos pacientes. Entre suas principais funcionalidades.

 • Agendar Consulta: Permite o agendamento de consultas para pacientes, facilitando o gerenciamento do calendário de atendimentos.

 • Cancelar Consulta: Possibilita o cancelamento de consultas previamente agendadas, assegurando que a agenda esteja sempre atualizada.

 • Buscar Consulta: Facilita a busca por consultas específicas, proporcionando acesso a informações sobre atendimentos passados e futuros.

 • Buscar Paciente: Permite a busca e visualização de dados dos pacientes, possibilitando um gerenciamento mais eficiente do histórico médico e dos agendamentos.

 • Buscar Médico: Facilita a busca e visualização de dados dos médicos, contribuindo para um gerenciamento eficaz das consultas e especialidades.

 • Tornar Médico Disponível: Permite alterar a disponibilidade de um médico, facilitando o controle de agendamentos.




SISTEMA RESTAURANTE (Responsável: Kelvson)

O sistema do restaurante é estruturado em torno de classes essenciais que permitem a gestão eficaz de mesas e pedidos: Mesa.java ; Pedido.java..

O Sistema de Restaurante é uma aplicação voltada para a gestão de mesas e pedidos em um restaurante. O sistema permite um gerenciamento eficiente das operações do dia a dia, otimizando o atendimento e melhorando a experiência dos clientes. Entre suas principais funcionalidades.

 •	Gerar pedido: Permite que os funcionários registrem novos pedidos dos clientes.

 •	Alterar pedido: Possibilita a modificação de pedidos já registrados.

 •	Cancelar pedido: Permite o cancelamento de pedidos específicos.

 •	Listar pedidos: Exibe todos os pedidos feitos, organizados por mesa ou cliente.

 •	Fechar pedido: Realiza o fechamento de um pedido, gerando a conta a ser paga.

 •	Gerar relatório de vendas: Cria um relatório detalhado sobre as vendas realizadas, facilitando a análise de desempenho e faturamento.



 
SISTEMA EVENTOS (Responsável: Eliel)

O sistema de eventos é composto por classes fundamentais que facilitam o gerenciamento de eventos e participantes: Evento.java ; Local.java ; Participante.java.

O Sistema de Eventos é uma aplicação para gerenciar eventos, incluindo o cadastro de novos eventos, adição de participantes, geração de relatórios e análise da taxa de participação. Entre suas principais funcionalidades, destacam-se:

•	Cadastro de eventos: Permite criar eventos com informações como nome, data, local e capacidade.

•	Adição de participantes: Os usuários podem registrar participantes nos eventos criados.

•	Geração de relatórios: O sistema gera relatórios detalhados para cada evento, exibindo informações sobre participantes e ocupação.

•	Análise da taxa de participação: O sistema calcula e exibe a taxa de participação dos eventos, listando-os em ordem decrescente de participação.





PERGUNTAS (Análise):

1)Qual médico é o mais solicitado para consultas ?

2)Quem são os pacientes com maior frequência de consultas ?

3)Quais itens do cardápio têm mais popularidade no restaurante ?

4)Quais eventos têm maior taxa de participação ?

5)Quais são as especialidades médicas mais demandadas ?


---------------==================-----------------===================---------------===========---------


### Aplicação dos Princípios SOLID

Este projeto foi desenvolvido seguindo os princípios SOLID para garantir a organização, extensibilidade e manutenção do código. Abaixo, explicamos como cada princípio foi aplicado:

1. **Responsabilidade Única (SRP)**: Cada classe possui uma única responsabilidade. Por exemplo, `GerenciamentoPaciente` é responsável apenas por cadastrar e buscar pacientes.

2. **Aberto/Fechado (OCP)**: O sistema permite a adição de novos tipos de agendamentos (como consultas, eventos, e reservas de mesa) sem modificar o código existente. Isso foi alcançado com a interface `Agendavel` e a classe abstrata `AgendamentoBase`.

3. **Substituição de Liskov (LSP)**: Todas as subclasses de `AgendamentoBase` (como `Consulta` e `Evento`) podem ser usadas onde uma instância de `Agendavel` é esperada, mantendo o comportamento esperado.

4. **Segregação de Interfaces (ISP)**: As interfaces foram projetadas para serem específicas e focadas. Por exemplo, `Agendavel` trata apenas de funcionalidades relacionadas a agendamentos.

5. **Inversão de Dependência (DIP)**: O sistema depende de abstrações, como `Agendavel` e `RelatorioGeneravel`, em vez de classes concretas.

Essa estrutura garante um código limpo, modular e preparado para futuras extensões.
