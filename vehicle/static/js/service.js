app.factory('Park', function($resource) {
  return $resource('/saveVehicledetails/'); // Note the full endpoint address
});
app.factory('exit', function($resource) {
	  return $resource('/getCapacitydetail/'); // Note the full endpoint address
	});
app.factory('cost', function($resource) {
	  return $resource('/getVehicleDeatils/:vehicleId'); // Note the full endpoint address
	});

