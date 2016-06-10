define(['angularAMD', 'angular-router','angularcsv'], function (angularAMD) {
	var myApp = angular.module('testApp', ["ui.router","ngCsvImport"]);
    var underscore = angular.module('underscore', []);

    underscore.factory('_', ['$window', function($window) {
      return $window._; // assumes underscore has already been loaded on the page
    }]);

    myApp.config(function($stateProvider, $urlRouterProvider, $locationProvider){

      // For any unmatched url, send to /home
      $urlRouterProvider.otherwise("/taken")
      
      $stateProvider 
        .state('taken', {
            url: "/taken",
            controller: "TakenController",
            templateUrl: "assets/js/templates/taken.html"
        })  
        .state('edited',{
            url: "/edited",
            controller: "EditedController",
            templateUrl: "assets/js/templates/edited.html"
        })
    });

    myApp.controller("TakenController", ["$scope", "$state", function($scope, $state){
      $scope.headerText = "HOME";
    }]);
    
    // Bootstrap Angular when DOM is ready
    return angularAMD.bootstrap(myApp);
});



