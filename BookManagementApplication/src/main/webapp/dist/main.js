// FILE: src/App.js
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

// FILE: src/Model/RemoteService.js
function RemoteService($http) {
    
    var BACKEND_URL = '../backend/index.php';
    
    this.bookSearchISBN = function(isbn) {
        return $http.post('BookSearchISBN', JSON.stringify(isbn)).then(function(response) {
            if(response.data.status==="OK"){
                return response.data.content;
            }
        });
    };
    
    this.authorListAll = function(){
        return $http.post('AuthorListAll').then(function(response) {
            if(response.data.status==="OK"){
                return response.data.content;
            }
        });
    };
    
    this.addAuthor = function(name, birth, death){
        let data = {
            "authorName": name,
            "birthDate": birth
        };
        if(Boolean(death)){
            data.death = death;
        }
        return $http.post('AuthorInsert', JSON.stringify(data)).then(function(response) {
            if(response.data.status==="OK"){
                return response.data.content;
            }
        });
    };
    
    this.addReview = function(name, rating, txt){
        let data = {
            "authorName": name,
            "rating": rating,
            "reviewTxt": txt
        };
        return $http.post('ReviewInsert', JSON.stringify(data)).then(function(response) {
            if(response.data.status==="OK"){
                return response.data.content;
            }
        });
    };
    
    this.addBook = function(isbn, title, authors, publisher, release, price, reviews){
        let data = {
            "isbn": isbn,
            "Title": title,
            "authors": authors,
            "publisher": publisher,
            "releaseDate": release,
            "price": price,
            "reviews": reviews
        };
        return $http.post('BookInsert', JSON.stringify(data)).then(function(response) {
            if(response.data.status==="OK"){
                return response.data.content;
            }
        });
    };
    
    this.authorGetById = function(id){
        return $http.post('AuthorSearch', JSON.stringify(id)).then(function(response) {
            if(response.data.status==="OK"){
                return response.data.content;
            }
        });
    };
}

// FILE: src/ViewModel/AddAuthorViewModel.js
function AddAuthorViewModel($scope, $location, remoteService) {
    $scope.addAuthor = function(){
        remoteService.addAuthor($scope.newAuthorName, $scope.newBirthDate, $scope.newDeathDate);
        $location.path('/');
    };
    
}



// FILE: src/ViewModel/AddBookViewModel.js
function AddBookViewModel($scope, $location, remoteService) {
    remoteService.authorListAll().then(function(authors){
        $scope.authors = authors;
    });
    
    $scope.addBook=function(){
        console.log($scope.newAuthors);
        remoteService.addReview($scope.newReviewAuthorName, $scope.newReviewRating, $scope.newReviewTxt).then(function(r){
            let reviews = [r];
            let authors = [];
            var promises = [];
            $scope.newAuthors.forEach(function(author){
                promises.push(remoteService.authorGetById(author));
            });
            Promise.all(promises).then(function(values){
                authors=values;
                remoteService.addBook($scope.newIsbn, $scope.newTitle, authors, $scope.newPublisher, $scope.newReleaseDate, $scope.newPrice, reviews).then(function(book){
                    console.log(book);
                    $location.path('/');
                });
            });
        });
    };
    
}

// FILE: src/ViewModel/AuthorListAllViewModel.js
function AuthorListAllViewModel($scope, remoteService) {
    
}

// FILE: src/ViewModel/SearchBookViewModel.js
var currentBook={};

function SearchBookViewModel($scope, $location, remoteService) {
    $scope.searchBook=function(){
        remoteService.bookSearchISBN($scope.searchIsbn).then(function(book){
            console.log(book);
            currentBook = book;
            $location.path('/showBook');
        });
    };
    
}

// FILE: src/ViewModel/ShowBookViewModel.js
function ShowBookViewModel($scope) {
    $scope.currentBook=currentBook;
    let cents = Math.round((parseFloat(currentBook.price)%1)*100, 0);
    let reais = Math.floor(parseFloat(currentBook.price));
    $scope.price = extenso(reais) + " reais e " + extenso(cents) + " centavos";
    //First letter in capital
    $scope.price = $scope.price.substr(0,1).toUpperCase()+$scope.price.substr(1);
}
