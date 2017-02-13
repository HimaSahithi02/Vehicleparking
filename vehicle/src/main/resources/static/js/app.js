var app = angular.module('app', ['ngRoute','ngResource','angularjs-datetime-picker']);
app.config(function($routeProvider){
	$routeProvider.
	when('/',{
		templateUrl: 'views/vehicleParking.html',
		controller: 'myController'
	}).
	when('/vehicle',{
		templateUrl: 'views/vehicleId.html',
		controller: 'usersController'
	}).
	when('/capacity',{
		templateUrl: 'views/capacity.html',
		controller: 'usersController'
	}).
	when('/success',{
		templateUrl: 'views/tokenid.html',
		controller: 'usersController'
	}).
	when('/exit',{
		templateUrl: 'views/exit.html',
		controller: 'usersController'
	}).
	otherwise(
			{ redirectTo: '/'}
	);
});

