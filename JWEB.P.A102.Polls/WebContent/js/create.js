$(() => {
	let answerCount = 0;
	let questionCount = 0;
    $(document).on("click", "#btn-addAnswer", function () {
		answerCount = $(this)
		            	.closest(".group-answer").find(".inputAnswer").length;
		let questionIndex = $(this).closest(".group-question").find(".labelQuestion").data("question");		
        $(this)
            .closest(".group-answer")
            .append(
                `<div
                    class="input-group mb-3"
                    style="width: 500px"
                >
                    <input
                        type="text"
                        class="form-control inputAnswer"
                        placeholder="Type your answer"
                        name="answer-${questionIndex}" 
                    />
                    <button
                        class="btn btn-primary"
                        type="button"
                        id="btn-addAnswer"
                    >
                        +
                    </button>
                    <div
                        id="validateAnswer"
                        class="invalid-feedback validateAnswerClass"
                    ></div>
                </div>`
            );
        $(this).remove();
    });

    $(document).on("click", "#add-new-question", function () {
		questionCount++;
        $(".add-question").append(
            ` <div class="group-question">
                <hr />
                <div class="mb-5 row">
                    <label
                        class="col-sm-3 col-form-label labelQuestion"
						data-question="${questionCount}"
                    ></label>
                    <div class="col-sm-9">
                        <input
                            type="text"
                            class="form-control inputQustion"
                            id=""
                            placeholder="Enter your question"
                            name="question"
                        />
                        <div
                            id="validateQuestion"
                            class="invalid-feedback validateClass"
                        ></div>
                    </div>
                </div>
                <div class="mb row">
                    <div class="col-3"></div>
                    <div class="col-9">
                        <div class="form-check mb-5">
                            <input
                                class="form-check-input"
                                type="checkbox"
                                value=""
                                id="flexCheckDefault"
								name="mandatory-${questionCount}"
                            />
                            <label
                                class="form-check-label"
                                for="flexCheckDefault"
                            >
                                Mandatory
                            </label>
                        </div>
                        <div class="form-check mb-5">
                            <input
                                class="form-check-input"
                                type="checkbox"
                                value=""
                                id="flexCheckChecked"
								name="multiple-${questionCount}"
                            />
                            <label
                                class="form-check-label"
                                for="flexCheckChecked"
                            >
                                You can select multiple options
                            </label>
                        </div>
                    </div>
                </div>
                <div class="mb-5 row">
                    <label
                        for="inputPassword"
                        class="col-sm-3 col-form-label text-end"
                        >Possile answers</label
                    >
                    <div class="col-sm-9 group-answer">
                        <div class="input-group mb-3" style="width: 500px">
                            <input
                                type="text"
                                class="form-control inputAnswer"
                                placeholder="Type your answer"
                                id=""
                                name="answer-${questionCount}"
                            />
                            <button
                                class="btn btn-primary"
                                type="button"
                                id="btn-addAnswer"
                            >
                                +
                            </button>
                            <div
                                id="validateAnswer"
                                class="invalid-feedback validateAnswerClass"
                            ></div>
                        </div>
                    </div>
                </div>
            </div>`
        );
    });

    $(document).on("submit", "#great-poll-form", function (event) {
        console.log("Form submitted");
        if (!isValidForm()) {
            event.preventDefault();
            console.log("Form validation failed");
        } else {
            console.log("Form validation passed");
            $(this).addClass("was-validated");
        }
    });

    function isValidForm() {
        var isValidAnswerVar = isValidAnswer();
        let isValidNamepollVar = isValidNamepoll();
        let isValidQuestionVar = isValidQuestion();
        return isValidAnswerVar && isValidNamepollVar && isValidQuestionVar;
    }

    function isValidNamepoll() {
        let input = $("#inputNamePoll");
        let feedback = $("#requiredNamepoll");
        let question = input.val().trim();
        if (question === "") {
            feedback.text("Please enter name poll!");
            input.addClass("is-invalid").removeClass("is-valid");
            return false;
        } else if (question.length < 3 || question.length > 255) {
            feedback.text(
                "Name poll must have length from 3 to 255 characters !"
            );
            input.addClass("is-invalid").removeClass("is-valid");
            return false;
        } else {
            input.removeClass("is-invalid").addClass("is-valid");
        }
        return true;
    }

    function isValidQuestion() {
        let isValid = true; // Cờ kiểm tra tất cả inputs

        let inputs = $(".inputQustion");
        inputs.each(function (index, element) {
            let $element = $(element);
            let feedback = $element.siblings(".validateClass");
            let question = $element.val();
            if (question === "") {
                feedback.text("Please enter question!");
                $element.addClass("is-invalid").removeClass("is-valid");
                isValid = false; // Đánh dấu không hợp lệ
            } else if (question.length < 3 || question.length > 255) {
                feedback.text(
                    "Answer must have length from 3 to 255 characters!"
                );
                $element.addClass("is-invalid").removeClass("is-valid");
                isValid = false;
            } else {
                feedback.text(""); // Xóa thông báo lỗi nếu hợp lệ
                $element.removeClass("is-invalid").addClass("is-valid");
            }
        });

        return isValid;
    }

    function isValidAnswer() {
        let isValid = true; // Cờ kiểm tra tất cả inputs

        let inputs = $(".inputAnswer");
        inputs.each(function (index, element) {
            let $element = $(element);
            let feedback = $element.siblings(".validateAnswerClass");
            let question = $element.val();
            console.log({ question });
            console.log({ feedback });

            if (question === "") {
                feedback.text("Please enter answer!");
                $element.addClass("is-invalid").removeClass("is-valid");
                isValid = false; // Đánh dấu không hợp lệ
            } else if (question.length < 3 || question.length > 255) {
                feedback.text(
                    "Answer must have length from 3 to 255 characters!"
                );
                $element.addClass("is-invalid").removeClass("is-valid");
                isValid = false;
            } else {
                feedback.text(""); // Xóa thông báo lỗi nếu hợp lệ
                $element.removeClass("is-invalid").addClass("is-valid");
            }
        });

        return isValid;
    }
});
