app.controller('usersController', function($scope) {
	$scope.token = "empty";
});

app.controller('rolesController', function($scope) {
	$scope.headingTitle = "Roles List";
});
app.controller('tokenCtrl', function($scope) {
});
app.controller('exitController', function($scope) {
});

app.controller('myController', function($rootScope, $scope, $filter, $window,
		$location, Park, exit) {

	$scope.inTime = new Date();
	$scope.CheckCapacity = function() {
		var vData;
		exit.get({}, function(response) {
			vData = response;
			if ($scope.type == 'TWO') {
				console.log(vData);
				if (vData.two <= 0) {
					$scope.errorMsg='Dont have the capacity';
				}else{
					$scope.errorMsg='';
				}
			}
			if ($scope.type == 'FOUR') {
				if (vData.four <= 0) {
					$scope.errorMsg='Dont have the capacity';
				}else{
					$scope.errorMsg='';
				}
			}

		});


	}
	$scope.parkCall = function() {
		$scope.data = {};
		$scope.data.vehicleId = $scope.vehicleId;
		$scope.data.vehicleType = $scope.type;
		$scope.data.inTime = $scope.inTime;
		$scope.data.outTime = null;
		$scope.data.Token = {};
		if($scope.errorMsg == ''){
			Park.save($scope.data,
					function(response) {
				$rootScope.tokenJSON = response;
				$rootScope.tokenJSON.inTime = new Date(
						$rootScope.tokenJSON.inTime);
				$window.location.href = '#/success';

			});
		}

	}
	$scope.reset = function() {
		$scope.vehicleId = "";
		$scope.type = "";
	}

});

app.controller('vController', function($scope, $rootScope, $window, cost) {

	$scope.mesSucc = false;
	$scope.SearchCall = function() {

		console.log("vhivleid" + $scope.vehicleId + "KKK" + $scope.Intime
				+ "sd" + "");

		cost.get({
			vehicleId : $scope.vehicleId
		},
		function(response) {
			$scope.mesSucc = true;
			$rootScope.exitJSON = response;
			$rootScope.exitJSON.inTime = new Date(
					$rootScope.exitJSON.inTime);
			$rootScope.exitJSON.outTime = new Date(
					$rootScope.exitJSON.outTime);
			$window.location.href = '#/exit';
		})

	}

});
app.controller('CapController', function($scope, exit) {

	console.log("cap called c");
	$scope.parkCall = function() {
		console.log("cap called cc");
		exit.get({}, function(response) {
			$scope.vData = response;
			console.log($scope.vData)

		});

	};

	$scope.parkCall();

});
