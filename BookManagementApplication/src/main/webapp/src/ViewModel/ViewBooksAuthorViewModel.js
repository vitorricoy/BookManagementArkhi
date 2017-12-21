function ViewBooksAuthorViewModel($scope, $location, remoteService) {
    $scope.books = currentBookList;
    $scope.author = currentAuthor;
    
    $scope.viewBook = function(book){
        currentBook=book;
        $location.path('/showBook');
    };
}