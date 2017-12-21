function AddAuthorViewModel($scope, $location, remoteService) {
    $scope.addAuthor = function(){
        remoteService.addAuthor($scope.newAuthorName, $scope.newBirthDate, $scope.newDeathDate).then(function(added){
            console.log(added);
        });
        $location.path('/');
    };
    
}

