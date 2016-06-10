define(['app','underscore','models/product'], function (app,_) {
    app.controller('EditedController', ["$scope", "$state",'$parse', "$q", "productModel", function ($scope, $state, $parse ,$q, productModel) {
        
        productModel.getNonEditedProducts().then(function(result){
               $scope.products = result

               var date = new Date()
               $scope.date = date.getMonth() + 1 + "/" + date.getDate() + "/" + date.getFullYear()
                 
        }); 

        $scope.onradio = function(event, sel, notmatched){  
         if (notmatched) { 
             _.map($scope.matchedProductList, function (p){
                  if(p.objectId === sel.product.objectId) {
                     matchedProduct = _.find($scope.productList, function (product){
                         return product.objectId == sel.product.objectId ;
                     }); 
                     p.matchedRedmartProducts = matchedProduct.matchedRedmartProducts;
                     p.status =1;
                  }
            }); 
            return true;
         };

         var fpProduct = _.find($scope.matchedProductList, function (p){
             return p.objectId == sel.$parent.product.objectId  ;
         });

         fpProduct.matchedRedmartProducts =[]
         if(event.shiftKey){
           event.target.checked = false;
           return false;
         } 
         fpProduct = _.extend(fpProduct, {status : 0}); 
       	 fpProduct.matchedRedmartProducts.push(  sel.redmartProduct );
       };
     }]);
}); 