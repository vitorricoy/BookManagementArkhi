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