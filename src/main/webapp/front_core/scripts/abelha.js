function iniciarRotacaoAbelha(circuloId, abelhaId, raio, velocidade, top) {
    // Obtém os elementos DOM da abelha e do círculo usando seus IDs
    const abelha = document.getElementById(abelhaId);
    const circulo = document.getElementById(circuloId);
    
    let angulo = 0; // Ângulo inicial para a rotação
    let ultimaPosicaoScroll = window.scrollY; // Armazena a última posição de rolagem da página

    // Se detectada a rolagem da página:
    window.addEventListener('scroll', () => {
        // Calcula a posição de rolagem atual
        const posicaoScroll = window.scrollY - top;

        // Verifica se o usuário está rolando para baixo ou para cima
        if (posicaoScroll > ultimaPosicaoScroll) {
            // Rolando para baixo: aumenta o ângulo para girar a abelha
            angulo += velocidade;
        } else {
            // Rolando para cima: diminui o ângulo para girar a abelha na direção oposta
            angulo -= velocidade;
        }

        // Atualiza a última posição de rolagem
        ultimaPosicaoScroll = posicaoScroll;

        // Obtém as dimensões do círculo para calcular o centro
        const circuloRect = circulo.getBoundingClientRect();
        const centroX = circuloRect.left + raio; 
        const centroY = circuloRect.top + raio + posicaoScroll; // Ajusta o centro Y levando em conta a rolagem

        // Calcula a nova posição da abelha usando funções trigonométricas
        const x = Math.cos(angulo) * raio; 
        const y = Math.sin(angulo) * raio; 

        // Atualiza a posição da abelha no estilo CSS
        abelha.style.left = `${centroX + x}px`;
        abelha.style.top = `${centroY + y}px`;
    });
}

// Inicializa a rotação para várias abelhas com diferentes parâmetros
iniciarRotacaoAbelha('circulo1', 'abelha1', 200, 0.03, 1550);
iniciarRotacaoAbelha('circulo3', 'abelha3', 200, 0.03, 5200);
iniciarRotacaoAbelha('circulo4', 'abelha4', 200, 0.03, 9100);
iniciarRotacaoAbelha('circulo5', 'abelha5', 200, 0.03, 10350);
iniciarRotacaoAbelha('circulo6', 'abelha6', 250, 0.03, 12650);