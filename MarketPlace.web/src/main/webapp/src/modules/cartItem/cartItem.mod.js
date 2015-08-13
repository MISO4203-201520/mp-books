(function (ng) {
    var mod = ng.module('cartItemModule', ['ngCrud']);

    mod.constant('cartItemContext', 'cartItems');

    mod.constant('cartItemModel', {
            fields : [{
                    name: 'product',
                    displayName: 'Product',
                    type: 'Reference',
                    service: 'productService',
                    options: [],
                    required: true,
                    editOnList: false
                }, {
                    name: 'quantity',
                    displayName: 'Quantity',
                    type: 'Integer',
                    required: true,
                    editOnList: true
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
                    fn: function (record) {
                        return record.product.price * record.quantity;
                    }
                 

         }]});


})(window.angular);
