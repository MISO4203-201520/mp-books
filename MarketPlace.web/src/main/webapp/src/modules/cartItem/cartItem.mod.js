(function (ng) {
    var mod = ng.module('cartItemModule', ['ngCrud']);

    mod.constant('cartItemContext', 'cartItems');

    mod.constant('cartItemModel', {
            fields : [{
                name: 'product',
                displayName: 'Product',
                type: 'Computed',
                fn: function (record) {
                    return record.product.book.name;
                },
                required: true,
                editable: false,
                currency: false
            }, {
                name: 'quantity',
                displayName: 'Quantity',
                type: 'Integer',
                required: true,
                editable: true
            }, {
                name: 'Price',
                displayName: 'Price',
                type: 'Computed',
                fn: function (record) {
                    return record.product.price;
                },
                required: true,
                editable: false,
                currency: true
            }, {
                name: 'SubTotal',
                displayName: 'SubTotal',
                type: 'Computed',
                editable: false,
                fn: function (record) {
                    return record.product.price * record.quantity;
                }



            }]});


})(window.angular);
