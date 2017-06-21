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
		//alert(jwt1+" is ");
		window.location.href=myUrl;
	};
	
	$scope.logout=function(){
		$cookies.remove('jwt');
		window.location.href = projectName+"/";
	};
}]);

app.controller('joinTeamController', ['$scope', '$http', '$filter','$cookies', function ($scope, $http,$filter, $cookies) {
	$scope.pageSize=10;
	$scope.currentPage = 0;
	$scope.teams=[];
	$scope.searchFor='';
	$scope.loadTeamDetails = function () {
		var getDetailsUrl = projectName+'/userService/getTeamDetails';
		var jwt=$cookies.get('jwt');
		$http({
			method: 'GET',
			url: getDetailsUrl,
			headers: {'Authorization': 'jwt '+jwt}
		}).success(function (data, status, headers, config) {
			if (data.status === 1) {				
				$scope.teams=data.data;
			} else {
				$scope.alertError("Something went wrong!! Try agin later! <a href='/'>Click here to Login again!</a>");
				window.location.href = projectName+"/";
			}
		}).error(function (data, status, headers, config) {
			$scope.alertError("Something went wrong!! Try agin later! <a href='/'>Click here to Login again!</a>");
		});
	};
	
	$scope.join = function(group_id,groupLeaderEmail){
		var getDetailsUrl = projectName+'/userService/joinTeam';
		var jwt=$cookies.get('jwt');
		$http({
			method: 'POST',
			url: getDetailsUrl,
			data:"groupId="+group_id+"&leaderEmail="+groupLeaderEmail,
			headers: {'Authorization': 'jwt '+jwt,'Content-Type': 'application/x-www-form-urlencoded'}
		}).success(function (data, status, headers, config) {
			if (data.status === 1) {
				$scope.alertSuccess(data.message);
				$scope.loadTeamDetails();
				
				
			} else {
				$scope.alertError(data.message);
				//window.location.href = projectName+"/";
			}
		}).error(function (data, status, headers, config) {
			$scope.alertError("Something went wrong!! Try agin later! <a href='/'>Click here to Login again!</a>");
		});
	};
	
	//Pagination
	$scope.getData = function () {
		return $filter('filter')($scope.teams, $scope.searchFor);
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
app.filter('startFrom', function() {
	return function(input, start) {
        start = +start; //parse to int
        return input.slice(start);
    }
});