(function(ng){
    var mod = ng.module('editorialModule');
    
    mod.service('editorialService', ['CrudCreator','editorialContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
})(window.angular);
