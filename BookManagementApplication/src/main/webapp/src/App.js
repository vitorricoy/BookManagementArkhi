var bookManagement = angular.module('BookManagement', ["ngRoute"]);

bookManagement.service('RemoteService', ['$http', RemoteService]);

bookManagement.controller('SearchBookViewModel', ['$scope', '$location', 'RemoteService', SearchBookViewModel]);
bookManagement.controller('AddAuthorViewModel', ['$scope', '$location', 'RemoteService', AddAuthorViewModel]);
bookManagement.controller('AddBookViewModel', ['$scope', '$location', 'RemoteService', AddBookViewModel]);
bookManagement.controller('AuthorListAllViewModel', ['$scope', 'RemoteService', AuthorListAllViewModel]);
bookManagement.controller('ShowBookViewModel', ['$scope', ShowBookViewModel]);


bookManagement.config(function($routeProvider){
   $routeProvider
   .when("/", {
       templateUrl: "./assets/templates/home.html"
   })
   .when("/showBook", {
       templateUrl: "./assets/templates/showBook.html"
   })
   .when("/addBook", {
       templateUrl: "./assets/templates/addBook.html"
   })
   .when("/addAuthor", {
       templateUrl: "./assets/templates/addAuthor.html"
   })
   .otherwise({redirecTo: '/'}); 
});