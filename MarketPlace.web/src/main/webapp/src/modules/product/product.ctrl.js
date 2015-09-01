(function (ng) {
    var mod = ng.module('productModule');

    mod.controller('productCtrl', ['CrudCreator', '$scope', 'productService', 'productModel', 'cartItemService', '$location', 'authService', function (CrudCreator, $scope, svc, model, cartItemSvc, $location, authSvc) {
            CrudCreator.extendController(this, svc, $scope, model, 'product', 'Products');
            var self = this;
            this.searchByName = function (bookName) {
                var search;
                if (bookName) {
                    search = '?q=' + bookName;
                }
                $location.url('/catalog' + search);
            };
            
            this.findItem = function(record){
               svc.findItem(record.book.id).then(function(book){
                   $scope.records = [];
                   $scope.records.push(book);
               });
            };

            this.recordActions = [{
                    name: 'addToCart',
                    displayName: 'Add to Cart',
                    icon: 'shopping-cart',
                    class: 'primary',
                    fn: function (record) {
                        if (authSvc.getCurrentUser()) {
                            return cartItemSvc.addItem({
                                product: record,
                                name: record.book.name,
                                quantity: 1});
                        } else {
                            $location.path('/login');// o colocar servicio de LocalStorage
                        }
                    },
                    show: function () {
                        return true;
                    }
                },{
                    name: 'findCheaper',
                    displayName: 'Find cheapest',
                    icon: 'search',
                    class: 'warning',
                    fn: function (record) {
                            return self.findItem(record);
                    },
                    show: function () {
                        return true;
                    }
                }];

//            this.loadRefOptions();
            this.fetchRecords();
        }]);
})(window.angular);
