var myapp = angular.module('myApp',['ui.router']);
myapp.config(function($stateProvider,$urlRoterProvider){
	$stateProvider
	.state('list',{
		url:'/list',
		templateUrl:'/tests/add.jsp',
		controller:'contactCtrl'})
	.state('list.add',{
		url:'/add',
		templateUrl:'/tests.add.jsp',
		controller:'contactCtrl'
	})
})