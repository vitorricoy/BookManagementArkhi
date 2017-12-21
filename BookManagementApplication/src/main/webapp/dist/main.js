// FILE: src/App.js
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

// FILE: src/Model/RemoteService.js
function RemoteService($http) {
    
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
            "birthDate": birth,
            "deathDate": undefined
        };
        if(death){
            data.deathDate = death;
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
    
    this.authorRemove = function(id){
        return $http.post('AuthorRemove', JSON.stringify(id)).then(function(response) {
            if(response.data.status==="OK"){
                return response.data.content;
            }
        });
    };
    
    this.bookRemove = function(isbn){
        return $http.post('BookRemove', JSON.stringify(isbn)).then(function(response) {
            if(response.data.status==="OK"){
                return response.data.content;
            }
        });
    };
    
    this.updateBook = function(book){
        let data = {
            "isbn": book.isbn,
            "book": book
        };
        return $http.post('BookUpdate', JSON.stringify(data)).then(function(response) {
            if(response.data.status==="OK"){
                return response.data.content;
            }
        });
    };
    
    this.getBooksByAuthor = function(author){
        return $http.post('BookSearchAuthor', JSON.stringify(author)).then(function(response) {
            if(response.data.status==="OK"){
                return response.data.content;
            }
        });
    };
}

// FILE: src/ViewModel/AddAuthorViewModel.js
function AddAuthorViewModel($scope, $location, remoteService) {
    $scope.addAuthor = function(){
        remoteService.addAuthor($scope.newAuthorName, $scope.newBirthDate, $scope.newDeathDate).then(function(added){
            console.log(added);
        });
        $location.path('/');
    };
    
}



