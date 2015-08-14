(function (ng) {
    var mod = ng.module('productModule');

    mod.controller('productCtrl', ['CrudCreator', '$scope', 'productService', 'productModel', 'cartItemService', '$location', function (CrudCreator, $scope, svc, model, cartItemSvc, $location) {
            CrudCreator.extendController(this, svc, $scope, model, 'product', 'Products');
            this.itemsPerPage = 1;
            this.searchByName = function (bookName) {
                var search;
                console.log(bookName);
                if (bookName) {
                    search = '?q=' + bookName;
                }
                $location.url('/catalog' + search);
            };

            this.recordActions = [{
                    name: 'addToCart',
                    displayName: 'Add to Cart',
                    icon: 'shopping-cart',
                    class: 'primary',
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
