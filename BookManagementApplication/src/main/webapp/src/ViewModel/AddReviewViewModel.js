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
