## Sistema Online Sobre Informações Factíveis de Oficiais de justiça Do paraná
<p>Este é um sistema de controle de oficial de justiça e sua alocação para executar intimações. Os dados básicos são:</p>

- Oficial de Justiça: CPF, Nome, e-mail
- Intimação: Data/Hora da intimação, CPF do intimado, Nome do intimado, Endereço do intimado, Data/hora da execução da intimação, Estado se a intimação foi efetuada ou não, Oficial de Justiça alocado, processo
<p>Há um perfil administrador que cadastra os oficiais de Justiça e mantém (crud) as intimações. Uma intimação pode ser feita automaticamente através do sistema SIJOGA. Neste caso, quando a intimação é executada, o sistema SOSIFOD automaticamente sinaliza o sistema SIJOGA sobre a execução da intimação.</p>
<p>Há também um perfil Oficial de Justiça, cujos usuários são cadastrados pelo administrador. O oficial de justiça tem acesso a todas intimações alocadas para ele e pode indicar a execução dela.</p>

### Requisitos não-funcionais

<p>Toda e qualquer suposição, que não esteja definida aqui e que a equipe faça, deve ser devidamente documentada e entregue em um arquivo .PDF que acompanha o trabalho.</p>
<p>Os requisitos não-funcionais mínimos são:</p>

- A comunicação entre os sistemas deve ser feita através de Web Services tipo REST, obrigatoriamente;
- Senhas devem ser criptografadas;
- O leiaute deve seguir preceitos de usabilidade e ergonomia, usar o ErgoList como direcionador (http://www.labiutil.inf.ufsc.br/ergolist/);
- O leiaute deve ser agradável;
- Validação de campos deve ser implementada em duas etapas - cliente com Javascript e servidor em Java;
- Todas as datas e valores monetários devem ser entrados e mostrados no formato brasileiro;
- Todos os campos que tiverem formatação devem possuir máscara;
- Todas as datas deverão ser entradas através de calendários;
- Todos os relatórios devem ser feitos em PDF (usar JasperStudio);
- O banco de dados deve estar normalizado apropriadamente.
