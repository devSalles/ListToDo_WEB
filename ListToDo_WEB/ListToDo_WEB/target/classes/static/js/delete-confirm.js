document.addEventListener('DOMContentLoaded', function () {
    var confirmDeleteModal = document.getElementById('confirmDeleteModal');
    if (confirmDeleteModal) {
        confirmDeleteModal.addEventListener('show.bs.modal', function (event) {
            var button = event.relatedTarget; // Botão que abriu o modal
            var tarefaId = button.getAttribute('data-id');
            var deleteForm = document.getElementById('deleteForm');
            if (deleteForm && tarefaId) {
                deleteForm.setAttribute('action', '/tarefa/delete/' + tarefaId);
            }
        });
    }
});
