(function() {
    // Função para verificar a página atual e controlar a seleção
    function verificarPagina() {
      const pagina = document.querySelector('section[id]'); // Seleciona a seção com id (como 'pagina11', 'pagina12')
      
      // Verifica se estamos nas páginas 11 ou 12
      if (pagina && (pagina.id === "pagina11" || pagina.id === "pagina12")) {
        // Se estivermos na página 11 ou 12, **desabilita a seleção de texto**
        document.body.classList.add('noselect'); // Adiciona a classe 'noselect' para desabilitar a seleção
      } else {
        // Caso contrário, **permite a seleção de texto**
        document.body.classList.remove('noselect'); // Remove a classe 'noselect' para permitir a seleção
      }
    }
  
    // Chama a função para verificar a página ao carregar a página
    verificarPagina();
  
    // Escuta mudanças de hash na URL (para navegação interna, como #pagina11)
    window.addEventListener('hashchange', verificarPagina);
  
  })();
  