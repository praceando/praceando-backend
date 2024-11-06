// Seleciona todos os botões dentro de elementos com a classe "caixaFAQ"
const items = document.querySelectorAll(".caixaFAQ button");

// Função para alternar o estado do acordeão
function toggleAccordion() {
  // Obtém o valor do atributo 'aria-expanded' do botão clicado
  const itemToggle = this.getAttribute('aria-expanded');
  
  // Itera sobre todos os botões para fechar os que estão abertos
  for (let i = 0; i < items.length; i++) {
    items[i].setAttribute('aria-expanded', 'false'); // Define todos como fechados
  }
  
  // Se o botão clicado estava fechado, abre-o
  if (itemToggle == 'false') {
    this.setAttribute('aria-expanded', 'true'); // Define o botão clicado como aberto
  }
}

// Adiciona um ouvinte de evento de clique para cada botão
items.forEach(item => item.addEventListener('click', toggleAccordion));
