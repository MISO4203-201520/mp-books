(function(ng) {

    var mainApp = ng.module('mainApp', [
        //'ngCrudMock',
        'xeditable',
        'authModule',
        'bookModule',
        'cartItemModule',
        'clientModule',
        'productModule',
        'providerModule',
        'ngRoute',
        'ngCrud'

    ]);

    mainApp.config(['$routeProvider', 'CrudTemplateURL', 'CrudCtrlAlias', function($routeProvider, tplUrl, alias) {
            $routeProvider
                    .when('/book', {
                        templateUrl: tplUrl,
                        controller: 'bookCtrl',
                        controllerAs: alias
                    })
                    .when('/client', {
                        templateUrl: tplUrl,
                        controller: 'clientCtrl',
                        controllerAs: alias
                    })
                    .when('/shoppingCart', {
                        templateUrl: 'src/modules/cartItem/templates/ShoppingCart.html',
                        controller: 'cartItemCtrl',
                        controllerAs: 'ctrl'
                    })
                    .when('/products', {
                        templateUrl: tplUrl,
                        controller: 'productsCtrl',
                        controllerAs: alias
                    })
                    .when('/catalog', {
                        templateUrl: 'src/modules/product/product.tpl.html',
                        controller: 'productCtrl',
                        controllerAs: 'ctrl'
                    })
                    .otherwise('/catalog');
        }]);

    mainApp.config(['authServiceProvider', function(auth) {
            auth.setValues({
                apiUrl: 'users',
                successPath: '/catalog',
                loginPath: '/login',
                registerPath: '/register',
                logoutRedirect: '/login',
                loginURL: 'login',
                registerURL: 'register',
                logoutURL: 'logout',
                nameCookie: 'userCookie'
            });
        }]);

    mainApp.run(function(editableOptions) {
        editableOptions.theme = 'bs3'; // bootstrap3 theme. For Xeditable plugin Angular
    });

})(window.angular);
