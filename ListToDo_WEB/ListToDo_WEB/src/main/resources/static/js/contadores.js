document.addEventListener('DOMContentLoaded', function () {
    const senhaInput = document.getElementById('senha');
    const contador = document.getElementById('senha-contador');
    const erro = document.getElementById('senha-erro');
    const maxLength = 18;

    senhaInput.addEventListener('input', function() {
        const length = senhaInput.value.length;
        contador.textContent = `${length} / ${maxLength} caracteres`;
        if (length > maxLength) {
            erro.style.display = 'block';
        } else {
            erro.style.display = 'none';
        }
    });
});
