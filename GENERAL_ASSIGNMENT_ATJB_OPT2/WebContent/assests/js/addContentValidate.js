$(document).ready(function() {

    $("#addContentForm").validate({
        rules: {
            title: {
                required: true,
                maxlength: 255
            },
            brief: {
                required: true,
                maxlength: 500
            },        
			contentV2: {
			    required: true,
			    minlength: 3,
			    maxlength: 500
			}
        },
        messages: {
            title: {
                required: "Vui lòng nhập title",
                maxlength: "Title không được vượt quá 255 ký tự"
            },
            brief: {
                required: "Vui lòng nhập brief",
                maxlength: "Brief không được vượt quá 500 ký tự"
            },
			contentV2: {
				required: "Vui lòng nhập content",
				minlength: "Content phải có ít nhất 3 ký tự",
				maxlength: "Content không được vượt quá 500 ký tự"
			}  
        },
        errorPlacement: function(error, element) {
            $(element).siblings(".error-message").html(error);
        },
        success: function(label, element) {
            $(element).siblings(".error-message").html("");
        }
    });
});
