(function() {
  // Definição de constantes
  const trilha = document.querySelector('.carousel-track2'); // A trilha do carrossel
  const cartoes = [...document.querySelectorAll('.carousel-card2')]; // Seleciona todos os cartões do carrossel
  const botaoProximo = document.querySelector('.right-btn2'); // O botão para avançar

  // Definição de variáveis
  let indice = 1;  // Começa no primeiro cartão real (considerando os clones)
  let arrastando = false; // Indica se o usuário está arrastando
  let posicaoInicial = 0; // Posição inicial do toque/clique
  let traducaoAtual = 0; // Posição atual da tradução do carrossel
  let traducaoAnterior = 0; // Posição anterior da tradução do carrossel
  let idAnimacao = 0; // ID da animação em execução
  const cartoesVisiveis = 3; // Número de cartões visíveis de cada vez
  const larguraCartao = cartoes[0].clientWidth; // Largura de cada cartão

  // Clona o primeiro e o último conjunto de cartões para criar o efeito infinito
  const cloneInicial = [...cartoes.slice(0, cartoesVisiveis)].map(cartao => cartao.cloneNode(true));
  const cloneFinal = [...cartoes.slice(-cartoesVisiveis)].map(cartao => cartao.cloneNode(true));

  cloneInicial.forEach(cartao => trilha.appendChild(cartao)); // Adiciona clones ao final
  cloneFinal.forEach(cartao => trilha.prepend(cartao)); // Adiciona clones ao início

  // Atualiza todosOsCartoes para incluir os clones
  const todosOsCartoes = [...document.querySelectorAll('.carousel-card2')];

  // Define a posição inicial para o primeiro conjunto real de cartões
  trilha.style.transform = `translateX(${-larguraCartao * cartoesVisiveis}px)`;

  // Navegação pelo botão (direita)
  botaoProximo.addEventListener('click', () => {
    if (indice >= todosOsCartoes.length - cartoesVisiveis) return;
    indice++;
    moverParaCartao(indice);
  });

  // Funcionalidade de arrasto
  trilha.addEventListener('mousedown', iniciarArrasto);
  trilha.addEventListener('touchstart', iniciarArrasto);
  trilha.addEventListener('mouseup', finalizarArrasto);
  trilha.addEventListener('touchend', finalizarArrasto);
  trilha.addEventListener('mouseleave', finalizarArrasto);
  trilha.addEventListener('mousemove', arrastar);
  trilha.addEventListener('touchmove', arrastar);

  function moverParaCartao(indiceCartao) {
    trilha.style.transition = 'transform 0.5s ease'; // Define a transição
    traducaoAtual = -indiceCartao * larguraCartao; // Calcula a nova posição
    trilha.style.transform = `translateX(${traducaoAtual}px)`; // Aplica a transformação
  }

  function iniciarArrasto(e) {
    arrastando = true; // Indica que o usuário está arrastando
    posicaoInicial = obterPosicaoX(e); // Armazena a posição inicial do arrasto
    idAnimacao = requestAnimationFrame(animacao); // Inicia a animação
    trilha.classList.add('grabbing'); // Adiciona estilo de "agarrando"
  }

  function arrastar(e) {
    if (arrastando) {
      const posicaoAtual = obterPosicaoX(e); // Obtém a posição atual
      const movimento = posicaoAtual - posicaoInicial; // Calcula o movimento
      traducaoAtual = traducaoAnterior + movimento; // Atualiza a posição atual
    }
  }

  function finalizarArrasto() {
    arrastando = false; // Indica que o arrasto terminou
    cancelAnimationFrame(idAnimacao); // Cancela a animação
    trilha.classList.remove('grabbing'); // Remove o estilo de "agarrando"

    const movidoPor = traducaoAtual - traducaoAnterior; // Calcula o quanto foi movido
    if (movidoPor < -100 && indice < todosOsCartoes.length - cartoesVisiveis) indice++;
    if (movidoPor > 100 && indice > 0) indice--;

    moverParaCartao(indice); // Move para o cartão atualizado
    traducaoAnterior = traducaoAtual; // Atualiza a posição anterior

    // Looping
    trilha.addEventListener('transitionend', verificarLoop);
  }

  function verificarLoop() {
    // Volta dos cartões clonados para os cartões reais (movendo para a direita)
    if (todosOsCartoes[indice].querySelector('img').alt === cloneInicial[0].querySelector('img').alt) {
      trilha.style.transition = 'none'; // Remove a transição para ajuste instantâneo
      indice = cartoesVisiveis; // Redefine o índice para o meio do carrossel
      trilha.style.transform = `translateX(${-larguraCartao * indice}px)`; // Ajusta a posição
    }
  }

  function obterPosicaoX(e) {
    return e.type.includes('mouse') ? e.pageX : e.touches[0].clientX; // Retorna a posição correta
  }

  function animacao() {
    trilha.style.transform = `translateX(${traducaoAtual}px)`; // Atualiza a posição
    if (arrastando) requestAnimationFrame(animacao); // Continua a animação enquanto arrastando
  }

  document.addEventListener('mousedown', (event) => {
    event.preventDefault(); // Previne o comportamento padrão do mouse
  });
})();
