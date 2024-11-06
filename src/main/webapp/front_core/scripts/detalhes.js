(function() {
    // Manipulador para exibir o pop-up
    document.getElementById('mostrarImagem').onclick = function(event) {
        event.preventDefault(); // Impede o comportamento padrão do link
        document.getElementById('popup').style.display = 'flex'; // Mostra o pop-up
    };

    // Manipulador para fechar o pop-up
    document.getElementById('fecharPopup').onclick = function() {
        document.getElementById('popup').style.display = 'none'; // Oculta o pop-up
    };

    // Manipulador para fechar o pop-up ao clicar fora da imagem
    window.onclick = function(event) {
        if (event.target === document.getElementById('popup')) {
            document.getElementById('popup').style.display = 'none'; // Fecha ao clicar fora
        }
    };
})();
