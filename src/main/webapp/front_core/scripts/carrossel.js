(function() {
    // Definição de constantes
    const trilha = document.querySelector('.carousel-track'); // A trilha do carrossel
    const cartoes = [...document.querySelectorAll('.carousel-card')]; // Seleciona todos os cartões do carrossel
    const botaoProximo = document.querySelector('.right-btn2'); // Corrigido: Seleção do botão correto
  
    // Definição de variáveis
    let indiceAtual = 1; // Índice do cartão atualmente visível
    let arrastando = false; // Indica se o usuário está arrastando
    let posicaoInicial = 0; // Posição inicial do toque/ clique
    let traducaoAtual = 0; // Posição atual da tradução do carrossel
    let traducaoAnterior = 0; // Posição anterior da tradução do carrossel
    let idAnimacao = 0; // ID da animação em execução
    const cartoesVisiveis = 3; // Número de cartões visíveis no carrossel
    const larguraCartao = cartoes[0].clientWidth; // Largura de um cartão
  
    // Clona os primeiros e últimos cartões para permitir uma rolagem infinita
    const cloneInicial = [...cartoes.slice(0, cartoesVisiveis)].map(cartao => cartao.cloneNode(true));
    const cloneFinal = [...cartoes.slice(-cartoesVisiveis)].map(cartao => cartao.cloneNode(true));
  
    // Adiciona os clones à trilha do carrossel
    cloneInicial.forEach(cartao => trilha.appendChild(cartao)); 
    cloneFinal.forEach(cartao => trilha.prepend(cartao));      
  
    // Seleciona todos os cartões (incluindo os clones)
    const todosOsCartoes = [...document.querySelectorAll('.carousel-card')];
  
    // Define a posição inicial da trilha do carrossel para exibir corretamente os cartões
    trilha.style.transform = `translateX(${-larguraCartao * cartoesVisiveis}px)`;
  
    // Adiciona um ouvinte de evento ao botão "próximo"
    botaoProximo.addEventListener('click', () => {
        // Evita que o usuário ultrapasse o número total de cartões
        if (indiceAtual >= todosOsCartoes.length - cartoesVisiveis) return;
        indiceAtual++; // Avança para o próximo cartão
        moverParaCartao(indiceAtual); // Move para o cartão correspondente
    });
  
    // Adiciona ouvintes de evento para manipulação de arrasto
    trilha.addEventListener('mousedown', iniciarArrasto);
    trilha.addEventListener('touchstart', iniciarArrasto);
    trilha.addEventListener('mouseup', finalizarArrasto);
    trilha.addEventListener('touchend', finalizarArrasto);
    trilha.addEventListener('mouseleave', finalizarArrasto);
    trilha.addEventListener('mousemove', arrastar);
    trilha.addEventListener('touchmove', arrastar);
  
    // Função para mover o carrossel para o cartão especificado
    function moverParaCartao(indiceCartao) {
        trilha.style.transition = 'transform 0.5s ease'; // Define a transição
        traducaoAtual = -indiceCartao * larguraCartao; // Calcula a nova posição
        trilha.style.transform = `translateX(${traducaoAtual}px)`; // Aplica a transformação
    }
  
    // Inicia o arrasto do carrossel
    function iniciarArrasto(e) {
        arrastando = true;
        posicaoInicial = obterPosicaoX(e);
        idAnimacao = requestAnimationFrame(animacao);
        trilha.classList.add('grabbing');
        
        // Impede a seleção de texto dentro do carrossel durante o arrasto
        document.querySelector('.carousel-container').classList.add('no-select');
    }
  
    // Atualiza a posição do carrossel enquanto arrasta
    function arrastar(e) {
        if (arrastando) {
            const posicaoAtual = obterPosicaoX(e);
            const movimento = posicaoAtual - posicaoInicial;
            traducaoAtual = traducaoAnterior + movimento;
        }
    }
  
    // Finaliza o arrasto
    function finalizarArrasto() {
        arrastando = false;
        cancelAnimationFrame(idAnimacao);
        trilha.classList.remove('grabbing');
        
        // Permite a seleção de texto novamente dentro do carrossel
        document.querySelector('.carousel-container').classList.remove('no-select');
  
        const movidoPor = traducaoAtual - traducaoAnterior;
        if (movidoPor < -100 && indiceAtual < todosOsCartoes.length - cartoesVisiveis) indiceAtual++;
        if (movidoPor > 100 && indiceAtual > 0) indiceAtual--;
  
        moverParaCartao(indiceAtual);
        traducaoAnterior = traducaoAtual;
  
        trilha.addEventListener('transitionend', verificarLoop);
    }
  
    // Verifica se é necessário ajustar o índice após o movimento
    function verificarLoop() {
        if (todosOsCartoes[indiceAtual].querySelector('img').alt === cloneInicial[0].querySelector('img').alt) {
            trilha.style.transition = 'none';
            indiceAtual = cartoesVisiveis;
            trilha.style.transform = `translateX(${-larguraCartao * indiceAtual}px)`;
        }
    }
  
    // Obtém a posição X do evento (mouse ou toque)
    function obterPosicaoX(e) {
        return e.type.includes('mouse') ? e.pageX : e.touches[0].clientX;
    }
  
    // Função de animação para atualizar a posição do carrossel
    function animacao() {
        trilha.style.transform = `translateX(${traducaoAtual}px)`;
        if (arrastando) requestAnimationFrame(animacao);
    }
  
    // Previne o comportamento padrão do mouse para garantir arrasto suave
    document.addEventListener('mousedown', (event) => {
        event.preventDefault();
    });
})();
