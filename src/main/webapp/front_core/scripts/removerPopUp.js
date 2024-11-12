
const botoesExcluir = document.getElementsByClassName("botao-excluir");

for (let i = 0; i < botoesExcluir.length; i++) {
    botoesExcluir[i].onclick = function(event) {
        event.preventDefault();
        const url = this.getAttribute("data-href");
        document.getElementById("modal-confirmacao").style.display = "block";
        document.getElementById("confirmar-exclusao").setAttribute("data-href", url);
    };
}

document.getElementById("fechar-modal").onclick = function() {
    document.getElementById("modal-confirmacao").style.display = "none";
};

document.getElementById("cancelar-exclusao").onclick = function() {
    document.getElementById("modal-confirmacao").style.display = "none";
};

document.getElementById("confirmar-exclusao").onclick = function() {
    const url = this.getAttribute("data-href");

    // Evitar em caso da url na JSP ser "null"
    // Admin, por exemplo, não permite exclusão, portanto a url vira null
    if (url !== "null") {
        console.log(url);
        window.location.href = url;
    } else {
        console.log("não")
    }
};

window.onclick = function(event) {
    const modal = document.getElementById("modal-confirmacao");
    if (event.target === modal) {
        modal.style.display = "none";
    }
};