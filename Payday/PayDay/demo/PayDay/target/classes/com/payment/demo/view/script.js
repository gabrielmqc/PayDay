document.addEventListener('DOMContentLoaded', function() {
    // Carregar dados do arquivo JSON
    fetch('dados.json')
        .then(response => response.json())
        .then(data => {
            // Preencher opções de empregadores
            var empregadorSelect = document.getElementById('empregador');
            data.empregadores.forEach(empregador => {
                var option = document.createElement('option');
                option.value = empregador.id;
                option.textContent = empregador.nome + ' - CNPJ: ' + empregador.cnpj;
                empregadorSelect.appendChild(option);
            });

            // Preencher opções de funcionários
            var funcionarioSelect = document.getElementById('funcionario');
            data.funcionarios.forEach(funcionario => {
                var option = document.createElement('option');
                option.value = funcionario.id;
                option.setAttribute('data-salario', funcionario.salario);
                option.textContent = funcionario.nome + ' - CPF: ' + funcionario.cpf;
                funcionarioSelect.appendChild(option);
            });

            // Preencher opções de ex-funcionários
            var exFuncionarioSelect = document.getElementById('exFuncionario');
            data.exFuncionario.forEach(exFuncionario => {
                var option = document.createElement('option');
                option.value = exFuncionario.id;
                option.textContent = exFuncionario.nome + ' - CPF: ' + exFuncionario.cpf;
                exFuncionarioSelect.appendChild(option);
            });
        });

    // Adiciona um ouvinte de evento ao selecionar um funcionário
    document.getElementById('funcionario').addEventListener('change', function() {
        var exFuncionarioSelect = document.getElementById('exFuncionario');
        // Se um funcionário for selecionado, desabilita o menu suspenso de ex-funcionários
        exFuncionarioSelect.disabled = this.value !== "";
        // Se um funcionário for selecionado, limpa o valor selecionado do menu suspenso de ex-funcionários
        if (this.value !== "") {
            exFuncionarioSelect.value = "";
        }

        // Exibe o salário do funcionário selecionado
        var salarioElement = document.getElementById('salarioFuncionario');
        var salario = this.options[this.selectedIndex].getAttribute('data-salario');
        salarioElement.textContent = salario ? 'Salário do Funcionário: R$ ' + salario : '';
    });

    // Adiciona um ouvinte de evento ao selecionar um ex-funcionário
    document.getElementById('exFuncionario').addEventListener('change', function() {
        var funcionarioSelect = document.getElementById('funcionario');
        // Se um ex-funcionário for selecionado, desabilita o menu suspenso de funcionários
        funcionarioSelect.disabled = this.value !== "";
        // Se um ex-funcionário for selecionado, limpa o valor selecionado do menu suspenso de funcionários
        if (this.value !== "") {
            funcionarioSelect.value = "";
        }
    });
    
    // Adiciona um ouvinte de evento ao selecionar um evento
    document.getElementById('evento').addEventListener('change', function() {
        var valorMonetarioInput = document.getElementById('valorMonetario');
        var valorMonetarioLabel = document.querySelector('label[for="valorMonetario"]');
        // Lista de eventos que requerem valor monetário
        var eventosComValorMonetario = ["Hora extra", "Descanso Semanal Remunerado", "Adicional Noturno", "Salário Família", "Diária de Viagem", "Auxílio Creche/Babá"];
        // Verifica se o evento selecionado requer valor monetário
        if (eventosComValorMonetario.includes(this.value)) {
            // Se requer, exibe o campo de valor monetário
            valorMonetarioInput.style.display = 'block';
            valorMonetarioInput.required = true;
            valorMonetarioLabel.style.display = 'block';
        } else {
            // Caso contrário, oculta o campo de valor monetário
            valorMonetarioInput.style.display = 'none';
            valorMonetarioInput.required = false;
            valorMonetarioInput.value = ''; // Limpa o valor do campo
            valorMonetarioLabel.style.display = 'none';
        }
    });
});
