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
	$scope.goToNotifications = function(){
		$scope.alertSuccess("Work In Progress!! Coming Soon!!");
	};
	
	$scope.goToHome = function(){
		var jwt1=String($cookies.get('jwt'));
		var myUrl = projectName+"/home?token="+jwt1;
		//alert(jwt1+" is ");
		window.location.href=myUrl;
	};
	$scope.createQuiz = function(){
		var jwt1=String($cookies.get('jwt'));
		var myUrl = projectName+"/createQuiz?token="+jwt1;
		//alert(jwt1+" is ");
		window.location.href=myUrl;
	};
	$scope.logout=function(){
		$cookies.remove('jwt');
		window.location.href = projectName+"/";
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
}]);

app.controller('addQuestionsController', ['$scope', '$http', '$filter', '$cookies', function ($scope, $http,$filter, $cookies) {

	//variables required for pagination
	$scope.rPageSize=5;
	$scope.rCurrentPage = 0;
	$scope.qPageSize=5;
	$scope.qCurrentPage = 0;
	$scope.quizQuestions=[];
	$scope.remainingQuestions=[];
	
	$scope.loadQuestions = function () {
		var quizId = Number($cookies.get('quizId_admin'));
		var getDetailsUrl = projectName+'/quizService/getQuestions/'+quizId;
		var jwt=$cookies.get('jwt');
		$http({
			method: 'GET',
			url: getDetailsUrl,
			headers: {'Authorization': 'jwt '+jwt}
		}).success(function (data, status, headers, config) {
			if (data.status === 1) {
				$scope.quizQuestions=data.data.quizQuestions;
				$scope.remainingQuestions = data.data.remainingQuestions;
			} else {
				$scope.alertError("Something went wrong!! Try agin later!");
				window.location.href = projectName+"/error";
			}
		}).error(function (data, status, headers, config) {
			$scope.alertError("Something went wrong!! Try agin later!");
		});
	};
	
	$scope.addQuestion=function(questionId){
		var quizId = Number($cookies.get('quizId_admin'));
		var getDetailsUrl = projectName+'/quizService/addQuestion/'+quizId+'/'+questionId;
		var jwt=$cookies.get('jwt');
		$http({
			method: 'POST',
			url: getDetailsUrl,
			headers: {'Authorization': 'jwt '+jwt}
		}).success(function (data, status, headers, config) {
			if (data.status === 1) {
				$scope.loadQuestions();
			} else {
				$scope.alertError("Something went wrong!! Try agin later!");
				//window.location.href = projectName+"/error";
			}
		}).error(function (data, status, headers, config) {
			$scope.alertError("Something went wrong!! Try agin later!");
		});
	};
	$scope.removeQuestion=function(questionId){
		var quizId = Number($cookies.get('quizId_admin'));
		var getDetailsUrl = projectName+'/quizService/removeQuestion/'+quizId+'/'+questionId;
		var jwt=$cookies.get('jwt');
		$http({
			method: 'POST',
			url: getDetailsUrl,
			headers: {'Authorization': 'jwt '+jwt}
		}).success(function (data, status, headers, config) {
			if (data.status === 1) {
				$scope.loadQuestions();
			} else {
				$scope.alertError("Something went wrong!! Try agin later!");
				//window.location.href = projectName+"/error";
			}
		}).error(function (data, status, headers, config) {
			$scope.alertError("Something went wrong!! Try agin later!");
		});
	};
	
	//Pagination
	$scope.rGetData = function () {
		return $filter('filter')($scope.remainingQuestions, '');
	}
        	 
	$scope.numberOfPages = function () {
		return Math.ceil($scope.rGetData().length/$scope.rPageSize);                
	}
	//Pagination for quiz
	$scope.qGetData = function () {
		return $filter('filter')($scope.quizQuestions, '');
	}
        	 
	$scope.qNumberOfPages = function () {
		return Math.ceil($scope.qGetData().length/$scope.qPageSize);                
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

app.filter('startFrom', function() {
	return function(input, start) {
        start = +start; //parse to int
        return input.slice(start);
    }
});