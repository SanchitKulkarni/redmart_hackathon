define(['app','underscore','models/product'], function (app,_) {
    app.controller('TakenController', ["$scope", "$state",'$parse', "$q", "productModel", function ($scope, $state, $parse ,$q, productModel) {
        $scope.toPrettyJSON = function (evt) {
          var objStr = JSON.stringify($scope.csv.result);
          var obj = null;
          try {
            obj = $parse(objStr)({});  
            obj = _.map(obj, function(product){  
               return _.omit(product, ['$$hashKey']);   
            }); 
            var reqobj = {"data" : obj, "status" : "taken"}
            productModel.uploadphototakencsv(reqobj).then(function(){
              $scope.uploadedproducts = $scope.csv.result 
            });
          } catch(e){
            alert('invalid csv file')
          }  
        };    

        $scope.csv = {
          content: null,
          header: true,
          headerVisible: false,
          separator: ',',
          separatorVisible: false,
          result: null,
          callback:  $scope.toPrettyJSON,
          encoding: 'ISO-8859-1',
          encodingVisible: false,
        };   
     }]);
}); 