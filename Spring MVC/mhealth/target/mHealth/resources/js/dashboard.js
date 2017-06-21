/**
 * 
 */
function downloadUserSurveys(){
	window.location.href='downloadSurveyResults';
}
function getUserSurvey(){
    $.ajax(
        {
            url:"apps/apis/getNewSurveyCsv",
            type: "POST",
            success: function(data){
                console.log(data);
                formatData(data);
            },
            dataType: "json",
            contentType: "application/x-www-form-urlencoded"
        } );
}

function formatData(data){
    var metadata = [];
    var surveyCsv = [];
    var users = data.data;
    if(users){
        for(var i = 0; i < users.length; i++){
            var survey = users[i]["userSurveyList"];
            var userRow = {};
            var totalSurvey = 0;
            for(var j =0 ; j < survey.length; j++){
                var userSurvey = survey[j];
                if(userSurvey == null){
                    break;
                } else {
                    totalSurvey++;
                }
            }
            if(totalSurvey != 8){
                continue;
            }
            for(var j =0 ; j < survey.length; j++){

                var userSurvey = survey[j];
                if(userSurvey == null){
                    continue;
                }
                var user_id = userSurvey["id"];
                userRow["user_id"] = user_id;
                //if(user_id < 38 || user_id > 43){//if(user_id != 26){
                //    continue;
                //}
                var questions = JSON.parse(userSurvey["response"])
                for(var que_index = 0; que_index < questions.length; que_index++){
                    var metadataObject = {};
                    var subquestions = [];
                    var question = questions[que_index];
                    var question_id = question["id"];
                    for(var key in question){
                        switch(key){
                            case "id":
                                metadataObject["que_"+key] = question[key];
                                break;
                            case "text":
                                metadataObject["que_"+key] = question[key];
                                break;
                            case "answer":
                                userRow[question_id]= question[key];
                                break;
                            case "options":
                                if(!question[key])
                                {
                                    continue;
                                }
                                for(var opt_index = 0; opt_index < question[key].length; opt_index++){
                                    var option = question[key][opt_index];
                                    var option_id = option["id"];
                                    for(var option_key in option){
                                        switch(option_key){
                                            case "text":
                                                metadataObject["que_"+question_id+"_opt_"+option_id+"_"+option_key] = option[option_key];
                                                break;
                                            case "value":
                                                metadataObject["que_"+question_id+"_opt_"+option_id+"_"+option_key] = option[option_key];
                                                break;
                                        }
                                    }
                                }
                                break;
                            case "subquestions":
                                if(!question[key]){
                                    continue;
                                }
                                for(var sub_index = 0; sub_index < question[key].length; sub_index++){
                                    var subquestionObject = {};
                                    var subquestion = question[key][sub_index];
                                    var subquestion_id = subquestion["id"];
                                    for(var subquestion_key in subquestion){
                                        switch(subquestion_key){
                                            case "id":
                                                subquestionObject["que_"+subquestion_key] = question_id+"_"+subquestion[subquestion_key];
                                                break;
                                            case "text":
                                                subquestionObject["que_"+subquestion_key] = subquestion[subquestion_key];
                                                break;
                                            case "answer":
                                                userRow[question_id+"_"+subquestion_id]= subquestion[subquestion_key];
                                                break;
                                        }
                                    }
                                    subquestions.push(subquestionObject);
                                }
                                break;
                        }
                    }

                metadata.push(metadataObject);
                for(var subquestion_index = 0; subquestion_index < subquestions.length; subquestion_index++){
                    metadata.push(subquestions[subquestion_index]);
                }
              }

            }
            //if(user_id >= 38 && user_id <= 43){//if(user_id == 26){
                surveyCsv.push(userRow);
            //}
        }
        console.log("metadata");
        console.log(metadata);
        metadata = addAllOptionsToFirstItem(metadata);
        console.log(metadata);
        JSONToCSVConvertor(metadata, "Survey Metadata", true);

        console.log(surveyCsv);
        surveyCsv.push(surveyCsv[0]);
        JSONToCSVConvertor(surveyCsv, "Survey Result", true);
        //var json = $.parseJSON($("#json").val());
        //var csv = JSON2CSV(metadata);
        //window.open("data:text/csv;charset=utf-8," + escape(csv))
    } else {
        //TODO: Error
    }
}

function addAllOptionsToFirstItem(array){
    var firstItem = {que_id: "", que_text : ""};
    for(var i =1; i<= 38; i++){
        firstItem["option"+i+"_text"] = "";
        firstItem["option"+i+"_value"] = "";
    }
    array.unshift(firstItem);
    return array;
}

function JSONToCSVConvertor(JSONData, ReportTitle, ShowLabel) {
    //If JSONData is not an object then JSON.parse will parse the JSON string in an Object
    var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;

    var CSV = '';
    //Set Report title in first row or line

    CSV += ReportTitle + '\r\n\n';

    //This condition will generate the Label/Header
    if (ShowLabel) {
        var row = "";

        //This loop will extract the label from 1st index of on array
        for (var index in arrData[0]) {

            //Now convert each value to string and comma-seprated
            row += index + ',';
        }

        row = row.slice(0, -1);

        //append Label row with line break
        CSV += row + '\r\n';
    }

    //1st loop is to extract each row
    for (var i = 1; i < arrData.length; i++) {
        var row = "";

        //2nd loop will extract each column and convert it in string comma-seprated
        for (var index in arrData[i]) {
            row += '"' + arrData[i][index] + '",';
        }

        row.slice(0, row.length - 1);

        //add a line break after each row
        CSV += row + '\r\n';
    }

    if (CSV == '') {
        alert("Invalid data");
        return;
    }

    //Generate a file name
    var fileName = "MyReport_";
    //this will remove the blank-spaces from the title and replace it with an underscore
    fileName += ReportTitle.replace(/ /g,"_");

    //Initialize file format you want csv or xls
    var uri = 'data:text/csv;charset=utf-8,' + escape(CSV);

    // Now the little tricky part.
    // you can use either>> window.open(uri);
    // but this will not work in some browsers
    // or you will not get the correct file extension

    //this trick will generate a temp <a /> tag
    var link = document.createElement("a");
    link.href = uri;

    //set the visibility hidden so it will not effect on your web-layout
    link.style = "visibility:hidden";
    link.download = fileName + ".csv";

    //this part will append the anchor tag and remove it after automatic click
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
}

function JSON2CSV(objArray) {
    var array = typeof objArray != 'object' ? JSON.parse(objArray) : objArray;

    var str = '';
    var line = '';

    if ($("#labels").is(':checked')) {
        var head = array[0];
        if ($("#quote").is(':checked')) {
            for (var index in array[0]) {
                var value = index + "";
                line += '"' + value.replace(/"/g, '""') + '",';
            }
        } else {
            for (var index in array[0]) {
                line += index + ',';
            }
        }

        line = line.slice(0, -1);
        str += line + '\r\n';
    }

    for (var i = 0; i < array.length; i++) {
        var line = '';

        if ($("#quote").is(':checked')) {
            for (var index in array[i]) {
                var value = array[i][index] + "";
                line += '"' + value.replace(/"/g, '""') + '",';
            }
        } else {
            for (var index in array[i]) {
                line += array[i][index] + ',';
            }
        }

        line = line.slice(0, -1);
        str += line + '\r\n';
    }
    return str;

}