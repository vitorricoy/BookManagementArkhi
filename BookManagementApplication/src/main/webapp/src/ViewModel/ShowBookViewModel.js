function ShowBookViewModel($scope) {
    $scope.currentBook=currentBook;
    let cents = Math.round((parseFloat(currentBook.price)%1)*100, 0);
    let reais = Math.floor(parseFloat(currentBook.price));
    $scope.price = extenso(reais) + " reais e " + extenso(cents) + " centavos";
    //First letter in capital
    $scope.price = $scope.price.substr(0,1).toUpperCase()+$scope.price.substr(1);
}