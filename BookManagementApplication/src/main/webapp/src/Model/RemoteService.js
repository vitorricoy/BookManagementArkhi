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