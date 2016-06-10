define(['app'], function (app) {
    app.factory('productModel', function (appService) { 

      var uploadphototakencsv = function(takendata){
        return appService.retrieve("products" , "POST", takendata ).then(function(result){ 
          return result;
        }, function(err){
          return err;
        });
      };
       
      var getNonEditedProducts = function(){ 
        var url = 'products?edited=false' 

        return appService.retrieve(url, "GET").then(function(result){  
          return result;
        }, function(err){
          return err;
        });
      };

      var saveEdited = function(matchedproducts, competitor) {
        return appService.retrieve("matches/" + competitor, "POST", matchedproducts ).then(function(result){ 
          return result;
        }, function(err){
          return err;
        });
      };

     	return{
     		uploadphototakencsv: uploadphototakencsv,
     		getNonEditedProducts: getNonEditedProducts,
        saveEdited: saveEdited
     	}
    });
});