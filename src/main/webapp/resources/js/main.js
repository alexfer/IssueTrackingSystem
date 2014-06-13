$(document).ready(function() {
    var body = $('body');

    var flashMessage = function(_class, message) {
        var alert = $('.alert');
        alert.addClass(_class).html(message).fadeIn();
        setTimeout(function() {
            alert.removeClass(_class).html('').fadeOut();
        }, 5000);
    };

    var request = function(self, method, url, callback) {
        var data = {};
        if (self !== '') {
            data = self.serialize();
        }
        $.ajax({
            url: url,
            type: method,
            dataType: 'json',
            data: data,
            success: function(response) {
                if (response.success === false) {
                    flashMessage('alert-danger', response.message);
                } else {
                    if (callback) {
                        return callback();
                    }
                    flashMessage('alert-success', response.message);                    
                }
            },
            error: function(xml_http_request, text_status, error_thrown) {
                alert(xml_http_request.status + ' ' + error_thrown);
            }
        });
        return false;
    };

    $('#new-user').on('submit', function(e) {
        request($(this), "POST", "/user");
        e.preventDefault();
    });
    $('#edit-user').on('submit', function(e) {
        request($(this), "POST", document.URL);
        e.preventDefault();
    });

    $('.delete-user').on('click', function(e) {
        request('', "DELETE", "/user/" + $(this).attr('data-id'), function() {
            window.location.href = '/' + window.location.pathname.split('/')[1];
        });
        e.preventDefault();
    });

    body.find('.cancel').on('click', function() {
        window.location.href = '/' + window.location.pathname.split('/')[1];
    });
});