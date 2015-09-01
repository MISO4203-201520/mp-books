(function (ng) {
    var mod = ng.module('productModule');

    mod.controller('productCtrl', ['CrudCreator', '$scope', 'productService', 'productModel', 'cartItemService', '$location', 'authService', 'bookService', function (CrudCreator, $scope, svc, model, cartItemSvc, $location, authSvc, bookSvc) {
            CrudCreator.extendController(this, svc, $scope, model, 'product', 'Products');
            this.detailsMode = false;
            this.searchByName = function (bookName) {
                var search;
                if (bookName) {
                    search = '?q=' + bookName;
                }
                $location.url('/catalog' + search);
            };
            var self = this;
            this.recordActions = {
                addToCart: {
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
                },
                reviews: {
                    displayName: 'Reviews',
                    icon: 'list',
                    class: 'info',
                    fn: function (record) {
                        bookSvc.api.get(record.book.id).then(function (data) {
                            self.detailsMode = true;
                            $scope.bookRecord = data;
                        });
                    },
                    show: function () {
                        return !self.detailsMode;
                    }
                }};

//            this.loadRefOptions();
            this.fetchRecords();
        }]);
})(window.angular);
