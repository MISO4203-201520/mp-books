(function (ng) {
    var mod = ng.module('productModule');

    mod.controller('productCtrl', ['CrudCreator', '$scope', 'productService', 'productModel', 'cartItemService', function (CrudCreator, $scope, svc, model, cartItemSvc) {
            CrudCreator.extendController(this, svc, $scope, model, 'product', 'Products');

            this.recordActions = [{
                    name: 'addToCart',
                    displayName: 'Add to Cart',
                    icon: 'shopping-cart',
                    fn: function (record) {
                        return cartItemSvc.saveRecord({
                            product: record,
                            name: record.book.name,
                            quantity: 1});
                    },
                    show: function () {
                        return true;
                    }
                }];

            this.loadRefOptions();
            this.fetchRecords();
        }]);
})(window.angular);
