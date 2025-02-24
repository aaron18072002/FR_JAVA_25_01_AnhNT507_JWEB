$(document).ready(function() {
    // Thêm custom method để kiểm tra email phải có đuôi @fpt.com.vn
    $.validator.addMethod("fptEmail", function(value, element) {
        return this.optional(element) || /^[A-Za-z0-9._%+-]+@fpt\.com\.vn$/.test(value);
    }, "Email phải có định dạng tên@fpt.com.vn.");

    $("#editForm").validate({
        rules: {
            firstName: {
                required: true,
                maxlength: 50
            },
            lastName: {
                required: true,
                maxlength: 50
            },
            email: {
                required: true,
                email: true,
                fptEmail: true 
            },
            phone: {
                required: true,
                digits: true,
                minlength: 10,
                maxlength: 15
            },
            description: {
                required: true,
                minlength: 10
            }
        },
        messages: {
            firstName: {
                required: "Vui lòng nhập họ",
                maxlength: "Họ không được vượt quá 50 ký tự"
            },
            lastName: {
                required: "Vui lòng nhập tên",
                maxlength: "Tên không được vượt quá 50 ký tự"
            },
            email: {
                required: "Vui lòng nhập email",
                email: "Email không hợp lệ",
                fptEmail: "Email phải có định dạng tên@fpt.com.vn"
            },
            phone: {
                required: "Vui lòng nhập số điện thoại",
                digits: "Chỉ được nhập số",
                minlength: "Số điện thoại phải có ít nhất 10 chữ số",
                maxlength: "Số điện thoại không được vượt quá 15 chữ số"
            },
            description: {
                required: "Vui lòng nhập mô tả",
                minlength: "Mô tả phải có ít nhất 10 ký tự"
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
