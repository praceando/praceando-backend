(function() {
  // Seleciona todos os links internos (aqueles que começam com #)
  const linksInternos = document.querySelectorAll('a[href^="#"]');

  linksInternos.forEach(link => {
      link.addEventListener('click', function(event) {
          event.preventDefault();  // Impede o comportamento padrão do link

          const targetId = this.getAttribute('href').substring(1);  // Pega o id do link
          const targetElement = document.getElementById(targetId);

          // Verifica se o elemento de destino existe
          if (targetElement) {
              window.scrollTo({
                  top: targetElement.offsetTop,
                  behavior: 'smooth'  // Efeito de rolagem suave
              });
          }
      });
  });
})();
