
$(() => {
	let pollId;
    $(document).on("click", ".btn-delete", function () {
        pollId = $(this).closest("tr").find("td").first().text();
        $("#deleteModal").fadeIn();
    });

    $(".btn-yes").on("click", function () {
        if (pollId) {
			$.ajax({
                url: "delete-poll",
                type: "GET",
                data: { pollId: pollId },
                success: function(response) {
                    location.reload();
                },
                error: function(xhr, status, error) {
                    $("#responseMessage").text("Lỗi: " + error);
                }
            });
        }
        $("#deleteModal").fadeOut();
    });

    $(".btn-no").on("click", function () {
        $("#deleteModal").fadeOut();
    });
});
