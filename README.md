# ManyToMany

### 1. Paciente * <--------------------------> * Médico
### 2. Programador * <--------------------------> * Projeto
#### A. Definindo collection (list) tanto para o Pai quanto para os objetos Filhos.
#### B. Um paciente terá uma lista de Médicos que ele pode ir.
#### C. E um Médico terá uma lista de Pacientes que ele trata.
|   Paciente   | Médico |
|   :---:     |   :---:     |
| List < Paciente > pacientes;  | List < Medico > medicos; |
|   | |
#### D. Fazendo uma associação ManyToMany, no database terá que ter três tabelas, uma para cada Entidade:
|   Paciente   | :---: | :---: |
|   :---:     |   :---:     |   :---:     |
| id  | firstName  | lastName |
| 1 |:---: | :---:  |
| 2 |:---: | :---:  |
##### tabela que mapeiará estes dois ( Paciente e Médico ) em uma associação ManyToMany.
|   paciente_medico   | :---: |
|   :---:     |   :---:     |
| paciente_id |medico_id |
| 1 |2 |
| 2 |2 |
####
|   Médico   | :---: | :---: |
|   :---:     |   :---:     |   :---:     |
| id  | firstName  | lastName |
| 1 |:---: | :---:  |
| 2 |:---: | :---:  |
#### D. Paciente 1 e 2, ambos estão indo a Médico com o ID 2.
#### E. Se nós quisermos salvar o objeto Pai num dos objetos associados e quiser salvar o Filho, simplesmente, ligamos o Filho ao Pai que está salvando Paciente completamente.
#### F. Se quisermos salvar as novas informações, poderemos simplesmente adicionar isso na lista de medicos no Paciente.
#### G. E quando salvar Paciente, automaticamente as informações de Medico também serão salvas.
#### H. É possível aplicar lazy loading e Cascading Effect.