// FILE: src/ViewModel/AddBookViewModel.js
function AddBookViewModel($scope, $location, remoteService) {
    remoteService.authorListAll().then(function(authors){
        $scope.authors = authors;
    });
    
    $scope.addBook=function(){
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

// FILE: src/ViewModel/AddReviewViewModel.js
function AddReviewViewModel($scope, $location, remoteService) {
    $scope.addReview = function(){
        remoteService.bookSearchISBN($scope.newIsbn).then(function(book){
           if(book){
               remoteService.addReview($scope.newReviewAuthorName, $scope.newReviewRating, $scope.newReviewTxt).then(function(r){
                  book.reviews.push(r);
                  remoteService.updateBook(book).then(function(){
                      currentBook=book;
                      $location.path('/showBook');
                  })
               });
           }else{
               alert("Isbn invalido");
           }
        });
    }
    
}


// FILE: src/ViewModel/AuthorListAllViewModel.js
var currentBookList = [];
var currentAuthor = {};

function AuthorListAllViewModel($scope, $location, remoteService) {
    remoteService.authorListAll().then(function(authors){
        $scope.authors = authors;
        $scope.birth = [];
        $scope.death = [];
        //To save formattable date
        $scope.authors.forEach(function(item){
            item.birthFormatted = new Date(item.birthDate);
            item.deathFormatted = new Date(item.deathDate);
        });
    });
    
    $scope.removeAuthor = function(id){
        remoteService.authorRemove(id).then(function(author){
            $("#author"+id).remove();
        });
    };
    
    $scope.viewBooks = function(id){
        remoteService.authorGetById(id).then(function(author){
            remoteService.getBooksByAuthor(author).then(function(books){
                currentBookList = books;
                currentAuthor = author;
                $location.path('/booksByAuthor');
            });
        });
    }
}

// FILE: src/ViewModel/EditBookViewModel.js
function EditBookViewModel($scope, $location, remoteService) {
    $scope.book = currentBook;
    
    remoteService.authorListAll().then(function(authors){
        $scope.authors = authors;    
    });
    
    $scope.editBook=function(){
        let authors = [];
        let promises = [];
        $scope.authorsUpdate.forEach(function(author){
            promises.push(remoteService.authorGetById(author));
        });
        Promise.all(promises).then(function(values){
            authors=values;
            $scope.book.authors = authors;
            remoteService.updateBook($scope.book).then(function(book){
                console.log(book);
                $location.path('/showBook');
            });
        });
    };
    
}

// FILE: src/ViewModel/SearchBookViewModel.js
var currentBook={};

function SearchBookViewModel($scope, $location, remoteService) {
    $scope.searchBook=function(){
        remoteService.bookSearchISBN($scope.searchIsbn).then(function(book){
            console.log(book);
            currentBook = book;
            if(book){
                $location.path('/showBook');
            }else{
                alert('Livro nao encontrado');
            }
        });
    };
    
}

// FILE: src/ViewModel/ShowBookViewModel.js
function ShowBookViewModel($scope, $location, remoteService) {
    $scope.currentBook=currentBook;
    let cents = Math.round((parseFloat(currentBook.price)%1)*100, 0);
    let reais = Math.floor(parseFloat(currentBook.price));
    $scope.price = extenso(String(reais)) + " reais e " + extenso(String(cents)) + " centavos";
    //First letter in capital
    $scope.price = $scope.price.substr(0,1).toUpperCase()+$scope.price.substr(1);
    //Fix accents
    $scope.price = accentString($scope.price);
    //To save formattable date
    $scope.currentBook.releaseDate = new Date($scope.currentBook.releaseDate);
    
    $scope.removeBook = function(isbn){
        remoteService.bookRemove(isbn).then(function(){
            $location.path('/');
        });
    };
    
    function accentString(price){
        price = price.replace('á', '\u00e1');
        price = price.replace('à', '\u00e0');
        price = price.replace('â', '\u00e2');
        price = price.replace('ã', '\u00e3');
        price = price.replace('ä', '\u00e4');
        price = price.replace('Á', '\u00c1');
        price = price.replace('À', '\u00c0');
        price = price.replace('Â', '\u00c2');
        price = price.replace('Ã', '\u00c3');
        price = price.replace('Ä', '\u00c4');
        price = price.replace('é', '\u00e9');
        price = price.replace('è', '\u00e8');
        price = price.replace('ê', '\u00ea');
        price = price.replace('ê', '\u00ea');
        price = price.replace('É', '\u00c9');
        price = price.replace('È', '\u00c8');
        price = price.replace('Ê', '\u00ca');
        price = price.replace('Ë', '\u00cb');
        price = price.replace('í', '\u00ed');
        price = price.replace('ì', '\u00ec');
        price = price.replace('î', '\u00ee');
        price = price.replace('ï', '\u00ef');
        price = price.replace('Í', '\u00cd');
        price = price.replace('Ì', '\u00cc');
        price = price.replace('Î', '\u00ce');
        price = price.replace('Ï', '\u00cf');
        price = price.replace('ó', '\u00f3');
        price = price.replace('ò', '\u00f2');
        price = price.replace('ô', '\u00f4');
        price = price.replace('õ', '\u00f5');
        price = price.replace('ö', '\u00f6');
        price = price.replace('Ó', '\u00d3');
        price = price.replace('Ò', '\u00d2');
        price = price.replace('Ô', '\u00d4');
        price = price.replace('Õ', '\u00d5');
        price = price.replace('Ö', '\u00d6');
        price = price.replace('ú', '\u00fa');
        price = price.replace('ù', '\u00f9');
        price = price.replace('û', '\u00fb');
        price = price.replace('ü', '\u00fc');
        price = price.replace('Ú', '\u00da');
        price = price.replace('Ù', '\u00d9');
        price = price.replace('Û', '\u00db');
        price = price.replace('ç', '\u00e7');
        price = price.replace('Ç', '\u00c7');
        price = price.replace('ñ', '\u00f1');
        price = price.replace('Ñ', '\u00d1');
        price = price.replace('&', '\u0026');
        price = price.replace('\'', '\u0027');

        return price;
    }
}

// FILE: src/ViewModel/ViewBooksAuthorViewModel.js
function ViewBooksAuthorViewModel($scope, $location, remoteService) {
    $scope.books = currentBookList;
    $scope.author = currentAuthor;
    
    $scope.viewBook = function(book){
        currentBook=book;
        $location.path('/showBook');
    };
}
