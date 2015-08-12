(function (ng) {
    var mod = ng.module('clientModule', ['ngCrud']);

    mod.constant('clientContext', 'clients');

    mod.constant('clientModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true
            }, {
                name: 'phone',
                displayName: 'Phone',
                type: 'String',
                required: true
            }, {
                name: 'idCard',
                displayName: 'IdCard',
                type: 'String',
                required: true
            }, {
                name: 'email',
                displayName: 'Email',
                type: 'String',
                required: true
            }, {
                name: 'userId',
                displayName: 'UserId',
                type: 'String',
                required: true
            }], 
        childs: [{
                name: 'shoppingcart',
                displayName: 'Shoppingcart',
                //template: '', //override generic template
                ctrl: 'shoppingcartCtrl'            }        ]});
})(window.angular);
