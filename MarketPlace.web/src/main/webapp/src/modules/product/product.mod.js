(function (ng) {
    var mod = ng.module('productModule', ['ngCrud']);

    mod.constant('productContext', 'products');

    mod.constant('productModel', {
        fields: [{
                name: 'price',
                displayName: 'Price',
                type: 'Currency',
                required: true
            }, {
                name: 'book',
                displayName: 'Book',
                type: 'Reference',
                service: 'bookService',
                options: [],
                required: true
            }]});
})(window.angular);
