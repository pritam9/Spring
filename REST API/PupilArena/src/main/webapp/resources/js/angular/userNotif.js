var app = angular.module('pupilArenaApplication', ['ngMaterial', 'ngCookies']);
//var projectName="/controller";
var projectName="/PupilArena";
app.controller('sidebarController', ['$scope', '$http', '$cookies', function ($scope, $http, $cookies) {

	$scope.showMessage = false;
	$scope.isLeader=false;
	$scope.isMember=false;
	$scope.loadDetails = function () {
		//alert("load details");
		var getDetailsUrl = projectName+'/userService/getUserDetails';
		var jwt=$cookies.get('jwt');
		$http({
			method: 'GET',
			url: getDetailsUrl,
			headers: {'Authorization': 'jwt '+jwt}
		}).success(function (data, status, headers, config) {
			if (data.status === 1) {
				
				$scope.fullName=data.data.firstname+" "+data.data.middlename+" "+data.data.lastname;
				if(data.data.role==="Leader"){
					$scope.isLeader=true;
				}else{
					$scope.isMember=true;
				}				
			} else {
				
				$scope.message=data.message;
				$scope.showMessage = true;
				window.location.href = projectName+"/";
			}
		}).error(function (data, status, headers, config) {
			
		});
		
	};
	
	
	$scope.goToHome = function(){
		var jwt1=String($cookies.get('jwt'));
		var myUrl = projectName+"/home?token="+jwt1;
		//alert(jwt1+" is ");
		window.location.href=myUrl;
	};
	
	
	$scope.logout=function(){
		$cookies.remove('jwt');
		window.location.href = projectName+"/";
	};
}]);

app.controller('notificationController', ['$scope', '$http', '$cookies', function ($scope, $http, $cookies) {
	
	$scope.loadMyNotifications = function () {
		var getDetailsUrl = projectName+'/userService/getMyNotifications';
		var jwt=$cookies.get('jwt');
		$http({
			method: 'GET',
			url: getDetailsUrl,
			headers: {'Authorization': 'jwt '+jwt}
		}).success(function (data, status, headers, config) {
			if (data.status === 1 || data.status === 0) {
				$scope.notifications = data.data;
			} else {
				$scope.alertError("Something went wrong!! Try agin later! <a href='/controller/'>Click here to Login again!</a>");
				window.location.href = projectName+"/";
			}
		}).error(function (data, status, headers, config) {
			$scope.alertError("Something went wrong!! Try agin later! <a href='/'>Click here to Login again!</a>");
		});
	};
	
	$scope.respondToRequest=function(inviteId,groupId,status){
		var respondToUrl = projectName+'/userService/respond';
		var jwt=$cookies.get('jwt');
		//alert(inviteId+" "+groupId+" "+status);
		$http({
			method: 'POST',
			url: respondToUrl,
			data: "inviteId="+inviteId+"&groupId="+groupId+"&status="+status,
			headers: {'Authorization': 'jwt '+jwt,'Content-Type': 'application/x-www-form-urlencoded'}
		}).success(function (data, status, headers, config){
			if(data.status===1){
				$scope.alertSuccess(data.message);
				$scope.loadMyNotifications();
			}
		}).error(function (data, status, headers, config){
			$scope.alertError("Something went wrong!!");
		});
	};
	
	$scope.respondToApprovalRequest = function(inviteId,groupId,sender,status){
		var respondToUrl = projectName+'/userService/respondLead';
		var jwt=$cookies.get('jwt');
		//alert(inviteId+" "+groupId+" "+status);
		$http({
			method: 'POST',
			url: respondToUrl,
			data: "inviteId="+inviteId+"&groupId="+groupId+"&senderEmail="+sender+"&status="+status,
			headers: {'Authorization': 'jwt '+jwt,'Content-Type': 'application/x-www-form-urlencoded'}
		}).success(function (data, status, headers, config){
			if(data.status===1){
				$scope.alertSuccess(data.message);
				$scope.loadMyNotifications();
			}
		}).error(function (data, status, headers, config){
			$scope.alertError("Something went wrong!!");
		});
	};
	
	
	$scope.alertSuccess = function(message){
			$.notify({
	        	icon: "pe-7s-bell",
	        	message: "<b>"+message+"</b>"

	        },{
	            type: 'success',
	            timer: 4000,
	            placement: {
	                from: 'top',
	                align: 'center'
	            }
	        });
		};
		
		$scope.alertError = function(message){
			$.notify({
	        	icon: "pe-7s-bell",
	        	message: "<b>"+message+"</b>"

	        },{
	            type: 'danger',
	            timer: 4000,
	            placement: {
	                from: 'top',
	                align: 'center'
	            }
	        });
		};
}]);