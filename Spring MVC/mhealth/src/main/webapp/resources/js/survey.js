/**
 * 
 */
function submitSurvey(){
	console.log("Token: "+token);
	getSurvey();
	return false;
}
function getSurvey(){
	var request = {};
	request.token = token;
	request.survey = survey; 
	//$.ajax(
	//		{
	//			url:"apps/getSurvey",
	//			type: "POST",
	//			data: JSON.stringify( request ),
	//			success: onSurveyData,
	//			dataType: "json",
	//			contentType: "application/json"
	//		} );
//	$.ajax(
//			{
//				url:"apps/apis/coach/list",
//				type: "POST",
//				data: "token=0B7BE14F-6BC9-4940-98E7-4FCC1F9E4BC8|kkshemka|1460092548093",
//				success: function(data){
//					console.log("@@list ");
//					console.log(data); },
//				dataType: "json",
//				contentType: "application/x-www-form-urlencoded"
//			} );
	//$.ajax(
	//		{
	//			url:"apps/apis/coach/new",
	//			type: "POST",
	//			data: "token="+token,
	//			success: function(data){
	//				console.log("@@new ");
	//				console.log(data); },
	//			dataType: "json",
	//			contentType: "application/x-www-form-urlencoded"
	//		} );

//	$.ajax(
//			{
//				url:"apps/apis/bac/store",
//				type: "POST",
//				data: "token="+token+"&drinks=5&bac=0.12&beer=3&wine=2&shots=0&liquor=0&date=04/29/2016",
//				success: function(data){console.log(data); },
//				dataType: "json",
//				contentType: "application/x-www-form-urlencoded"
//			} );
//	$.ajax(
//			{
//				url:"apps/apis/coach/answer/store",
//				type: "POST",
//				data: "token="+token+"&messageId=561&answer=4",
//				success: function(data){console.log(data); },
//				dataType: "json",
//				contentType: "application/x-www-form-urlencoded"
//			} );
	//$.ajax(
	//		{
	//			url:"apps/apis/coach/message/open",
	//			type: "POST",
	//			data: "token="+token+"&messageId=494",
	//			success: function(data){console.log(data); },
	//			dataType: "json",
	//			contentType: "application/x-www-form-urlencoded"
	//		} );
	//$.ajax(
	//		{
	//			url:"apps/apis/trivia/scoreboard",
	//			type: "POST",
	//			data: "token="+token,
	//			success: function(data){console.log(data); },
	//			dataType: "json",
	//			contentType: "application/x-www-form-urlencoded"
	//		} );
	$.ajax(
			{
				url:"apps/apis/trivia/list",
				type: "POST",
				data: "token="+token+"&category="+1,
				success: function(data){console.log(data); },
				dataType: "json",
				contentType: "application/x-www-form-urlencoded"
			} );
	//$.ajax(
	//		{
	//			url:"apps/apis/prosCons/store",
	//			type: "POST",
	//			data: "token="+token+"&pros_cons=this_is_pros",
	//			success: function(data){console.log(data); },
	//			dataType: "json",
	//			contentType: "application/x-www-form-urlencoded"
	//		} );
	//$.ajax(
	//		{
	//			url:"apps/apis/getSurveyCsv",
	//			type: "POST",
	//			data: "token="+token+"&pros_cons=this_is_pros",
	//			success: function(data){console.log(data); },
	//			dataType: "json",
	//			contentType: "application/x-www-form-urlencoded"
	//		} );
	//$.ajax(
	//		{
	//			url:"apps/apis/auth/login_ver2",
	//			type: "POST",
	//			data: "username=kkshemka&password=1234&deviceToken=a01812c389808b0e14d3243a5d300767d6d80cd63884026d7c03d655c6487f27",
	//			success: function(data){console.log(data); },
	//			dataType: "json",
	//			contentType: "application/x-www-form-urlencoded"
	//		} );
//	$.ajax(
//			{
//				url:"apps/apis/auth/logout_ver2",
//				type: "POST",
//				data: "deviceToken=a01812c389808b0e14d3243a5d300767d6d80cd63884026d7c03d655c6487f27&token=ACA4A094-E957-4595-9C7C-A721476B8C61|kkshemka|1460092618660",
//				success: function(data){console.log(data); },
//				dataType: "json",
//				contentType: "application/x-www-form-urlencoded"
//			} );
}
function postSurvey(data){
	var request = {};
	request.token = token;
	request.questions = data;
	request.survey = survey;
	console.log(request);
	$.ajax(
			{
				url:"apps/submitSurvey",
				type: "POST",
				data: JSON.stringify( request ),
				success: function(data){
					console.log(data);
					if(data.status == 0){
					 //window.location.href = "survey_complete";
					} else {
						$(".error-msg").html(data.message);
						$(".error-msg").removeClass("hide");
					}
				},
				dataType: "json",
				contentType: "application/json"
			} );
}
function onSurveyData(data){
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
	console.log(JSON.stringify(data));
	for(var i=0; i< data.data.length; i++){
		var question = data.data[i];
		switch(question.type){
			case TYPE_TEXT:
				var answer = $('#'+question.id).val();
				question.answer = answer;
				break;
			case TYPE_NUMBER:
				var answer = $('#'+question.id).val();
				question.answer = answer;
				break;
			case TYPE_CHECK:
				var answers = $('input[name='+question.id+']:checked');
				var ansArray = [];
				for(var j= 0; j< answers.length; j++){
					ansArray.push($(answers[j]).val());
				}
				question.answer = ansArray.toString();
				break;
			case TYPE_RADIO:
				var answer = $('input[name='+question.id+']:checked').val();
				question.answer = answer;
				break;
			case TYPE_SUB_TEXT:
				for(var j = 0; j < question.subquestions.length; j++){
					var answer = $('#sub'+question.subquestions[j].id).val();
					question.subquestions[j].answer = answer;
				}
				break;
			case TYPE_SUB_NUMBER:
				for(var j = 0; j < question.subquestions.length; j++){
					var answer = $('#sub'+question.subquestions[j].id).val();
					question.subquestions[j].answer = answer;
				}
				break;
			case TYPE_SUB_CHECK:
				for(var j = 0; j < question.subquestions.length; j++){
					var answers = $('input[name=sub'+question.subquestions[j].id+']:checked').val();
					var ansArray = [];
					for(var j= 0; j< answers.length; j++){
						ansArray.push($(answers[j]).val());
					}
					question.answer = ansArray.toString();
				}
				break;
			case TYPE_SUB_RADIO:
				for(var j = 0; j < question.subquestions.length; j++){
					var answer = $('input[name=sub'+question.subquestions[j].id+']:checked').val();
					question.subquestions[j].answer = answer;
				}
				break;
			case TYPE_SUB_OPTION_TEXT:
				for(var j = 0; j < question.subquestions.length; j++){
					var answers = [];
					for(var k =0; k < question.options.length; k ++){
						answers.push($('#sub'+question.subquestions[j].id+'opt'+question.options[k].id).val())
					}
					var answer = answers.toString();
					question.subquestions[j].answer = answer;
				}
				break;
			case TYPE_SUB_OPTION_NUMBER:
				for(var j = 0; j < question.subquestions.length; j++){
					var answers = [];
					for(var k =0; k < question.options.length; k ++){
						answers.push($('#sub'+question.subquestions[j].id+'opt'+question.options[k].id).val())
					}
					var answer = answers.toString();
					question.subquestions[j].answer = answer;
				}
				break;
		}
	}
	console.log(data.data);
	postSurvey(data.data);
}