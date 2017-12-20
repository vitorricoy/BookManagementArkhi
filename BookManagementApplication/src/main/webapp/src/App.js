var bookManagement = angular.module('BookManagement', ["ngRoute"]);

//bookManagement.service('RemoteService', ['$http', RemoteService]);

//bookManagement.controller('SearchBookViewModel', ['$scope', 'RemoteService', SearchBookViewModel]);

bookManagement.config(function($routeProvider){
   $routeProvider
   .when("/", {
       templateUrl: "./assets/templates/home.html",
       controller: 'SearchBookViewModel'
   })
   .when("/showBook", {
       templateUrl: "./assets/templates/showBook.html"
   })
   .otherwise({redirecTo: '/'}); 
});