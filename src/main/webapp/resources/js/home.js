// Esperar a que la página cargue
$(function() {
    // Asignar evento click a los elementos marcados con data-id
    $('[data-id]').on('click', function() {
        // Recuperar identificador
        let id = $(this).data('id');

        // Redireccionar según identificador
        $(location).attr('href', '/awakelab-ensayo-reclutamiento/' + id);
    });
});
