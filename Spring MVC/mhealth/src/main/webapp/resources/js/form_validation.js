/**
 * Created by kapilkshemkalyani on 1/27/16.
 */
function onSurveyData(data){
    $("div").removeClass("survey_error");
    $('.error-msg').addClass("hide");
    var TYPE_HEADING = -1;
    var TYPE_TEXT = 0;
    var TYPE_NUMBER = 1;
    var TYPE_CHECK = 2;
    var TYPE_RADIO = 3;
    var TYPE_SUB_TEXT = 4;
    var TYPE_SUB_NUMBER = 5;
    var TYPE_SUB_CHECK = 6;
    var TYPE_SUB_RADIO = 7;
    var TYPE_SUB_OPTION_TEXT = 8;
    var TYPE_SUB_OPTION_NUMBER = 9;
    var TYPE_TEXT_AREA = 10;
    console.log(data);
    var canSubmit = true;
    for(var i=0; i< data.data.length; i++){
        var answer = null;
        var ignore = false;
        var question = data.data[i];
        if(question.hasOwnProperty("ignore")) {
            ignore = question["ignore"];
        }
        switch(question.type){
            case TYPE_TEXT:
                //answer = $('#'+question.id).val();
                var el = $('#'+question.id);
                if(el.length > 0){
                    answer = el.val();
                } else {// this ensures that question is removed from survey and need not be validated
                    answer = "NA";
                }
                question.answer = answer;
                break;
            case TYPE_TEXT_AREA:
                //answer = $('#'+question.id).val();
                var el = $('#'+question.id);
                if(el.length > 0){
                    answer = el.val();
                } else {// this ensures that question is removed from survey and need not be validated
                    answer = "NA";
                }
                question.answer = answer;
                break;
            case TYPE_NUMBER:
                //answer = $('#'+question.id).val();
                var el = $('#'+question.id);
                if(el.length > 0){
                    answer = el.val();
                } else {// this ensures that question is removed from survey and need not be validated
                    answer = "NA";
                }
                question.answer = answer;
                break;
            case TYPE_CHECK:

                var el = $('input[name='+question.id+']');
                if(el.length > 0){
                    var ansArray = [];
                    answers = $('input[name='+question.id+']:checked');
                    for(var j= 0; j< answers.length; j++){
                        ansArray.push($(answers[j]).val());
                    }
                    answer = ansArray.toString();
                } else {// this ensures that question is removed from survey and need not be validated
                    answer = "NA";
                }
                question.answer = answer;
                break;
            case TYPE_RADIO:
                var el = $('input[name='+question.id+']');
                if(el.length > 0){
                    answer = $('input[name='+question.id+']:checked').val();;
                }else {// this ensures that question is removed from survey and need not be validated
                    answer = "NA";
                }
                question.answer = answer;
                break;
            case TYPE_SUB_TEXT:
                for(var j = 0; j < question.subquestions.length; j++){

                    //answer = $('#sub'+question.subquestions[j].id).val();
                    var el = $('#sub'+question.subquestions[j].id);
                    if(el.length > 0){
                        answer = el.val();
                    } else {
                        answer = "NA"
                    }
                    if(answer == null || answer.length < 1){
                        //unanswered subquestion
                        break;
                    }
                    question.subquestions[j].answer = answer;
                }
                break;
            case TYPE_SUB_NUMBER:
                for(var j = 0; j < question.subquestions.length; j++){

                    //answer = $('#sub'+question.subquestions[j].id).val();
                    var el = $('#sub'+question.subquestions[j].id);
                    if(el.length > 0){
                        answer = el.val();
                    } else {
                        answer = "NA"
                    }
                    if(answer == null || answer.length < 1){
                        //unanswered subquestion
                        break;
                    }
                    if(answer < 0){
                        //negative value
                        break;
                    }
                    question.subquestions[j].answer = answer;
                }
                break;
            case TYPE_SUB_CHECK:
                break;
            case TYPE_SUB_RADIO:
                for(var j = 0; j < question.subquestions.length; j++){
                    var el = $('input[name=sub'+question.subquestions[j].id+']');
                    if(el.length > 0){
                        answer = $('input[name=sub'+question.subquestions[j].id+']:checked').val();
                        question.subquestions[j].answer = answer;
                    } else {
                        answer = "NA";
                    }
                    if(answer == null || answer.length < 1){
                        //unanswered subquestion
                        break;
                    }
                }
                break;
            case TYPE_SUB_OPTION_TEXT:
                for(var j = 0; j < question.subquestions.length; j++){
                    var answers = [];
                    var canContinue = true;
                    for(var k =0; k < question.options.length; k ++){
                        //answers.push($('#sub'+question.subquestions[j].id+'opt'+question.options[k].id).val())
                        var el = $('#sub'+question.subquestions[j].id+'opt'+question.options[k].id);
                        var subAnswer = null;
                        if(el.length > 0){
                            subAnswer = el.val();
                            answers.push(subAnswer);
                        } else {
                            subAnswer = "NA";
                        }

                        if(subAnswer == null || subAnswer.length < 1){ //unanswered
                            answers = [];
                            canContinue = false;
                            break;
                        }
                    }
                    answer = answers.toString();
                    question.subquestions[j].answer = answer;
                    if(canContinue == false ){
                        break;
                    }
                }
                break;
            case TYPE_SUB_OPTION_NUMBER:
                for(var j = 0; j < question.subquestions.length; j++){
                    var canContinue = true;
                    var answers = [];
                    for(var k =0; k < question.options.length; k ++){
                        //answers.push($('#sub'+question.subquestions[j].id+'opt'+question.options[k].id).val())
                        var el = $('#sub'+question.subquestions[j].id+'opt'+question.options[k].id);
                        var subAnswer = null;
                        if(el.length > 0){
                            subAnswer = el.val();
                            answers.push(subAnswer);
                        } else {
                            subAnswer = "NA";
                        }

                        if(subAnswer == null || subAnswer.length < 1){ //unanswered
                            answers = [];
                            canContinue = false;
                            break;
                        }

                        if(subAnswer < 0){
                            //negative value
                            answers = [-1];
                            canContinue = false;
                            break;
                        }
                    }
                    answer = answers.toString();
                    question.subquestions[j].answer = answer;
                    if(canContinue == false ){
                        break;
                    }
                }
                break;
            default:
                answer = "NA";
        }
        if(ignore != true && (answer == null || answer.length  < 1)) {
            canSubmit = false;
            console.log("Answer Question : "+question.id);
            var element = $('#parent'+question.id);
            console.log(element);
            element.addClass("survey_error");
            $('.error-msg').removeClass("hide");
            $('.error-msg').text("Please enter all the fields");
            return;
        }

        if((question.type == TYPE_NUMBER || question.type == TYPE_SUB_NUMBER || question.type == TYPE_SUB_OPTION_NUMBER) && answer < 0) {
            canSubmit = false;
            console.log("Answer Question : "+question.id);
            var element = $('#parent'+question.id);
            console.log(element);
            element.addClass("survey_error");
            $('.error-msg').removeClass("hide");
            $('.error-msg').text("Please do not enter negative value");
            return;
        }
    }
    console.log(data.data);
    if(canSubmit) {
        postSurvey(data.data);
    }

}