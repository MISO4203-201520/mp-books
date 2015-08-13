(function (ng) {

    var mainApp = ng.module('mainApp', [
        //'ngCrudMock',
        'authModule',
        'bookModule',
        'cartItemModule',
        'clientModule',
        'productModule',
        'providerModule',
        'ngRoute',
        'ngCrud'
    ]);

    mainApp.config(['$routeProvider', 'CrudTemplateURL', 'CrudCtrlAlias', function ($routeProvider, tplUrl, alias) {
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
                        controllerAs: alias
                    })
                    .when('/provider', {
                        templateUrl: tplUrl,
                        controller: 'providerCtrl',
                        controllerAs: alias
                    })
                    .otherwise('/');
        }]);

    mainApp.config(['authServiceProvider', function (auth) {
            auth.setValues({
                apiUrl: 'users',
                successPath: '/book',
                loginPath: '/login',
                registerPath: '/register',
                logoutRedirect: '/login',
                loginURL: 'login',
                registerURL: 'register',
                logoutURL: 'logout',
                nameCookie: 'userCookie'
            });
        }]);

})(window.angular);
