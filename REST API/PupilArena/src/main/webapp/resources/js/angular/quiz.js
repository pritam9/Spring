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
	$scope.goToNotifications = function(){
		var jwt1=String($cookies.get('jwt'));
		var myUrl = projectName+"/notif?token="+jwt1;
		window.location.href=myUrl;
	};
	$scope.logout=function(){
		$cookies.remove('jwt');
		window.location.href = projectName+"/";
	};
}]);

app.controller('quizController', ['$scope', '$http','$filter', '$cookies', function ($scope, $http,$filter, $cookies) {
	$scope.pageSize=10;
	$scope.currentPage = 0;
	$scope.isParticipated=true;
	$scope.groupId=0;
	$scope.loadQuizDetails = function () {
		var getDetailsUrl = projectName+'/userService/getQuizDetails';
		var jwt=$cookies.get('jwt');
		$http({
			method: 'GET',
			url: getDetailsUrl,
			headers: {'Authorization': 'jwt '+jwt}
		}).success(function (data, status, headers, config) {
			if (data.status === 1) {
				$scope.quizes=data.data.quizes;
				$scope.myGroups = data.data.myGroups;
			} else {
				$scope.alertError("Something went wrong!! Try agin later!");
				window.location.href = projectName+"/";
			}
		}).error(function (data, status, headers, config) {
			$scope.alertError("Something went wrong!! Try agin later!");
		});
	};
	
	$scope.checkIfParticipated = function(quizId){
		
		var getDetailsUrl = projectName+'/userService/checkIfPartcipated/'+quizId;
		var jwt=$cookies.get('jwt');
		$http({
			method: 'GET',
			url: getDetailsUrl,
			headers: {'Authorization': 'jwt '+jwt}
		}).success(function (data, status, headers, config) {
			if (data.status === 1) {
				$scope.alertError(data.message);
				$scope.isParticipated=true;
			} else {
				if($scope.myGroups==null)
					$scope.alertError("You need to be part of a group first to participate.")
				$scope.isParticipated=false;
				$scope.quizId = quizId;
			}
		}).error(function (data, status, headers, config) {
			$scope.alertError("Something went wrong!! Try agin later!");
		});
	};
		
	$scope.participate = function(quizId,groupId){
		
			var getDetailsUrl = projectName+'/quizService/quizRegistration';
			var jwt=$cookies.get('jwt');
			$http({
				method: 'POST',
				url: getDetailsUrl,
				data : "groupId="+groupId+"&quizId="+quizId,
				headers: {'Authorization': 'jwt '+jwt,'Content-Type': 'application/x-www-form-urlencoded'}
			}).success(function (data, status, headers, config) {
				if (data.status === 1) {
					$scope.alertSuccess(data.message);
					$scope.isParticipated=true;
				} else {
					$scope.alertError(data.message);
					//window.location.href = projectName+"/";
				}
			}).error(function (data, status, headers, config) {
				$scope.alertError("Something went wrong!! Try agin later!");
			});
	};
	
	$scope.startQuiz=function(quizId){
		var getDetailsUrl = projectName+'/userService/checkIfPartcipated/'+quizId;
		var jwt=$cookies.get('jwt');
		$http({
			method: 'GET',
			url: getDetailsUrl,
			headers: {'Authorization': 'jwt '+jwt}
		}).success(function (data, status, headers, config) {
			if (data.status === 1) {
				$cookies.put("quizId",quizId);
				$cookies.put("questionNum",0);
				window.location.href=projectName+"/ongoingQuiz";
			} else {
				$scope.alertError("You need to participate in the quiz first");
			}
		}).error(function (data, status, headers, config) {
			$scope.alertError("Something went wrong!! Try agin later!");
		});
	};
	
	
	//Pagination
	$scope.getData = function () {
		return $filter('filter')($scope.quizes, "");
	}
        	 
	$scope.numberOfPages = function () {
		return Math.ceil($scope.getData().length/$scope.pageSize);                
	}
	
	
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