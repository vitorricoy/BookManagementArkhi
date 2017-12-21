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