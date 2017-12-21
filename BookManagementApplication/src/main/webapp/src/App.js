var bookManagement = angular.module('BookManagement', ["ngRoute"]);

bookManagement.service('RemoteService', ['$http', RemoteService]);

bookManagement.controller('SearchBookViewModel', ['$scope', '$location', 'RemoteService', SearchBookViewModel]);
bookManagement.controller('AddAuthorViewModel', ['$scope', '$location', 'RemoteService', AddAuthorViewModel]);
bookManagement.controller('AddBookViewModel', ['$scope', '$location', 'RemoteService', AddBookViewModel]);
bookManagement.controller('AuthorListAllViewModel', ['$scope','$location', 'RemoteService', AuthorListAllViewModel]);
bookManagement.controller('ShowBookViewModel', ['$scope', '$location', 'RemoteService', ShowBookViewModel]);
bookManagement.controller('EditBookViewModel', ['$scope', '$location', 'RemoteService', EditBookViewModel]);
bookManagement.controller('AddReviewViewModel', ['$scope', '$location', 'RemoteService', AddReviewViewModel]);
bookManagement.controller('ViewBooksAuthorViewModel', ['$scope', '$location', 'RemoteService', ViewBooksAuthorViewModel]);


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
   .when("/showAuthors", {
       templateUrl: "./assets/templates/showAuthors.html"
   })
   .when('/editBook',{
       templateUrl: "./assets/templates/editBook.html"
   })  
   .when('/addReview',{
       templateUrl: "./assets/templates/addReview.html"
   })
   .when('/booksByAuthor',{
       templateUrl: "./assets/templates/viewBooksAuthor.html"
   })
   .otherwise({redirecTo: '/'}); 
});