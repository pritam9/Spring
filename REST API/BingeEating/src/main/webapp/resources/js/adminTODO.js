/**
 * 
 */
var t;
function getAllData(){
//alert("Onload");
	
/*t=$('#myAppointment').DataTable( {
	"ajax": {
	    "url": "binge/supporter/myAppointments",
	    "type": "GET"
	  },
    "columns": [
{ "data": "f_name" },
{ "data": "l_name" },
{ "data": "step" },
{ "data": "s_date" },
{ "data": "p_id","render": function (data, type, full, meta) { return '<a href="viewSurvey?id='+data+'" >View Report</a>'; }}
    ]
} );
*/
//alert("Function Get All Data Called");
t=$('#myUsers').DataTable( {
	"ajax": {
	    "url": "binge/supporter/myUsers",
	    "type": "GET"
	  },
    "columns": [
{ "data": "f_name" },
{ "data": "l_name" },
{ "data": "step" },
{ "data": "s_date" },
{ "data": "p_id","render": function (data, type, full, meta) { return '<a href="viewDetails?id='+data+'" >View Details</a>'; }}
    ]
} );
}

// Function to register User
function registerPatient()
{
	var fNmae = $("#first_name").val();
	var lName = $("#last_name").val();
	var username = $("#username").val();
	var password = $("#password").val();
	//alert(fNmae+lName+email);
	$.ajax(
			{
				url:"binge/supporter/registerPatient",
				type: "POST",
				data: "first_name="+fNmae+"&last_name="+lName+"&username="+username+"&password="+password,
				success: onRegistration,
				error: function(e){
					alert("Error"+e.message);
				},
				dataType: "json",
				contentType: "application/x-www-form-urlencoded"
			} );
	return false;
}

function onRegistration(response)
{
	var obj = response.data;
	//alert('Welcome '+obj.fName+'. Your Username is - '+obj.email+' and password is - '+obj.password);
	
	t.row.add({
        "f_name":       obj.f_name,
        "l_name":   obj.l_name,
        "step":     obj.step,
        "s_date": obj.s_date,
        "p_id": obj.p_id,
        
    } ).draw();
	Alert("User added successfully!");
}

function logout()
{
	$.ajax(
			{
				url:"logout",
				type: "GET",
				data: "task="+task,
				success: onLogout,
				error: function(e){
					alert(e.responseStatus);
				},
				dataType: "json",
				contentType: "application/x-www-form-urlencoded"
			} );
		return false;
}

function onLogout(data)
{
	if(data.status!=0)
		{
		$(".error-msg").html(data.message);
		$(".error-msg").removeClass("hide");
		}
	else
		{
		window.location.href = "";
		}
}

function deleteTask(form)
{
	var id1=form.taskId.value;
	//alert(id1);
	$.ajax(
			{
				url:"todo/delete",
				type: "POST",
				data: "id="+id1,
				success: onDelete,
				error: function(e){
					alert(e.responseStatus);
				},
				dataType: "json",
				contentType: "application/x-www-form-urlencoded"
			} );
	return false;
}

function onDelete(data)
{
	//$(this).closest('tr').remove();
	var obj=data.data;
	//alert(obj);
	//document.getElementById("taskList").deleteRow(obj.taskId);
	$('#'+obj).remove();
	$(".error-msg").html("Task Deleted Successfully. Deleted task id is - "+obj);
	$(".error-msg").removeClass("hide");
}


