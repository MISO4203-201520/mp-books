(function (ng) {
    var mod = ng.module('cartItemModule');

    mod.controller('cartItemCtrl', ['CrudCreator', '$scope', 'cartItemService', 'cartItemModel','$location', function (CrudCreator, $scope, svc, model, $location) {
            CrudCreator.extendController(this, svc, $scope, model, 'cartItem', 'Shopping Cart');
            this.fetchRecords();
            this.readOnly = true;
            $scope.ctrlE = {status: false};
            $scope.goToGallery = function(){
              $location.path('/book');  
            };
        }]);

})(window.angular);
