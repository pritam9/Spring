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
}]);

app.controller('newQuizController', ['$scope', '$http', '$filter', '$cookies', function ($scope, $http,$filter, $cookies) {
	$scope.createQuiz=function(){
		if($scope.myForm.$valid){
			var quizDetails = {
		    		quizName: $scope.quizName,
		    		quizInfo: $scope.summary,
		    		quizRules: $scope.rules,
		    		duration: $scope.duration
		    	};
			//alert($scope.lastname+" - "+userDetails.role);
			var getDetailsUrl = projectName+'/quizService/createNewQuiz';
			$http({
				method: 'POST',
				url: getDetailsUrl,
				data: quizDetails,
				headers: {'Authorization': 'jwt '+$cookies.get('jwt')}
			}).success(function (data, status, headers, config) {
				if (data.status === 1) {
					$scope.alertSuccess(data.message);
				} else {
					$scope.alertError(data.message);
				}
			}).error(function (data, status, headers, config) {
			});
			}else{
				$scope.alertError("All fields are mandatory!!");
			}
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
