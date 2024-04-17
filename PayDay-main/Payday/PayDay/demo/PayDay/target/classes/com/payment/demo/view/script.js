document.addEventListener('DOMContentLoaded', function () {
    const empregadorSelect = document.getElementById('empregadorSelect');
    const funcionarioSelect = document.getElementById('funcionarioSelect');
    const form = document.getElementById('selectionForm');

    // Função para preencher o select de empregadores
    function fillEmpregadoresSelect(empregadores) {
        empregadores.forEach(empregador => {
            const option = document.createElement('option');
            option.textContent = `${empregador.nome} - CNPJ: ${empregador.documento}`;
            option.value = JSON.stringify(empregador);
            empregadorSelect.appendChild(option);
        });
    }

    // Função para preencher o select de funcionários
    function fillFuncionariosSelect(funcionarios) {
        funcionarios.forEach(funcionario => {
            const option = document.createElement('option');
            option.textContent = funcionario.nome;
            option.value = JSON.stringify(funcionario);
            funcionarioSelect.appendChild(option);
        });
    }

    // Função para calcular o salário bruto do funcionário com base nos eventos
    function calcularSalarioBruto(eventos) {
        // Lógica para calcular o salário bruto, por exemplo:
        let salarioBase = 2000; // Salário base do funcionário
        let totalHorasExtras = eventos.horaExtra50 * 1.5 + eventos.horaExtra100 * 2; // Valor total das horas extras
        let salarioBruto = salarioBase + totalHorasExtras; // Salário bruto incluindo horas extras
        return salarioBruto;
    }

    // Função para calcular o salário líquido do funcionário com base nos eventos
    function calcularSalarioLiquido(salarioBruto, eventos) {
        // Lógica para calcular o salário líquido, por exemplo:
        let descontos = eventos.faltas * 100; // R$100 de desconto por falta
        let salarioLiquido = salarioBruto - descontos; // Salário líquido após descontos
        return salarioLiquido;
    }

    // Função para gerar o holerite na tela
    function gerarHolerite(empregador, funcionario, eventos) {
        // Calcular o salário bruto
        const salarioBruto = calcularSalarioBruto(eventos);

        // Calcular o salário líquido
        const salarioLiquido = calcularSalarioLiquido(salarioBruto, eventos);

        // Exibir todas as informações no holerite
        const holeriteDiv = document.createElement('div');
        holeriteDiv.innerHTML = `
            <h2>Holerite de ${funcionario.nome}</h2>
            <p>Empregador: ${empregador.nome}</p>
            <p>CNPJ: ${empregador.documento}</p>
            <p>Documento: ${funcionario.documento}</p>
            <p>Endereço: ${funcionario.endereco}</p>
            <p>Telefone: ${funcionario.telefone}</p>
            <p>Email: ${funcionario.email}</p>
            <p>Data de Nascimento: ${funcionario.dataDeNascimento}</p>
            <p>Sexo: ${funcionario.sexo}</p>
            <p>Grau de Instrução: ${funcionario.grauDeInstrucao}</p>
            <p>Nome do Pai: ${funcionario.nomeDoPai}</p>
            <p>Nome da Mãe: ${funcionario.nomeDaMae}</p>
            <p>Raça: ${funcionario.raca}</p>
            <p>Ativo/Inativo: ${funcionario.ativoInativo}</p>
            <p>Cargo: ${funcionario.cargo}</p>
            <p>Jornada de Trabalho: ${funcionario.jornadaDeTrabalho}</p>
            <p>Categoria: ${funcionario.categoria}</p>
            <p>Hora Extra 50%: ${eventos.horaExtra50}</p>
            <p>Hora Extra 100%: ${eventos.horaExtra100}</p>
            <p>Faltas: ${eventos.faltas}</p>
            <p>Atraso: ${eventos.atraso}</p>
            <p>Descanso Semanal Remunerado: ${eventos.descansoSemanalRemunerado}</p>
            <p>Adicional Noturno: ${eventos.adicionalNoturno}</p>
            <p>Diária de Viagem: ${eventos.diariaViagem}</p>
            <p>Auxílio Creche/Babá: ${eventos.auxilioCrecheBaba}</p>
            <p>Salário Família: ${eventos.salarioFamilia}</p>
            <p>Salário Bruto: ${salarioBruto}</p>
            <p>Salário Líquido: ${salarioLiquido}</p>
            <!-- Adicione mais detalhes do holerite conforme necessário -->
        `;
        document.body.appendChild(holeriteDiv);
    }

    // Função para lidar com o envio do formulário
    function handleSubmit(event) {
        event.preventDefault();

        // Obter os valores selecionados e inseridos pelo usuário
        const empregadorSelecionado = JSON.parse(empregadorSelect.value);
        const funcionarioSelecionado = JSON.parse(funcionarioSelect.value);

        // Obter os valores dos eventos preenchidos pelo usuário
        const eventos = {
            horaExtra50: parseFloat(document.getElementById('horaExtra50').value),
            horaExtra100: parseFloat(document.getElementById('horaExtra100').value),
            faltas: parseFloat(document.getElementById('faltas').value),
            atraso: parseFloat(document.getElementById('atraso').value),
            descansoSemanalRemunerado: parseFloat(document.getElementById('descansoSemanalRemunerado').value),
            adicionalNoturno: parseFloat(document.getElementById('adicionalNoturno').value),
            diariaViagem: parseFloat(document.getElementById('diariaViagem').value),
            auxilioCrecheBaba: parseFloat(document.getElementById('auxilioCrecheBaba').value),
            salarioFamilia: parseFloat(document.getElementById('salarioFamilia').value)
        };

        // Gerar o holerite na tela
        gerarHolerite(empregadorSelecionado, funcionarioSelecionado, eventos);
    }

    // Preencher os selects quando o DOM estiver carregado
    fetch('http://localhost:8080/empregadores/get')
        .then(response => response.json())
        .then(data => fillEmpregadoresSelect(data))
        .catch(error => console.error('Erro ao buscar empregadores:', error));

    fetch('http://localhost:8080/funcionarios/get')
        .then(response => response.json())
        .then(data => fillFuncionariosSelect(data))
        .catch(error => console.error('Erro ao buscar funcionários:', error));

    // Adicionar um ouvinte de evento para o envio do formulário
    form.addEventListener('submit', handleSubmit);
});
