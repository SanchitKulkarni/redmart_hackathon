require.config({
  // alias libraries paths
    paths: {
        jquery: 'libs/jQuery-2.1.3.min',
         //appFunction: 'common/app-function',
        angular: 'libs/angular.min', 
        'angular-router': 'libs/angular-ui-router',
        'angularAMD': 'libs/angularAMD',
        underscore: "libs/underscore-min", 
        angularcsv: "libs/angular-csv-import"
    },

    // Add angular modules that does not support AMD out of the box, put it in a shim
    shim: {
        //'appFunction': ['jqueryUI'],
        'angularAMD': ['angular'],
        'angular-router': ['angular'],
        angularcsv :['angular'],
        underscore: {
          exports: "_"
        }
    },

    // kick start application
    deps: ['app']
});

require([ 'jquery',
    "controllers/taken-controller",
    "controllers/edited-controller",
    "services/service"
]);