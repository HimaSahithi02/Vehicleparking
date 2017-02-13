app.factory('Park', function($resource) {
  return $resource('/vehicle/saveVehicledetails/'); // Note the full endpoint address
});
app.factory('exit', function($resource) {
	  return $resource('/vehicle/getCapacitydetail/'); // Note the full endpoint address
	});
app.factory('cost', function($resource) {
	  return $resource('/vehicle/getVehicleDeatils/:vehicleId'); // Note the full endpoint address
	});

