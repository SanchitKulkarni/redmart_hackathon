define(['app','underscore','models/product'], function (app,_) {
    app.controller('EditedController', ["$scope", "$state",'$parse', "$q", "productModel", function ($scope, $state, $parse ,$q, productModel) {
        
        productModel.getNonEditedProducts().then(function(result){
               $scope.products = result

               var date = new Date()
               $scope.date = date.getMonth() + 1 + "/" + date.getDate() + "/" + date.getFullYear()
                 
        }); 

        $scope.doneProducts = []

        $scope.check = function(event, sel){  
          if(event.currentTarget.checked){
              var found = _.findWhere($scope.doneProducts, {productID: sel.product.productID});
              if(!found)
                $scope.doneProducts.push(sel.product);
          } else {
            $scope.doneProducts.splice(_.indexOf($scope.doneProducts, _.findWhere($scope.doneProducts, { productID : sel.product.productID})), 1);
          }
          var v= "";
        };

        $scope.saveNonEdited = function(){
          var data  =  _.map($scope.doneProducts, function(product){  
                               product.photoEditedDate = $scope.date
                               return _.omit(product, ['$$hashKey']);   
                       }); 

          var reqobj = {"data" : data, "status" : "edited"}
          productModel.saveEdited(reqobj).then(function(result){
            alert("done updates");
          })
        }


     }]);
}); 