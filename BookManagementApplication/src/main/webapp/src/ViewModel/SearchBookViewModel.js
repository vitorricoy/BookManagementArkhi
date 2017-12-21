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