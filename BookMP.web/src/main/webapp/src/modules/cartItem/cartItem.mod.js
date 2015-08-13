(function (ng) {
    var mod = ng.module('cartItemModule', ['ngCrud']);

    mod.constant('cartItemContext', 'cartItems');

    mod.constant('cartItemModel', {
        fields: [{
                name: 'quantity',
                displayName: 'Quantity',
                type: 'Integer',
                required: true
            }, {
                name: 'name',
                displayName: 'Name',
                type: 'String',
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
