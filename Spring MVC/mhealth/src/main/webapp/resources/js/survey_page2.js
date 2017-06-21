/**
 * 
 */
function submitSurvey(){
	console.log("Token: "+token);
	onSurveyData(data);
	return false;
}
function getSurvey() {
	$.ajax(
			{
				url: contextPath+"/resources/js/baseline_survey_page2_data.json",
				type: "GET",
				success: onSurveyData,
				dataType: "json",
				contentType: "application/json"
			});
}
function createAnswerResponse(){

	var question = {answer: null, options: null, survey: "", text: "",type: null};
	question.id = 18;
	question.subquestions = [];

	var subquestion = {text: ""};
	subquestion.id = 11;

	subquestion.answer = $('input[name=sub11]:checked').val();

	var subquestion1 = {};
	subquestion1.id = 12;

	subquestion1.answer = $('input[name=sub12]:checked').val();

	question.subquestions.push(subquestion);
	question.subquestions.push(subquestion1);

	postSurvey([question]);

}

function postSurvey(data){
	var request = {};
	request.token = token;
	request.questions = data;
	request.survey = survey;
	console.log(request);
	$.ajax(
			{
				url:contextPath+"/apps/submitSurveyPage",
				type: "POST",
				data: JSON.stringify( request ),
				success: function(data){
					console.log(data);
					if(data.status == 0){
						if(survey.indexOf("baseline") > -1) {
							window.location.href = contextPath+"/survey_baseline/3";
						} else {
							window.location.href = contextPath+"/survey_sixweek/3";
						}
					} else {
						$(".error-msg").html(data.message);
						$(".error-msg").removeClass("hide");
					}
				},
				dataType: "json",
				contentType: "application/json"
			} );
}
//function onSurveyData(data){
//	var TYPE_HEADING = -1;
//	var TYPE_TEXT = 0;
//	var TYPE_NUMBER = 1;
//	var TYPE_CHECK = 2;
//	var TYPE_RADIO = 3;
//	var TYPE_SUB_TEXT = 4;
//	var TYPE_SUB_NUMBER = 5;
//	var TYPE_SUB_CHECK = 6;
//	var TYPE_SUB_RADIO = 7;
//	var TYPE_SUB_OPTION_TEXT = 8;
//	var TYPE_SUB_OPTION_NUMBER = 9;
//	console.log(data);
//
//	for(var i=0; i< data.data.length; i++){
//		var question = data.data[i];
//		switch(question.type){
//			case TYPE_TEXT:
//				var answer = $('#'+question.id).val();
//				question.answer = answer;
//				break;
//			case TYPE_NUMBER:
//				var answer = $('#'+question.id).val();
//				question.answer = answer;
//				break;
//			case TYPE_CHECK:
//				var answers = $('input[name='+question.id+']:checked');
//				var ansArray = [];
//				for(var j= 0; j< answers.length; j++){
//					ansArray.push($(answers[j]).val());
//				}
//				question.answer = ansArray.toString();
//				break;
//			case TYPE_RADIO:
//				var answer = $('input[name='+question.id+']:checked').val();
//				question.answer = answer;
//				break;
//			case TYPE_SUB_TEXT:
//				for(var j = 0; j < question.subquestions.length; j++){
//					var answer = $('#sub'+question.subquestions[j].id).val();
//					question.subquestions[j].answer = answer;
//				}
//				break;
//			case TYPE_SUB_NUMBER:
//				for(var j = 0; j < question.subquestions.length; j++){
//					var answer = $('#sub'+question.subquestions[j].id).val();
//					question.subquestions[j].answer = answer;
//				}
//				break;
//			case TYPE_SUB_CHECK:
//				for(var j = 0; j < question.subquestions.length; j++){
//					var answers = $('input[name=sub'+question.subquestions[j].id+']:checked').val();
//					var ansArray = [];
//					for(var j= 0; j< answers.length; j++){
//						ansArray.push($(answers[j]).val());
//					}
//					question.answer = ansArray.toString();
//				}
//				break;
//			case TYPE_SUB_RADIO:
//				for(var j = 0; j < question.subquestions.length; j++){
//					var answer = $('input[name=sub'+question.subquestions[j].id+']:checked').val();
//					question.subquestions[j].answer = answer;
//				}
//				break;
//			case TYPE_SUB_OPTION_TEXT:
//				for(var j = 0; j < question.subquestions.length; j++){
//					var answers = [];
//					for(var k =0; k < question.options.length; k ++){
//						answers.push($('#sub'+question.subquestions[j].id+'opt'+question.options[k].id).val())
//					}
//					var answer = answers.toString();
//					question.subquestions[j].answer = answer;
//				}
//				break;
//			case TYPE_SUB_OPTION_NUMBER:
//				for(var j = 0; j < question.subquestions.length; j++){
//					var answers = [];
//					for(var k =0; k < question.options.length; k ++){
//						answers.push($('#sub'+question.subquestions[j].id+'opt'+question.options[k].id).val())
//					}
//					var answer = answers.toString();
//					console.log("@@ answer"+answer);
//					question.subquestions[j].answer = answer;
//				}
//				break;
//		}
//	}
//	console.log(data.data);
//	postSurvey(data.data);
//}