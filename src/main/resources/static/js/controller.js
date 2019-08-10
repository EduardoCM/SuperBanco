app.controller('listarClientesController',
		function($scope, $http, $location, $route){
	console.log("entro1");
	$http({
		method : 'GET',
		url : 'http://localhost:8085/api/v1/eduardocastillo/cliente',
	}).then(function(response) {
		$scope.clientes = response.data;
		
		console.log("entro3");
	});
	
	$scope.deleteCliente = function(clienteId) {
		$http({
			method : 'DELETE',
			url : 'http://localhost:8085/api/v1/eduardocastillo/cliente' + clienteId
		}).then(function(response) {
			$location.path("/list-clientes");
			$route.reload();
		});
	}
	
});
	

app.controller('clienteRegistroController', function($scope, $http, $location,
		$route) {
	
	$scope.submitClienteForm = function(){
		
		$http({
			method : 'POST',
			url : 'http://localhost:8085/api/v1/eduardocastillo/cliente',
			data : $scope.cliente,
		}).then(function(response) {
			$location.path("/list-clientes");
			$route.reload();
		}, function(errResponse) {		
			$scope.errorMessage = errResponse.data.errorMessage;
		});
		
		
	}
	
	
	
});
	
