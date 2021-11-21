$(document).ready(function(){

    $('#searchBox').on('input', function() {
        var href = '/lookup/'+$("#searchBox").val();
        $('#go').prop('href', href.toString())
    });

});
