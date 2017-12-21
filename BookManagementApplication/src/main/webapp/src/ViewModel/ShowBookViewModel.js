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