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