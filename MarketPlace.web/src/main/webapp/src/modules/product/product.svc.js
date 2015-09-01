(function(ng){
    var mod = ng.module('productModule');
    
    mod.service('productService', ['CrudCreator','productContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
            this.findItem = function(idBook){
                return this.api.one('cheapest', idBook).get();
            };
    }]);
})(window.angular);
