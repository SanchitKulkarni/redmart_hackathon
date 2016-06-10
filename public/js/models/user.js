define(['app'], function (app) {
    app.factory('userModel', function (appService) {
    	var _user = "";
      var _competitor = "";
      var _store ="";

    	var setUser = function(user){
    		//appService.retrieve();
    		_user = user;
    	};

    	var getUser = function(){
    		return _user ;
    	};

      var setCompetitor = function(competitor){
        _competitor = competitor
      };

      var setStore = function(store){
        _store = store
      };

      var getCompetitor =  function(){
        return _competitor ;
      };

      var getStore = function(){
        return _store 
      };
       
       	return{
       		setUser: setUser,
       		getUser: getUser,
          getStore: getStore,
          getCompetitor:getCompetitor,
          setStore: setStore,
          setCompetitor:setCompetitor
       	}
    });
});